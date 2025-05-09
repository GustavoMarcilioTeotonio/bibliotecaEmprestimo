package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Multa;
import lombok.Data;

import java.util.Date;

@Data
public class MultaDTO {

    private Long id;
    private Double valor;
    private int diasAtraso;
    private Date dataMulta;
    private Boolean paga;

    public MultaDTO () {

    }

    public MultaDTO (Multa multa) {
        this.id = multa.getId();
        this.valor = multa.getValor();
        this.diasAtraso = multa.getDiasAtraso();
        this.dataMulta = multa.getDataMulta();
        this.paga = multa.getPaga();
    }
}
