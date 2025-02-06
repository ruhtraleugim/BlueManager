package com.BlueSpectre.BlueManeger.Infra.Dto;

import com.BlueSpectre.BlueManeger.Core.Enum.TipoProduto;

public record FornecedorDTO(Long id,
                            double valorProdutoFornecedor,
                            String fornecedorEndereco,
                            String fornecedorNome,
                            String fornecedorTelefone,
                            String fornecedorEmail,
                            TipoProduto tipoProduto,
                            ProdutoDTO produtoDTO) {}