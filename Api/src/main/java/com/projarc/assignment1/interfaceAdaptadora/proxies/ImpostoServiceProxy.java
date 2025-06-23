package com.projarc.assignment1.interfaceAdaptadora.proxies;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.projarc.assignment1.aplicacao.dtos.ImpostoDTO;
import com.projarc.assignment1.dominio.entidades.ItemImpostoModel;

@FeignClient(name = "impostoService", url = "http://localhost:8100")
public interface ImpostoServiceProxy {

    @PostMapping("/impostoService/calcularImposto")
    public ImpostoDTO calcularImposto(@RequestBody List<ItemImpostoModel> itens,
            @RequestParam String estado,
            @RequestParam String pais);
}