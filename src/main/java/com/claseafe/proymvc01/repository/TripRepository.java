package com.claseafe.proymvc01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.claseafe.proymvc01.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}