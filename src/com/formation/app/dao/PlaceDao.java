package com.formation.app.dao;

import com.formation.app.model.Place;

import java.util.List;

public interface PlaceDao extends CrudDao<Long, Place>{

    Place create(Place place);

    Place findById(Long id);

    boolean update(Place place);

    boolean remove(Long id);

    List<Place> findAll();

}