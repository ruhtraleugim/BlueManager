package com.BlueSpectre.BlueManeger.Infra.Dto;

import java.time.LocalDateTime;

public record RelatorioDTO(Long idRelatorio,
                            double lucroEsperado,
                            double lucroPorProduto,
                            LocalDateTime dataHoraRelatorio,
                            EstoqueDTO estoque, 
                            VendaDTO venda) {}