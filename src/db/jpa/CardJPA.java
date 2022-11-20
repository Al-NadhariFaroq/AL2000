package db.jpa;
import db.entities.Card;

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
        this.entityManager= em;
    }

    public Card get(long id) {
        Card card = entityManager.find(Card.class, id);
        if (card == null) {
            throw new EntityNotFoundException("Can't find card for ID "
                    + id);
        }
        return card;
    }


    public List<Card> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Card e");
        return query.getResultList();
    }


    public void save(Card card) {
        executeInsideTransaction(entityManager -> entityManager.persist(card));



    }


    public void update(Card card) {
        executeInsideTransaction(entityManager -> entityManager.merge(card));
    }


    public void delete(Card card) {

        executeInsideTransaction(entityManager -> entityManager.remove(card));
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
