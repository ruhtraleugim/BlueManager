package com.BlueSpectre.BlueManeger.Infra.Mapper.Pagamento;

import org.springframework.stereotype.Component;

import com.BlueSpectre.BlueManeger.Core.Domain.PagamentoDomain;
import com.BlueSpectre.BlueManeger.Infra.Dto.PagamentoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.MapperInteface;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.PagamentoEntity;

@Component
public class PagamentoMapper implements MapperInteface<PagamentoDomain, PagamentoDTO, PagamentoEntity>{

    @Override
    public PagamentoDomain toDomain(PagamentoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new PagamentoDomain(dto.id(),
                                   dto.valorPago(),
                                   dto.cpfCobrador(),
                                   dto.recebedorPagamento(),
                                   dto.dataPagamento(),
                                   dto.formaPagamento(),
                                   dto.statusPagamento());
    }
    @Override
    public  PagamentoDTO toDto(PagamentoDomain domain) {
        if (domain == null) {
            return null;
        }
        return new PagamentoDTO(domain.idPagamento(),
                                domain.valorPago(),
                                domain.cpfCobrador(),
                                domain.recebedorPagamento(),
                                domain.dataPagamento(),
                                domain.formaPagamento(),
                                domain.statusPagamento());
    }
    @Override
    public PagamentoEntity toEntity(PagamentoDomain domain) {
        if (domain == null) {
            return null;
        }
        return new PagamentoEntity(domain.idPagamento(),
                                domain.valorPago(),
                                domain.cpfCobrador(),
                                domain.recebedorPagamento(),
                                domain.dataPagamento(),
                                domain.formaPagamento(),
                                domain.statusPagamento());
    }
    @Override
    public PagamentoDomain entityToDomain(PagamentoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new PagamentoDomain(entity.getIdPagamento(),
                                   entity.getValorPagamento(),
                                   entity.getCpfCobrador(),
                                   entity.getRecebedorPagamento(),
                                   entity.getDataPagamento(),
                                   entity.getTipoPagamento(),
                                   entity.getStatusPagamento());
    }
    @Override
    public PagamentoDTO entityToDto(PagamentoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new PagamentoDTO(entity.getIdPagamento(),
                                entity.getValorPagamento(),
                                entity.getCpfCobrador(),
                                entity.getRecebedorPagamento(),
                                entity.getDataPagamento(),
                                entity.getTipoPagamento(),
                                entity.getStatusPagamento());
    }
}