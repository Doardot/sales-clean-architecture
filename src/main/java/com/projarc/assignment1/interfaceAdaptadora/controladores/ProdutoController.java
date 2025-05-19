package com.projarc.assignment1.interfaceAdaptadora.controladores;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import com.projarc.assignment1.aplicacao.casosDeUso.AdicionaProdutoUC;
import com.projarc.assignment1.aplicacao.casosDeUso.ListarQtdProdutosSelecionadosUC;
import com.projarc.assignment1.aplicacao.casosDeUso.ListarQtdProdutosUC;
import com.projarc.assignment1.aplicacao.dtos.ItemDeEstoqueDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarc.assignment1.aplicacao.casosDeUso.ProdutosDisponiveisUC;
import com.projarc.assignment1.aplicacao.dtos.ProdutoDTO;

@RestController
@AllArgsConstructor
public class ProdutoController {
    private ProdutosDisponiveisUC produtosDisponiveis;
    private AdicionaProdutoUC adicionaProdutoUC;
    private ListarQtdProdutosUC listarQtdProdutosUC;
    private ListarQtdProdutosSelecionadosUC listarQtdProdutosSelecionadosUC;

    @GetMapping("catalogoProdutos")
    public List<ProdutoDTO> listarTodosProdutos(){
        return produtosDisponiveis.run();
    }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> produtosDisponiveis(){
        return produtosDisponiveis.run();
    }

    @PostMapping("adicionarProduto/{id}")
    @CrossOrigin(origins = "*")
    public int adicionarProduto(@PathVariable(value="id") long idProduto, @RequestBody int qtdProduto){
        return adicionaProdutoUC.run(idProduto, qtdProduto);
    }

    @GetMapping("listarQtdProdutos")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoqueDTO> listarQtdProdutos(){
        return listarQtdProdutosUC.run();
    }

    @GetMapping("listarQtdProdutosSelecionados")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoqueDTO> listarQtdProdutosSelecionados(@RequestBody List<Long> idProdutos){
        return listarQtdProdutosSelecionadosUC.run(idProdutos);
    }
}