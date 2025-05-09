package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.MultaDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "multas")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;          
    private int diasAtraso;   
    private Date dataMulta;     
    private Boolean paga;

    public Multa() {

    }

    public Multa (Long id, Double valor, int diasAtraso, Date dataMulta, Boolean paga) {
        this.id = id;
        this.valor = valor;
        this.diasAtraso = diasAtraso;
        this.dataMulta = dataMulta;
        this.paga = paga;
    }

    public Multa (MultaDTO multaDTO) {
        this.id = multaDTO.getId();
        this.valor = multaDTO.getValor();
        this.diasAtraso = multaDTO.getDiasAtraso();
        this.dataMulta = multaDTO.getDataMulta();
        this.paga = multaDTO.getPaga();
    }

    @OneToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;

    @ManyToOne
    private Estudante estudante;

    @ManyToOne
    private Livro livro;
}
