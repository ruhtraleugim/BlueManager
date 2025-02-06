package com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces;

import java.util.Optional;

public interface BuscarPorIDUserCase<E>{
    Optional<E> execute(Long ID);
}