package com.BlueSpectre.BlueManeger.Infra.Persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BlueSpectre.BlueManeger.Infra.Persistence.Entities.VendaEntity;

import jakarta.transaction.Transactional;

@Repository
public interface VendaPersistence extends JpaRepository<VendaEntity,Long>{
    
    List<VendaEntity> findByDataVenda(LocalDate dataVenda);

    @Modifying
    @Transactional
    @Query(("UPDATE VENDA v SET v.quantidadeProduto = :quantidadeProduto, " +
    "v.valorVenda = :valorVenda, " +
    "v.dataVenda = :dataVenda, " +
    "v.produtoVenda = :produtoVenda, " +
    "v.pagamento = :pagamento " +
    "WHERE v.idVenda = :idVenda"))
    VendaEntity updateVenda(VendaEntity entity , Long id);
}