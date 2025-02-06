package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;


public interface RelatorioGateway {

        Optional<RelatorioDomain> getRelatorioByID(Long ID);

        List<RelatorioDomain> getRelatorio();

        List<RelatorioDomain> getRelatorioByDate(LocalDate date);

        void deleteRelatorio(Long ID);

        RelatorioDomain newRelatorio(RelatorioDomain relatorio);

        RelatorioDomain alterarRelatorio(Long ID, RelatorioDomain relatorio);
        
} 