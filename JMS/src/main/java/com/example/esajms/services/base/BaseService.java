package com.example.esajms.services.base;


import com.example.esajms.dto.base.BaseDto;
import com.example.esajms.entities.base.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService <E extends BaseEntity<I>, D extends BaseDto, I> {
    E findById(I id);
    List<E> findAll();
    void save(D dto);
    void delete(I id);
    void update(E entity);
}
