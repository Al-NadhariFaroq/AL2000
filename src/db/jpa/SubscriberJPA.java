package db.jpa;

import db.entities.SubscriberEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class SubscriberJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public SubscriberJPA(EntityManager em) {
        this.entityManager = em;
    }

    public SubscriberEntity get(int id) {
        SubscriberEntity subscriberEntity = entityManager.find(SubscriberEntity.class, id);
        if (subscriberEntity == null) {
            throw new EntityNotFoundException("Can't find subscriber for ID " + id);
        }
        return subscriberEntity;
    }

    public List<SubscriberEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM SubscriberEntity e");
        return query.getResultList();
    }

    public void save(SubscriberEntity subscriberEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(subscriberEntity));
    }

    public void update(SubscriberEntity subscriberEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(subscriberEntity));
    }

    public void delete(SubscriberEntity subscriberEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(subscriberEntity));
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
