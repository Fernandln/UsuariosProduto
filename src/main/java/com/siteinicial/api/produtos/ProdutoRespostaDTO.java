package com.siteinicial.api.produtos;

public record ProdutoRespostaDTO(String id, String nome, String preco) {
    public ProdutoRespostaDTO(Produto produto) {
        
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }
    
}
