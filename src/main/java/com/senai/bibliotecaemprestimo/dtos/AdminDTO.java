
package com.senai.bibliotecaemprestimo.dtos;

import com.senai.bibliotecaemprestimo.models.Admin;
import com.senai.bibliotecaemprestimo.models.Estudante;
import lombok.Data;

@Data
public class AdminDTO {

    private Long id;
    private String usuario;
    private String senha;

    public AdminDTO () {

    }

    public AdminDTO (Admin admin) {
        this.id = admin.getId();
        this.usuario = admin.getUsuario();
        this.senha = admin.getSenha();

    }
}

