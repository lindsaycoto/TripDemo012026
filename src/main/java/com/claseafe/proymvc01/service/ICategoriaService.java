package com.claseafe.proymvc01.service;

import java.util.List;
import com.claseafe.proymvc01.model.Categoria;
public interface ICategoriaService {

    List<Categoria> buscarTodas();

    Categoria buscarPorId(Integer idCategoria);

    void guardar(Categoria categoria);
    void eliminar(Integer idCategoria);
}