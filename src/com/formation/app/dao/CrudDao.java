package com.formation.app.dao;

import java.util.List;

public interface CrudDao<ID, T> {
    T create(T t);

    T findById(ID id);

    boolean update(T t);

    boolean remove(ID id);

    List<T> findAll();
}
