package com.projarc.assignment1.aplicacao.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projarc.assignment1.dominio.servicos.ServicoDeImposto;
import com.projarc.assignment1.interfaceAdaptadora.dtos.ItemModelDTO;
import com.projarc.assignment1.interfaceAdaptadora.proxies.ImpostoServiceProxy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoDeImpostoImpl implements ServicoDeImposto {

    private final ImpostoServiceProxy proxy;

    @Override
    public double calcularImposto(ArrayList<ItemModelDTO> itens, String estado, String pais) {
        return proxy.calcularImposto(itens, estado, pais);
    }
}
