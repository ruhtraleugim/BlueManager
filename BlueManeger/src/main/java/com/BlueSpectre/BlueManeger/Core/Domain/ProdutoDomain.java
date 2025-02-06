package com.BlueSpectre.BlueManeger.Core.Domain;

import java.time.LocalDate;
import com.BlueSpectre.BlueManeger.Core.Enum.TipoProduto;

public record ProdutoDomain(Long idProduto,
                           String descricaoProduto,
                           String nomeProduto,
                           LocalDate validadeProduto,
                           TipoProduto tipoProduto,
                           double valorProduto,
                           FornecedorDomain fornecedorDomain) {}