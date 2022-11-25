package db.jpa;

import db.entities.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class MovieJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public MovieJPA(EntityManager em) {
        this.entityManager = em;
    }

    public MovieEntity get(int id) {
        MovieEntity movieEntity = entityManager.find(MovieEntity.class, id);
        if (movieEntity == null) {
            throw new EntityNotFoundException("Can't find movie for ID " + id);
        }
        return movieEntity;
    }

    public List<MovieEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM MovieEntity e");
        return query.getResultList();
    }

    public void save(MovieEntity movieEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(movieEntity));
    }

    public void update(MovieEntity movieEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(movieEntity));
    }

    public void delete(MovieEntity movieEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(movieEntity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
