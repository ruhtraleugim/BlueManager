package com.BlueSpectre.BlueManeger.Infra.Mapper;

public interface MapperInteface<D, T, E> {

    D toDomain(T dto);       // De DTO para Domain

    T entityToDto(E entity); 

    T toDto(D domain);       // De Domain para DTO

    E toEntity(D domain);    // De Domain para Entity

    D entityToDomain(E entity);
}