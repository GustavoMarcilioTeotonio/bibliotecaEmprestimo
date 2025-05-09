package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Livro;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    private String nome;

    public LivroDTO () {

    }

    public LivroDTO (Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
    }

}