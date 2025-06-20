package com.projarc.assignment1.aplicacao.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.projarc.assignment1.dominio.entidades.EnderecoModel;
import com.projarc.assignment1.dominio.entidades.ItemPedidoModel;
import com.projarc.assignment1.dominio.entidades.OrcamentoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrcamentoDTO {
    private long id;
    private LocalDate data = LocalDate.now();
    private String nomeCliente;
    private List<ItemPedidoDTO> itens;
    private EnderecoModel endereco;
    private double somatorioCustoItens;
    private double impostoEstadual;
    private double impostoFederal;
    private double desconto;
    private double valorFinal;
    private OrcamentoModel.Status status;

    public static OrcamentoDTO fromModel(OrcamentoModel orcamento){
        List<ItemPedidoDTO> itens = new ArrayList<>(orcamento.getItens().size());
        for(ItemPedidoModel ip:orcamento.getItens()){
            itens.add(ItemPedidoDTO.fromModel(ip));
        }
        return new OrcamentoDTO(
            orcamento.getId(),
            orcamento.getData(),
            orcamento.getNomeCliente(),
            itens,
            orcamento.getEndereco(),
            orcamento.getSomatorioCustoItens(),
            orcamento.getImpostoEstadual(),
            orcamento.getImpostoFederal(),
            orcamento.getDesconto(),
            orcamento.getValorFinal(),
            orcamento.getStatus()
        );
    }
}
