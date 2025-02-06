package com.BlueSpectre.BlueManeger.Core.Domain;

import java.time.LocalDate;

import com.BlueSpectre.BlueManeger.Core.Enum.StatusPagamento;
import com.BlueSpectre.BlueManeger.Core.Enum.TipoPagamento;

public record PagamentoDomain(Long idPagamento,
                            double valorPago,
                            String cpfCobrador,
                            String recebedorPagamento,
                            LocalDate dataPagamento,
                            TipoPagamento formaPagamento,
                            StatusPagamento statusPagamento) {}  