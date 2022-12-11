package db.dao;

import db.Session;
import db.pojo.POJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class DAO<T extends POJO> implements Serializable {
    protected final EntityManager entityManager;
    protected final Class<T> pojoClass;
    protected final String className;
    protected final String tableName;

    public DAO(Class<T> pojoClass) {
        this.entityManager = Session.getInstance().getEntityManager();
        this.pojoClass = pojoClass;
        this.className = pojoClass.getSimpleName();
        this.tableName = pojoClass.getAnnotation(Table.class).name();
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
            throw new EntityNotFoundException("Can't find " + className + " for ID " + id);
        }
        return pojo;
    }

    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    public void delete(T t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));
    }

    /* Other general methods */

    public List<T> readAll() {
        return entityManager.createQuery("FROM " + tableName, pojoClass).getResultList();
    }

    public int getNextId() {
        String column = tableName.substring(0, tableName.length() - 1).replaceAll("s_", "_") + "_id";
        String query = "SELECT NVL(MAX(" + column + "), 0) + 1 FROM " + tableName;
        return entityManager.createQuery(query, Integer.class).getSingleResult();
    }
}
