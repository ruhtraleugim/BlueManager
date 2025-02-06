package com.BlueSpectre.BlueManeger.Core.Domain;

import java.time.LocalDate;

public record DebitoDomain(Long idDebito,
                           LocalDate dataDebito,
                           double valorDebito,
                           String descricaoConta,
                           String tipoConta,
                           PagamentoDomain pagamento){}