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


    public EmprestimoDTO() {

    }

    public EmprestimoDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
    }
}
