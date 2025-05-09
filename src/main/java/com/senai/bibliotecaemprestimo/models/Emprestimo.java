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
    private Date dataDevolucao;

    public Emprestimo() {

    }

    public Emprestimo(Long id, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(EmprestimoDTO emprestimoDTO) {
        this.id = emprestimoDTO.getId();
        this.dataEmprestimo = emprestimoDTO.getDataEmprestimo();
        this.dataDevolucao = emprestimoDTO.getDataDevolucao();
    }

    @ManyToOne
    @JsonIgnoreProperties("emprestimos")
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @JsonIgnoreProperties("emprestimos")
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @OneToOne(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private Multa multa;
}
