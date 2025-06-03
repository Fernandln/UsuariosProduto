package com.siteinicial.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siteinicial.api.produtos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    
}
