package com.projarc.assignment1.interfaceAdaptadora.controladores;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarc.assignment1.aplicacao.casosDeUso.CriaOrcamentoUC;
import com.projarc.assignment1.aplicacao.casosDeUso.EfetivaOrcamentoUC;
import com.projarc.assignment1.aplicacao.casosDeUso.ProdutosDisponiveisUC;
import com.projarc.assignment1.aplicacao.dtos.ItemPedidoDTO;
import com.projarc.assignment1.aplicacao.dtos.OrcamentoDTO;
import com.projarc.assignment1.aplicacao.dtos.ProdutoDTO;

@RestController
@AllArgsConstructor
public class ProdutoController {
    private ProdutosDisponiveisUC produtosDisponiveis;

    @GetMapping("catalogoProdutos")
    public List<ProdutoDTO> listarTodosProdutos(){
        return produtosDisponiveis.run();
    }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> produtosDisponiveis(){
        return produtosDisponiveis.run();
    }
}