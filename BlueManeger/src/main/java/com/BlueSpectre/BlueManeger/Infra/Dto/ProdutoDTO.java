package com.BlueSpectre.BlueManeger.Infra.Dto;

import java.time.LocalDate;

import com.BlueSpectre.BlueManeger.Core.Enum.TipoProduto;

public record ProdutoDTO(Long idProduto,
                           String descricaoProduto,
                           String nomeProduto,
                           LocalDate validadeProduto,
                           TipoProduto tipoProduto,
                           double valorProduto,
                           FornecedorDTO fornecedorDTO) {}