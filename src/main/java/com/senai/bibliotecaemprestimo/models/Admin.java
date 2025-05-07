package com.senai.bibliotecaemprestimo.models;

import com.senai.bibliotecaemprestimo.dtos.AdminDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;

    public Admin () {

    }

    public Admin (Long id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Admin (AdminDTO adminDTO) {
        this.id = adminDTO.getId();


    }
}
