package db.jpa;

import db.entities.Movie;

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

    public Movie get(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        if (movie == null) {
            throw new EntityNotFoundException("Can't find movie for ID " + id);
        }
        return movie;
    }

    public List<Movie> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Movie e");
        return query.getResultList();
    }

    public void save(Movie movie) {
        executeInsideTransaction(entityManager -> entityManager.persist(movie));
    }

    public void update(Movie movie) {
        executeInsideTransaction(entityManager -> entityManager.merge(movie));
    }

    public void delete(Movie movie) {

        executeInsideTransaction(entityManager -> entityManager.remove(movie));
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
