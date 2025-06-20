package com.projarc.assignment1.interfaceAdaptadora.proxies;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.projarc.assignment1.aplicacao.dtos.ItemModelDTO;

@FeignClient(name = "impostoService")
public interface ImpostoServiceProxy {

    @PostMapping("impostoService/calcularImposto")
    public double calcularImposto(@RequestBody ArrayList<ItemModelDTO> itens,
            @RequestParam String estado,
            @RequestParam String pais);
}
