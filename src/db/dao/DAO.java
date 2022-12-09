package db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.function.Consumer;

abstract class DAO<T> implements Serializable {
    protected final EntityManager entityManager;

    protected DAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /* CRUD methods */

    public void create(T t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));
    }

    public T read(int id) throws EntityNotFoundException {
        throw new EntityNotFoundException("can't find entity for ID " + id);
    }

    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    public void delete(T t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));
    }

    public int getNextId() {
        throw new EntityNotFoundException("can't find next ID");
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
