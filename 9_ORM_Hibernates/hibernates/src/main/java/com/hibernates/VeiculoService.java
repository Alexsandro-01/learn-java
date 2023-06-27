package com.hibernates;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.hibernates.entity.Veiculo;

public class VeiculoService implements ServiceInterface<Veiculo> {

  public List<Veiculo> getVeiculos() {

    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("from Veiculo");

    return query.getResultList();
  }

  public void save(Veiculo veiculo) {

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(veiculo);
    em.getTransaction().commit();

    em.close();
  }
}
