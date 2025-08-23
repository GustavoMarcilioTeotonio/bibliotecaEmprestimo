package com.senai.bibliotecaemprestimo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senai.bibliotecaemprestimo.dtos.EmprestimoDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEmprestimo;
    private Date devolPrevista;
    private Date dataDevol;
    private Double multa;


    public Emprestimo() {

    }

    public Emprestimo(Long id, Date dataEmprestimo, Date devolPrevista, Date dataDevol, Double multa) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.devolPrevista = devolPrevista;
        this.dataDevol = dataDevol;
        this.multa = multa;
    }

    public Emprestimo(EmprestimoDTO emprestimoDTO) {
        this.id = emprestimoDTO.getId();
        this.dataEmprestimo = emprestimoDTO.getDataEmprestimo();
        this.devolPrevista = emprestimoDTO.getDevolPrevista();
        this.dataDevol = emprestimoDTO.getDataDevol();
        this.multa = emprestimoDTO.getMulta();
    }

    // Muitos empréstimos para um estudante
    @ManyToOne
    @JoinColumn(name = "estudante_id")  // cria a FK na tabela emprestimo
    private Estudante estudante;

    // ligação com LivroEmprestimo (N:N com Livro)
    @OneToMany(mappedBy = "emprestimo")
    private List<LivroEmprestimo> livros = new ArrayList<>();


}
