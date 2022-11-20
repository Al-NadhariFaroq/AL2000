package db.jpa;
import db.entities.Theme;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class ThemeJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public ThemeJPA(EntityManager em) {
        this.entityManager= em;
    }

    public Theme get(long id) {
        Theme theme = entityManager.find(Theme.class, id);
        if (theme == null) {
            throw new EntityNotFoundException("Can't find theme for ID "
                    + id);
        }
        return theme;
    }

    public List<Theme> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Theme e");
        return query.getResultList();
    }


    public void save(Theme theme) {
        executeInsideTransaction(entityManager -> entityManager.persist(theme));
    }


    public void update(Theme theme) {
        executeInsideTransaction(entityManager -> entityManager.merge(theme));
    }


    public void delete(Theme theme) {
        executeInsideTransaction(entityManager -> entityManager.remove(theme));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
