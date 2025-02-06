package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.PagamentoGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Pagamento.PagamentoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.PagamentoPersistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.PagamentoEntity;

@Service
public class PagamentoInfraGateway implements PagamentoGateway {

    private final PagamentoPersistence pagamentoRepository;
    private final PagamentoMapper pagamentoMapper;

    public PagamentoInfraGateway(PagamentoPersistence pagamentoRepository, PagamentoMapper pagamentoMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoMapper = pagamentoMapper;
    }
    @Override
    public Optional<PagamentoDomain> getPagamentoByID(Long id) {
        return pagamentoRepository.findById(id).map(pagamentoMapper::entityToDomain);
    }
    @Override
    public List<PagamentoDomain> getPagamentos() {
        return pagamentoRepository.findAll().stream().map(pagamentoMapper::entityToDomain).toList();
    }
    @Override
    public List<PagamentoDomain> getPagamentoByDate(LocalDate date) {
        return pagamentoRepository.findByDataPagamento(date).stream().map(pagamentoMapper::entityToDomain).toList();
    }
    @Override
    public PagamentoDomain newPagamentoModel(PagamentoDomain pagamento) {
        PagamentoEntity pagamentoEntity = pagamentoMapper.toEntity(pagamento);
        PagamentoEntity savedEntity = pagamentoRepository.save(pagamentoEntity);
        return pagamentoMapper.entityToDomain(savedEntity);
    }
    @Override
    public PagamentoDomain alterarPagamentoModel(Long id, PagamentoDomain pagamento) {
        PagamentoEntity pagamentoEntity = pagamentoMapper.toEntity(pagamento);
        pagamentoRepository.updatePagamento(pagamentoEntity, id);
        return pagamentoMapper.entityToDomain(pagamentoEntity);
    }
    @Override
    public void deletePagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }
}