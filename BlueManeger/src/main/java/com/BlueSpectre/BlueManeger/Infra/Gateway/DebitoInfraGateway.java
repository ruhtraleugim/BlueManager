package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Debito.DebitoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.DebitoPersistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.DebitoEntity;

@Service
@Slf4j
public class DebitoInfraGateway implements DebitoGateway {

    private final DebitoPersistence debitoRepository;
    private final DebitoMapper debitoMapper;

    public DebitoInfraGateway(DebitoPersistence debitoRepository, DebitoMapper debitoMapper) {
        this.debitoRepository = debitoRepository;
        this.debitoMapper = debitoMapper;
    }
    @Override
    public DebitoDomain newDebito(DebitoDomain debito) {
        DebitoEntity entity = debitoMapper.toEntity(debito);
        log.info("Debito Sendo Gerado.");
        DebitoEntity savedEntity = debitoRepository.save(entity);
        log.info("Debito Gerado com sucesso!");
        return  debitoMapper.entityToDomain(savedEntity);
    }
    @Override
    public List<DebitoDomain> GetDebito() {
        log.info("Procurando Debitos.");
        return debitoRepository.findAll().stream().map(debitoMapper::entityToDomain).toList();
    }
    @Override
    public List<DebitoDomain> getDebitosByDate(LocalDate date) {
        log.info("Procurando Debitos por data.");
        return debitoRepository.findByDataDebito(date).stream().map(debitoMapper::entityToDomain).toList();
    }
    @Override
    public void deleteDebito(Long id) {
        log.info("Deletando Debito.");
        debitoRepository.deleteById( id);
        log.info("Debito deletado com sucesso!");
    }
    @Override
    public Optional<DebitoDomain> getDebitosByID(Long id) {
        log.info("Procurando Debitos por id.");
        return debitoRepository.findById(id).map(debitoMapper::entityToDomain);
    }
    @Override
    public DebitoDomain updateDebito(DebitoDomain debito, Long id) {
        DebitoEntity entity = debitoMapper.toEntity(debito);
        log.info("Realizando Update das Informações do Debito.");
        debitoRepository.updateDebito(entity, id);
        log.info("Update Realizado com Sucesso!");
        return debitoMapper.entityToDomain(entity);
    }
}