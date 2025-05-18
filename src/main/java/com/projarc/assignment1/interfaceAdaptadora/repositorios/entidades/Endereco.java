package com.projarc.assignment1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String estado;
    private String pais;
}
