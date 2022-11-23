package db.jpa;

import db.entities.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class FilmJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public FilmJPA(EntityManager em) {
        this.entityManager = em;
    }

    public Film get(long id) {
        Film film = entityManager.find(Film.class, id);
        if (film == null) {
            throw new EntityNotFoundException("Can't find film for ID " + id);
        }
        return film;
    }

    public List<Film> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Film e");
        return query.getResultList();
    }

    public void save(Film film) {
        executeInsideTransaction(entityManager -> entityManager.persist(film));
    }

    public void update(Film film) {
        executeInsideTransaction(entityManager -> entityManager.merge(film));
    }

    public void delete(Film film) {

        executeInsideTransaction(entityManager -> entityManager.remove(film));
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
