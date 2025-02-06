package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.RelatorioGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Relatorio.RelatorioMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.RelatorioPersistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.RelatorioEntity;

@Service
public class RelatorioInfraGateway implements RelatorioGateway{

    private final RelatorioPersistence relatorioRepository;
    private final RelatorioMapper relatorioMapper;

    public RelatorioInfraGateway(RelatorioPersistence relatorioRepository ,RelatorioMapper relatorioMapper) {
        this.relatorioRepository = relatorioRepository;
        this.relatorioMapper = relatorioMapper;
    }
    @Override
    public Optional<RelatorioDomain> getRelatorioByID(Long id) {
        return relatorioRepository.findById(id).map(relatorioMapper::entityToDomain);
    }
    @Override
    public List<RelatorioDomain> getRelatorio() {
        return relatorioRepository.findAll().stream().map(relatorioMapper::entityToDomain).toList();   
    }
    @Override
    public List<RelatorioDomain> getRelatorioByDate(LocalDate date) {
        return relatorioRepository.findByDataHoraRelatorio(date).stream().map(relatorioMapper::entityToDomain).toList();
    }
    @Override
    public void deleteRelatorio(Long id) {
        relatorioRepository.deleteById(id);
    }
    @Override
    public RelatorioDomain newRelatorio(RelatorioDomain relatorio) {
        RelatorioEntity relatorioEntity = relatorioMapper.toEntity(relatorio);
        RelatorioEntity savedEntity = relatorioRepository.save(relatorioEntity);
        return relatorioMapper.entityToDomain(savedEntity);
    }
    @Override
    public RelatorioDomain alterarRelatorio(Long id, RelatorioDomain relatorio) {
        RelatorioEntity relatorioEntity = relatorioMapper.toEntity(relatorio);
        relatorioRepository.updateRelatorio(relatorioEntity, id);
        return relatorioMapper.entityToDomain(relatorioEntity);
    }
}