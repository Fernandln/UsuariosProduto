package com.siteinicial.api.usuarios;

public enum Permissao {
    ADMIN("admin"),
    USER("user");


    private String permissao;

    Permissao(String permissao) {
        this.permissao = permissao;
    }


    public String GetPermissao() {
        return this.permissao;
    }
}
