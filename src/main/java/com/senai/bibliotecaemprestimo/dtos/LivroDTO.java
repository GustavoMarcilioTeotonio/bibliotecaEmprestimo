package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Livro;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    private String nome;
    private String categoria;
    private int quantidade;

    public LivroDTO () {

    }

    public LivroDTO (Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.categoria = livro.getCategoria();
        this.quantidade = livro.getQuantidade();
    }

}