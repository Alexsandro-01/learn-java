package com.hibernates;
import com.hibernates.entity.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Class principal da aplicação.
 */
public class Application {

  /**
   * Método principal.
   *
   * @param args argumentos da linha de comando.
   */
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("com.hibernates.veiculo-hibernate");

    // dados
    Veiculo veiculo = new Veiculo();
    veiculo.setAno(2016);
    veiculo.setModelo("Twister");
    veiculo.setQuilometragem("34560");

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(veiculo);
    em.getTransaction().commit();

    em.close();
  }

}
