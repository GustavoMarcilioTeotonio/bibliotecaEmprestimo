package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.LivroEmprestimoDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "LivroEmprestimos")
public class LivroEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date devolPrevista;
    private int quantLivro;

    public LivroEmprestimo () {}


    public LivroEmprestimo (Long id, Date devolPrevista, int quantLivro) {
        this.id = id;
        this.devolPrevista = devolPrevista;
        this.quantLivro = quantLivro;

    }

    public LivroEmprestimo (LivroEmprestimoDTO livroEmprestimoDTO){
        this.id = livroEmprestimoDTO.getId();
        this.devolPrevista = livroEmprestimoDTO.getDevolPrevista();
        this.quantLivro = livroEmprestimoDTO.getQuantLivro();

    }




}
