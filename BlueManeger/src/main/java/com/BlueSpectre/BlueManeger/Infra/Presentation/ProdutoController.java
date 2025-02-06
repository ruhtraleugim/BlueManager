package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.BlueSpectre.BlueManeger.Infra.Dto.ProdutoDTO;


public class ProdutoController implements ControllerInterface<ProdutoDTO> {

    @Override
    public ResponseEntity<?> alterarEntity(ProdutoDTO c, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarEntity'");
    }

    @Override
    public List<ProdutoDTO> buscarEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEntity'");
    }

    @Override
    public ResponseEntity<ProdutoDTO> buscarEntityPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEntityPorId'");
    }

    @Override
    public ResponseEntity<?> criarEntity(ProdutoDTO c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarEntity'");
    }

    @Override
    public ResponseEntity<?> deletarEntity(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarEntity'");
    }
    
}