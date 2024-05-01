package com.martin.lab7maven.models;

import java.util.List;

public interface GenericDao<T, K> {
    void registrar(T t);
    List<T> listar();
    List<T> buscarPorNombre(String nombre);
    T obtenerPorId(K id);
    void eliminar(K id);
}
