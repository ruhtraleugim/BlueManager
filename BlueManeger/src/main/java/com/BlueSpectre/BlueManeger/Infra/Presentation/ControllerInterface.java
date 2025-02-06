package com.BlueSpectre.BlueManeger.Infra.Presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<C>{

    public ResponseEntity<?> alterarEntity( C c,  Long id);

    public List<C> buscarEntity();

    public ResponseEntity<C> buscarEntityPorId(Long id);  

    public ResponseEntity<?> criarEntity(C c );

    public ResponseEntity<?> deletarEntity( Long id);

}