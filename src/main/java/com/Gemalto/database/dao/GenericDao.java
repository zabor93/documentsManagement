package com.Gemalto.database.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {

    T get(Class<T> tClass, Integer id);

    T save(T object);

    void update(T object);

    void delete(T object);

    List<T> query(String hsq1, Map<String, Object> params);

    List<T> getAll();

    void deleteAll();

    boolean deleteById(Class<T> tClass, Integer id);

    Object find(Class<T> tClass, Integer id);
}
