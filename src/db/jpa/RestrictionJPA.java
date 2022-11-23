package db.jpa;

import db.entities.Restriction;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class RestrictionJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public RestrictionJPA(EntityManager em) {
        this.entityManager = em;
    }

    public Restriction get(long id) {
        Restriction restriction = entityManager.find(Restriction.class, id);
        if (restriction == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return restriction;
    }

    public List<Restriction> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Restriction e");
        return query.getResultList();
    }

    public void save(Restriction restriction) {
        executeInsideTransaction(entityManager -> entityManager.persist(restriction));
    }

    public void update(Restriction restriction) {
        executeInsideTransaction(entityManager -> entityManager.merge(restriction));
    }

    public void delete(Restriction restriction) {

        executeInsideTransaction(entityManager -> entityManager.remove(restriction));
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
