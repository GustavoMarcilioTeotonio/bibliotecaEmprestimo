package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Emprestimo;
import com.senai.bibliotecaemprestimo.models.Estudante;
import com.senai.bibliotecaemprestimo.models.Livro;
import lombok.Data;

import java.util.Date;

@Data
public class EmprestimoDTO {

    private Long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Estudante estudante;
    private Livro livro;

    public EmprestimoDTO() {

    }

    public EmprestimoDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataDevolucao = emprestimo.getDataDevolucao();
    }
}
