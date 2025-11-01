package com.example.repository.interfaces;

import java.util.Collection;

public interface IRepository<T, ID> {
    void save(T entity);
    T findById(ID id);
    Collection<T> findAll();
    void delete(ID id);
    boolean exists(ID id);
}

