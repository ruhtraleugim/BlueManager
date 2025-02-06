package com.BlueSpectre.BlueManeger.Infra.Persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.RelatorioEntity;

import jakarta.transaction.Transactional;

@Repository
public interface RelatorioPersistence extends JpaRepository<RelatorioEntity,Long> {
    
    List<RelatorioEntity> findByDataHoraRelatorio(LocalDate dataHoraRelatorio);
        
    @Modifying
    @Transactional
    @Query(("UPDATE RELATORIO r SET r.lucroEsperado = :lucroEsperado, " +
       "r.lucroPorProduto = :lucroPorProduto, " +
       "r.dataHoraRelatorio = :dataHoraRelatorio, " +
       "r.estoque = :estoque, " +
       "r.venda = :venda " +
       "WHERE r.idRelatorio = :idRelatorio"))
    RelatorioEntity updateRelatorio(RelatorioEntity entity , Long id);
}