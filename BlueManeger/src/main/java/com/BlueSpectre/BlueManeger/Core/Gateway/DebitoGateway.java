package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.DebitoDomain;


public interface DebitoGateway {
        
        DebitoDomain updateDebito(DebitoDomain debito, Long id);

        DebitoDomain newDebito(DebitoDomain debito);
        
        List<DebitoDomain> GetDebito();

        Optional<DebitoDomain> getDebitosByID(Long id);

        List<DebitoDomain> getDebitosByDate(LocalDate date);

        void deleteDebito(Long id);
}