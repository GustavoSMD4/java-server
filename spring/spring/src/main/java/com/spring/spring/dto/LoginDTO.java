package com.spring.spring.dto;

import com.spring.spring.utilidades.Criptografar;

public class LoginDTO {
    private String usuario;
    private String senha;

    public LoginDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = new Criptografar().criptografarSHA256(senha);
    }

}
