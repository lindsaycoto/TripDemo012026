package com.claseafe.proymvc01.service;

import java.util.List;
import com.claseafe.proymvc01.model.Trip;

public interface ITripService {

    List<Trip> buscarTodos();
    Trip buscarPorId(Integer idTrip);
    
    void guardar(Trip trip);
    void eliminar(Integer idTrip);
}