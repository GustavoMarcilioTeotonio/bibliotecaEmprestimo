package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Estudante;
import lombok.Data;

@Data
public class EstudanteDTO {

    private Long id;
    private String nome;
    private String matricula;
    private String telefone;
    private String serie;

    public EstudanteDTO () {

    }

    public EstudanteDTO (Estudante estudante) {
        this.id = estudante.getId();
        this.nome = estudante.getNome();
        this.matricula = estudante.getMatricula();
        this.telefone = estudante.getTelefone();
        this.serie = estudante.getSerie();

    }

}
