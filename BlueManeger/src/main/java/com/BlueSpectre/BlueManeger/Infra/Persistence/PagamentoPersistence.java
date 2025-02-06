package com.BlueSpectre.BlueManeger.Infra.Persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.PagamentoEntity;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

@Repository
public interface PagamentoPersistence extends JpaRepository<PagamentoEntity, Long> {

    Optional<PagamentoEntity> findByDataPagamento(LocalDate dataPagamento);

    @Modifying
    @Transactional
    @Query("UPDATE PAGAMENTO p SET p.valorPagamento = :valorPagamento, " +
        "p.cpfCobrador = :cpfCobrador, " +
        "p.recebedorPagamento = :recebedorPagamento, " +
        "p.dataPagamento = :dataPagamento, " +
        "p.tipoPagamento = :tipoPagamento, " +
        "p.statusPagamento = :statusPagamento " +
        "WHERE p.idPagamento = :idPagamento")
    PagamentoEntity updatePagamento(PagamentoEntity entity, Long id);
}