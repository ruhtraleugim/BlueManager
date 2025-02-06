package com.BlueSpectre.BlueManeger.Infra.Dto;

import java.time.LocalDateTime;

public record VendaDTO(Long idVenda,
                        int quantidadeProduto,
                        double valorVenda,
                        LocalDateTime dataVenda,
                        ProdutoDTO produtoVenda,
                        PagamentoDTO pagamento){}