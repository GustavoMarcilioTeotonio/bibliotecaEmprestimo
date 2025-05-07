package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.EstudanteDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudantes")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private String numero;

    public Estudante() {

    }

    public Estudante (Long id, String nome, String matricula, String numero) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.numero = numero;
    }

    public Estudante (EstudanteDTO estudanteDTO) {
        this.id = estudanteDTO.getId();
        this.nome = estudanteDTO.getNome();
        this.matricula = estudanteDTO.getMatricula();
        this.numero = estudanteDTO.getNumero();
    }


}
