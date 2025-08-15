package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.LivroEmprestimo;
import lombok.Data;

import java.util.Date;
@Data
public class LivroEmprestimoDTO {

    private Long id;
    private Date devolPrevista;
    private int quantLivro;

    LivroEmprestimoDTO(){}

    LivroEmprestimoDTO(LivroEmprestimo livroEmprestimo){
        this.id = livroEmprestimo.getId();
        this.devolPrevista = livroEmprestimo.getDevolPrevista();
        this.quantLivro = livroEmprestimo.getQuantLivro();

    }
}
