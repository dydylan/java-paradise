package com.formation.app.dao;

import java.util.List;

public interface PlaceDao<T> extends CrudDao<Long, T>{

    T create(T place);

    T findById(Long id);

    boolean update(T place);

    boolean remove(Long id);

    List<T> findAll();

}