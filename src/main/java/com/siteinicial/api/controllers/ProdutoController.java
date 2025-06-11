package com.siteinicial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siteinicial.api.produtos.Produto;
import com.siteinicial.api.produtos.ProdutoDTO;
import com.siteinicial.api.repositories.ProdutoRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping()
    public ResponseEntity novoProduto(@RequestBody @Valid ProdutoDTO entity) {
        Produto produto = new Produto(entity);
        this.repository.save(produto);    
        
        return ResponseEntity.ok().build();
    }
    
}
