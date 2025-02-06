package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.DebitoGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Debito.DebitoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.DebitoPersistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.DebitoEntity;


@Service
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
        DebitoEntity savedEntity = debitoRepository.save(entity);
        return  debitoMapper.entityToDomain(savedEntity);
    }
    @Override
    public List<DebitoDomain> GetDebito() {
        return debitoRepository.findAll().stream().map(debitoMapper::entityToDomain).toList();
    }
    @Override
    public List<DebitoDomain> getDebitosByDate(LocalDate date) {
        return debitoRepository.findByDataDebito(date).stream().map(debitoMapper::entityToDomain).toList();
    }
    @Override
    public void deleteDebito(Long id) {
        debitoRepository.deleteById( id);
    }
    @Override
    public Optional<DebitoDomain> getDebitosByID(Long id) {
        return debitoRepository.findById(id).map(debitoMapper::entityToDomain);
    }
    @Override
    public DebitoDomain AlterarDebito(DebitoDomain debito, Long id) {
        DebitoEntity entity = debitoMapper.toEntity(debito);
        debitoRepository.updateDebito(entity, id);
        return debitoMapper.entityToDomain(entity);
    }
}