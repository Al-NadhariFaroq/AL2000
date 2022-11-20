package db.jpa;
import db.entities.Subscriber;

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
        this.entityManager= em;
    }

    public Subscriber get(long id) {
        Subscriber subscriber = entityManager.find(Subscriber.class, id);
        if (subscriber == null) {
            throw new EntityNotFoundException("Can't find subscriber for ID "
                    + id);
        }
        return subscriber;
    }


    public List<Subscriber> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Subscriber e");
        return query.getResultList();
    }

    public void save(Subscriber subscriber) {
        executeInsideTransaction(entityManager -> entityManager.persist(subscriber));
    }


    public void update(Subscriber subscriber) {
        executeInsideTransaction(entityManager -> entityManager.merge(subscriber));
    }


    public void delete(Subscriber subscriber) {

        executeInsideTransaction(entityManager -> entityManager.remove(subscriber));
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
