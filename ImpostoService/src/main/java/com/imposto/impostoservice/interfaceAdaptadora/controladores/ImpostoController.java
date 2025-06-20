package com.imposto.impostoservice.interfaceAdaptadora.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imposto.impostoservice.aplicacao.casosDeUso.CalcularImpostosUC;
import com.imposto.impostoservice.aplicacao.dtos.ItemModelDTO;

import java.util.ArrayList;

@RestController
public class ImpostoController {
    CalcularImpostosUC calcularImpostosUC;

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return ("Imposto service test");
    }

    @PostMapping("impostoService/calcularImposto")
    @CrossOrigin(origins = "*")
    public double calcularImposto(@RequestBody ArrayList<ItemModelDTO> itens,
            @RequestParam String estado,
            @RequestParam String pais) {
        return calcularImpostosUC.run(itens, estado, pais);
    }
}