package com.siteinicial.api.produtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
    @NotBlank
    String nome,

    @NotNull
    String preco

) {
}
