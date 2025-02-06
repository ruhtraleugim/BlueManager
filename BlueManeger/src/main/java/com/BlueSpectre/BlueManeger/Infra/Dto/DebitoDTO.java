package com.BlueSpectre.BlueManeger.Infra.Dto;

import java.time.LocalDate;

public record DebitoDTO(Long idDebito,
                        LocalDate dataDebito,
                        double valorDebito,
                        String descricaoConta,
                        String tipoConta,
                        PagamentoDTO pagamento) {}