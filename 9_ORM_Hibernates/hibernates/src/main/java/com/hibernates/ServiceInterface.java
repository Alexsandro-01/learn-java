package com.hibernates;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface ServiceInterface<T> {
    EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("com.hibernates.veiculo-hibernate");

    List<T> getVeiculos();
    void save(T entity);
}
