package com.projarc.assignment1.aplicacao.casosDeUso;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.projarc.assignment1.aplicacao.dtos.ItemPedidoDTO;
import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;
import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import com.projarc.assignment1.dominio.entidades.PedidoModel;
import com.projarc.assignment1.dominio.entidades.ProdutoModel;
import com.projarc.assignment1.dominio.servicos.ServicoDeEstoque;
import com.projarc.assignment1.dominio.servicos.ServicoDeVendas;

@Component
@RequiredArgsConstructor
public class CriaOrcamentoUC {
    private ServicoDeVendas servicoDeVendas;
    private ServicoDeEstoque servicoDeEstoque;

    public OrcamentoDTO run(OrcamentoDTO dto) {
        PedidoModel pedido = new PedidoModel(0);
        for (ItemPedidoDTO item : dto.getItens()) {
            ProdutoModel produto = servicoDeEstoque.produtoPorCodigo(item.getIdProduto());
            ItemPedidoModel itemPedido = new ItemPedidoModel(produto, item.getQtdade());
            pedido.addItem(itemPedido);
        }

        String estado = dto.getEndereco().getEstado();
        String pais = dto.getEndereco().getPais();

        OrcamentoModel orcamento = servicoDeVendas.criaOrcamento(pedido, pais, estado);
        return OrcamentoDTO.fromModel(orcamento);
    }
}
