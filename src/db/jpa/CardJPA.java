package db.jpa;

import db.entities.CardEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class CardJPA implements Serializable {

    private EntityManager entityManager;

    // standard constructors
    public CardJPA(EntityManager em) {
        this.entityManager = em;
    }

    public CardEntity get(long id) {
        CardEntity cardEntity = entityManager.find(CardEntity.class, id);
        if (cardEntity == null) {
            throw new EntityNotFoundException("Can't find card for ID " + id);
        }
        return cardEntity;
    }

    public List<CardEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM CardEntity e");
        return query.getResultList();
    }

    public void save(CardEntity cardEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(cardEntity));
    }

    public void update(CardEntity cardEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(cardEntity));
    }

    public void delete(CardEntity cardEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(cardEntity));
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
