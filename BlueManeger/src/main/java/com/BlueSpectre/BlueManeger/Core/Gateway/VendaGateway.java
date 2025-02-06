package com.BlueSpectre.BlueManeger.Core.Gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.BlueSpectre.BlueManeger.Core.Domain.VendaDomain;


public interface VendaGateway {
    
        Optional<VendaDomain> getVendaByID(Long id); 
        
        List<VendaDomain> getVendasByDate(LocalDate Data);

        List<VendaDomain> getVendas();
        
        void deleteVenda(Long id);

        VendaDomain newVenda( VendaDomain venda);

        VendaDomain alterarVenda(VendaDomain venda, Long ID);
        
}