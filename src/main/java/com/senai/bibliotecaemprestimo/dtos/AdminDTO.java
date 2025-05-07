package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Admin;

public class AdminDTO {

    private Long id;
    private String usuario;
    private String senha;

    public AdminDTO (Long id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;

    }

    public AdminDTO (Admin admin) {
        this.id = admin.getId();
        this.usuario = admin.getUsuario();
        this.senha = admin.getSenha();
    }
}
