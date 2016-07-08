package com.springapp.mvc.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akhil on 5/7/16.
 */
public interface GenericDao<T,PK extends Serializable> {
    List<T> getAll();
    T get(PK id);
    T save(T object);
    void remove(PK id);
}
