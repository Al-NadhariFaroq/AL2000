package db.dao;

import db.pojo.SubscribeCardPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class SubscribeCardDAO extends DAO<SubscribeCardPOJO> {

    protected SubscribeCardDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SubscribeCardPOJO read(int id) {
        SubscribeCardPOJO subscribeCardPOJO = entityManager.find(SubscribeCardPOJO.class, id);
        if (subscribeCardPOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return subscribeCardPOJO;
    }
}
