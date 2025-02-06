package com.BlueSpectre.BlueManeger.Core.Usecases.Intefaces;

public interface AlterarUserCase<E> {
    E execute(Long ID, E e);
}