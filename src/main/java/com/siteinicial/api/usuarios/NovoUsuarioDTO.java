package com.siteinicial.api.usuarios;

public record NovoUsuarioDTO(String nome, String login, String senha, Permissao permissao) {
}
