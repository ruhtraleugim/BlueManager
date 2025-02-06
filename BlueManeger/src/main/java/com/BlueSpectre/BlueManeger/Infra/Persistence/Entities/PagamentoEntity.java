package com.BlueSpectre.BlueManeger.Infra.Persistence.Entities;


import java.time.LocalDate;

import com.BlueSpectre.BlueManeger.Core.Enum.StatusPagamento;
import com.BlueSpectre.BlueManeger.Core.Enum.TipoPagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PAGAMENTO")
@Table(name = "PAGAMENTO")
public class PagamentoEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPagamento;
        private double valorPagamento;
        private String cpfCobrador;
        private String recebedorPagamento;
        private LocalDate dataPagamento;

        @Enumerated(EnumType.STRING)
        private TipoPagamento tipoPagamento;
         
        @Enumerated(EnumType.STRING)     
        private StatusPagamento statusPagamento;
}