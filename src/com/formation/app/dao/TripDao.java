package com.formation.app.dao;

import com.formation.app.model.Trip;

import java.util.List;

public interface TripDao<U> extends CrudDao<Long, Trip>{

    Trip create(Trip trip);

    Trip findById(Long id);

    boolean update(Trip trip);

    boolean remove(Long id);

    List<Trip> findAll();

    List<Trip> findByDestination(U Place);

}