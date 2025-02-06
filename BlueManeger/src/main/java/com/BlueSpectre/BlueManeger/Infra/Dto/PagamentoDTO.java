package com.BlueSpectre.BlueManeger.Infra.Dto;

import java.time.LocalDate;

import com.BlueSpectre.BlueManeger.Core.Enum.StatusPagamento;
import com.BlueSpectre.BlueManeger.Core.Enum.TipoPagamento;

public record PagamentoDTO( Long id,
                            double valorPago,
                            String cpfCobrador,
                            String recebedorPagamento,
                            LocalDate dataPagamento,
                            TipoPagamento formaPagamento,
                            StatusPagamento statusPagamento) {}