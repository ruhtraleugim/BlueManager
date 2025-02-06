package com.BlueSpectre.BlueManeger.Infra.Persistence.Entities;
    
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "DEBITO")
@Table(name = "DEBITO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DebitoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDebito;
    private double valorDebito;
    private String descricaoConta; 
    private String tipoConta;

    @ManyToOne
    @JoinColumn(name = "idPagamento")
    private PagamentoEntity pagamento;
}