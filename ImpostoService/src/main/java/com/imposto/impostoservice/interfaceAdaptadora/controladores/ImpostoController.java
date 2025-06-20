package com.imposto.impostoservice.interfaceAdaptadora.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imposto.impostoservice.dominio.entidades.ItemModel;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ImpostoController {
    @GetMapping("imposto")
    @CrossOrigin(origins = "*")
    public void getImposto(@RequestBody ItemModel dto){
        return;
    }
}