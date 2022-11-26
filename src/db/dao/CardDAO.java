package db.dao;

import db.pojo.CardPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class CardDAO extends DAO<CardPOJO> {

    protected CardDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public CardPOJO read(int id) {
        CardPOJO cardPOJO = entityManager.find(CardPOJO.class, id);
        if (cardPOJO == null) {
            throw new EntityNotFoundException("Can't find card for ID " + id);
        }
        return cardPOJO;
    }
}
