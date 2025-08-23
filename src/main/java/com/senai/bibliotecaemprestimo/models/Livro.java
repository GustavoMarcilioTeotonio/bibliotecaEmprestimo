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
    private String categoria;
    private int quantidade;

    public Livro() {

    }

    public Livro (Long id, String nome, String categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;

    }

    public Livro (LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.nome = livroDTO.getNome();
        this.categoria = livroDTO.getCategoria();
        this.quantidade = livroDTO.getQuantidade();
    }



}