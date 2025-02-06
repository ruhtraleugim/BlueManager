package com.BlueSpectre.BlueManeger.Infra.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;
import com.BlueSpectre.BlueManeger.Core.Gateway.VendaGateway;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Venda.VendaMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.VendaPersistence;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.VendaEntity;

@Service
public class VendaInfraGateway implements VendaGateway{
    
    private final VendaPersistence vendaRepository;
    private final VendaMapper vendaMapper ;

    public VendaInfraGateway(VendaPersistence vendaRepository ,VendaMapper vendaMapper) {
        this.vendaRepository = vendaRepository;
        this.vendaMapper = vendaMapper;
    }
    @Override
    public Optional<VendaDomain> getVendaByID(Long id) {
        return vendaRepository.findById(id).map(vendaMapper::entityToDomain);
    }
    @Override
    public List<VendaDomain> getVendasByDate(LocalDate Data) {
        return vendaRepository.findByDataVenda(Data).stream().map(vendaMapper::entityToDomain).toList();
    }
    @Override
    public List<VendaDomain> getVendas() {
        return vendaRepository.findAll().stream().map(vendaMapper::entityToDomain).toList();
    }
    @Override
    public void deleteVenda(Long id) {
        vendaRepository.deleteById(id);
    }
    @Override
    public VendaDomain newVenda(VendaDomain venda) {
        VendaEntity vendaEntity = vendaMapper.toEntity(venda);
        VendaEntity savedEntity = vendaRepository.save(vendaEntity);
        return vendaMapper.entityToDomain(savedEntity);
    }
    @Override
    public VendaDomain alterarVenda(VendaDomain venda, Long id) {
        VendaEntity relatorioEntity = vendaMapper.toEntity(venda);
        vendaRepository.updateVenda(relatorioEntity, id);
        return vendaMapper.entityToDomain(relatorioEntity);
    }   
}