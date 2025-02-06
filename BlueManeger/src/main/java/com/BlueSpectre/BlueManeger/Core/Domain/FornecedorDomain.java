package com.BlueSpectre.BlueManeger.Core.Domain;

import com.BlueSpectre.BlueManeger.Core.Enum.TipoProduto;

public record FornecedorDomain(Long idFornecedor,
                             double valorProdutoFornecedor,
                             String fornecedorEndereco,
                             String fornecedorNome,
                             String fornecedorTelefone,
                             String fornecedorEmail,
                             TipoProduto tipoProduto,
                             ProdutoDomain produto) {} 