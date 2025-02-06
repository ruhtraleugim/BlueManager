package com.BlueSpectre.BlueManeger.Infra.Mapper.Debito;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;
import com.BlueSpectre.BlueManeger.Infra.Dto.DebitoDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.MapperInteface;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Pagamento.PagamentoMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.DebitoEntity;



@Component
public class DebitoMapper implements MapperInteface<DebitoDomain, DebitoDTO, DebitoEntity> {

    private final PagamentoMapper pagamentoMapper;

    public DebitoMapper(@Lazy PagamentoMapper pagamentoMapper) {
        this.pagamentoMapper = pagamentoMapper;
    }
    @Override
    public DebitoDomain toDomain(DebitoDTO debitoDTO) {
        if (debitoDTO == null) {
            return null;
        }
        return new DebitoDomain(debitoDTO.idDebito(),
                                debitoDTO.dataDebito(),
                                debitoDTO.valorDebito(),
                                debitoDTO.descricaoConta(),
                                debitoDTO.tipoConta(),
                                pagamentoMapper.toDomain(debitoDTO.pagamento()));
    }
    @Override
    public DebitoDTO toDto(DebitoDomain debitoDomain) {
        if (debitoDomain == null) {
            return null;
        }
        return new DebitoDTO(debitoDomain.idDebito(),
                            debitoDomain.dataDebito(),
                            debitoDomain.valorDebito(),
                            debitoDomain.descricaoConta(),
                            debitoDomain.tipoConta(),
                            pagamentoMapper.toDto(debitoDomain.pagamento()));
        
    }
    @Override
    public DebitoEntity toEntity(DebitoDomain debitoDomain) {
        if (debitoDomain == null) {
            return null;
        }
        return new DebitoEntity(debitoDomain.idDebito(),
                                debitoDomain.dataDebito(),
                                debitoDomain.valorDebito(),
                                debitoDomain.descricaoConta(),
                                debitoDomain.tipoConta(),
                                pagamentoMapper.toEntity(debitoDomain.pagamento()));
    }
    @Override
    public DebitoDomain entityToDomain(DebitoEntity debitoEntity) {
        if (debitoEntity == null) {
            return null;
        }
        return new DebitoDomain(debitoEntity.getId(),
                                debitoEntity.getDataDebito(),
                                debitoEntity.getValorDebito(),
                                debitoEntity.getDescricaoConta(),
                                debitoEntity.getTipoConta(),
                                pagamentoMapper.entityToDomain(debitoEntity.getPagamento()));
    }
    @Override
    public DebitoDTO entityToDto(DebitoEntity debitoEntity) {
        return new DebitoDTO(debitoEntity.getId(),
                            debitoEntity.getDataDebito(),
                            debitoEntity.getValorDebito(),
                            debitoEntity.getDescricaoConta(),
                            debitoEntity.getTipoConta(),
                            pagamentoMapper.entityToDto(debitoEntity.getPagamento()));
    }

}