package com.example.LR2_Spring.services.base;


import com.example.LR2_Spring.entities.base.BaseEntity;

import java.util.List;

public interface BaseService <E extends BaseEntity<I>, I> {
    E findById(I id);
    List<E> findAll();
    void save(E entity);
    void delete(I id);
    void update(E entity);
}
