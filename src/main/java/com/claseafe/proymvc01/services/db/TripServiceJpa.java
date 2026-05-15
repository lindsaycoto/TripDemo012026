package com.claseafe.proymvc01.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.claseafe.proymvc01.model.Trip;
import com.claseafe.proymvc01.repository.TripRepository;
import com.claseafe.proymvc01.service.ITripService;


@Service
@Primary
public class TripServiceJpa implements ITripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> buscarTodos() {
        return tripRepository.findAll();
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
        Optional<Trip> optional	
        = tripRepository.findById(idTrip);
        if (optional.isPresent())
        return optional.get();
        else 
        	return null;
    }

    @Override
    public void guardar(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void eliminar(Integer idTrip) {
        tripRepository.deleteById(idTrip);
    }
}