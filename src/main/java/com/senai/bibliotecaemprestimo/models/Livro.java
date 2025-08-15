package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.LivroDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Livro() {

    }

    public Livro (Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Livro (LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.nome = livroDTO.getNome();
    }



}