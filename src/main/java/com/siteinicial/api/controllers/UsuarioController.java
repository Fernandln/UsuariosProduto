package com.siteinicial.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siteinicial.api.repositories.UsuarioRepository;
import com.siteinicial.api.usuarios.AuthenticationDTO;
import com.siteinicial.api.usuarios.NovoUsuarioDTO;
import com.siteinicial.api.usuarios.Usuario;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;
    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody @Valid AuthenticationDTO dados) {
        var loginSenha = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = this.authenticationManager.authenticate(loginSenha);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid NovoUsuarioDTO dados) {
        if (this.repository.findByLogin(dados.login())!= null) return ResponseEntity.badRequest().build();

        String senhaSegura = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario novoUsuario = new Usuario(dados.login(), senhaSegura, dados.permissao(), dados.nome());

        this.repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
    
}
