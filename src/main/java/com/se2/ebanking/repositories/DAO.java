package com.se2.ebanking.repositories;

import java.util.List;

public interface DAO<T> {
    void insertModel(T t);
    void deleteModel(long id);
    void updateModel(T t);
    T selectModel(long id);
    List<T> selectAllModels();
}
