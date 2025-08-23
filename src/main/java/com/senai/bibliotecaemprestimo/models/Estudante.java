package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.EstudanteDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estudantes")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private String serie;
    private String telefone;

    public Estudante() {

    }

    public Estudante (Long id, String nome, String matricula, String telefone,  String serie) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.serie = serie;
    }

    public Estudante (EstudanteDTO estudanteDTO) {
        this.id = estudanteDTO.getId();
        this.nome = estudanteDTO.getNome();
        this.matricula = estudanteDTO.getMatricula();
        this.telefone = estudanteDTO.getTelefone();
        this.serie = estudanteDTO.getSerie();
    }

    @OneToMany(mappedBy = "estudante")
    private List<Emprestimo> emprestimos = new ArrayList<>();






}
