package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;


public interface DebitoGateway {
        
        DebitoDomain AlterarDebito(DebitoDomain debito, Long ID);
        
        DebitoDomain newDebito(DebitoDomain debito);
        
        List<DebitoDomain> GetDebito();

        Optional<DebitoDomain> getDebitosByID(Long ID);

        List<DebitoDomain> getDebitosByDate(LocalDate date);

        void deleteDebito(Long ID);

}