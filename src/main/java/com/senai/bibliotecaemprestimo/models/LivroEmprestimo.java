package com.senai.bibliotecaemprestimo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LivroEmprestimos")
public class LivroEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;




}
