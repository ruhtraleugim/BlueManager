package com.BlueSpectre.BlueManeger.Infra.Mapper.Relatorio;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.BlueSpectre.BlueManeger.Core.Domain.RelatorioDomain;
import com.BlueSpectre.BlueManeger.Infra.Dto.RelatorioDTO;
import com.BlueSpectre.BlueManeger.Infra.Mapper.MapperInteface;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Estoque.EstoqueMapper;
import com.BlueSpectre.BlueManeger.Infra.Mapper.Venda.VendaMapper;
import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.RelatorioEntity;


@Component
public class RelatorioMapper implements MapperInteface<RelatorioDomain, RelatorioDTO, RelatorioEntity> {

    private final EstoqueMapper estoqueMapper;
    private final VendaMapper vendaMapper;

    private RelatorioMapper(@Lazy EstoqueMapper estoqueMapper,@Lazy VendaMapper vendaMapper) {
        this.estoqueMapper = estoqueMapper;
        this.vendaMapper = vendaMapper;
    }
    @Override
    public RelatorioDomain toDomain(RelatorioDTO dto) {
        if (dto == null) {
            return null;
        }
        return new RelatorioDomain(dto.idRelatorio(),
                                    dto.lucroEsperado(),
                                    dto.lucroPorProduto(),
                                    dto.dataHoraRelatorio(),
                                    estoqueMapper.toDomain(dto.estoque()),
                                    vendaMapper.toDomain(dto.venda()));
    }
    @Override
    public RelatorioDTO toDto(RelatorioDomain domain) {
        if (domain == null) {
            return null;
        }
        return new RelatorioDTO(domain.idRelatorio(),
                                domain.lucroEsperado(),
                                domain.lucroPorProduto(),
                                domain.dataHoraRelatorio(),
                                estoqueMapper.toDto(domain.estoque()),
                                vendaMapper.toDto(domain.venda()));
    }
    @Override
    public RelatorioEntity toEntity(RelatorioDomain domain) {
       if (domain == null) {
            return null;
       }
        return new RelatorioEntity(domain.idRelatorio(),
                                    domain.lucroEsperado(),
                                    domain.lucroPorProduto(),
                                    domain.dataHoraRelatorio(),
                                    estoqueMapper.toEntity(domain.estoque()),
                                    vendaMapper.toEntity(domain.venda()));
    }
    @Override
    public RelatorioDomain entityToDomain(RelatorioEntity entity) {
        if (entity == null ) {
            return null;
        }
        return new RelatorioDomain(entity.getIdRelatorio(),
                                    entity.getLucroEsperado(),
                                    entity.getLucroPorProduto(),
                                    entity.getDataHoraRelatorio(),
                                    estoqueMapper.entityToDomain(entity.getEstoque()),
                                    vendaMapper.entityToDomain(entity.getVenda()));   
    }
    @Override
    public RelatorioDTO entityToDto(RelatorioEntity entity) {
        if (entity == null) {
            return null;
        }
        return new RelatorioDTO(entity.getIdRelatorio(),
                                entity.getLucroEsperado(),
                                entity.getLucroPorProduto(),
                                entity.getDataHoraRelatorio(),
                                estoqueMapper.entityToDto(entity.getEstoque()),
                                vendaMapper.entityToDto(entity.getVenda()));
    }   
}