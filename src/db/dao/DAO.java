package db.dao;

import db.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

abstract class DAO<T> implements Serializable {
    protected final EntityManager entityManager;
    protected final Class<T> pojoClass;

    protected DAO(Class<T> pojoClass) {
        this.entityManager = Session.getInstance().getEntityManager();
        this.pojoClass = pojoClass;
    }

    protected void executeInsideTransaction(Consumer<EntityManager> action) {
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

    /* CRUD methods */

    public void create(T t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));
    }

    public T read(int id) throws EntityNotFoundException {
        T pojo = entityManager.find(pojoClass, id);
        if (pojo == null) {
            String[] className = pojoClass.getName().split("\\.");
            throw new EntityNotFoundException("Can't find " + className[className.length - 1] + " for ID " + id);
        }
        return pojo;
    }

    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    public void delete(T t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));
    }

    @SuppressWarnings("unchecked")
    public List<T> readAll() {
        return (List<T>) entityManager.createQuery("FROM " + pojoClass.getName()).getResultList();
    }

    public int getNextId() {
        return -1;
    }
}
