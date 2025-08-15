package com.senai.bibliotecaemprestimo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senai.bibliotecaemprestimo.dtos.EmprestimoDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEmprestimo;

    public Emprestimo() {

    }

    public Emprestimo(Long id, Date dataEmprestimo) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Emprestimo(EmprestimoDTO emprestimoDTO) {
        this.id = emprestimoDTO.getId();
        this.dataEmprestimo = emprestimoDTO.getDataEmprestimo();
    }


}
