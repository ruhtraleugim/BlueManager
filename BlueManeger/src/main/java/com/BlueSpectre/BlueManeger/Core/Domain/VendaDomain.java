package com.BlueSpectre.BlueManeger.Core.Domain;

import java.time.LocalDateTime;

public record VendaDomain(Long idVenda,
                        int quantidadeProduto,
                        double valorVenda,
                        LocalDateTime dataVenda,
                        ProdutoDomain produtoVenda,
                        PagamentoDomain pagamento){}