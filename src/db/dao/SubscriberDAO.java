package db.dao;

import db.pojo.BluRayPOJO;
import db.pojo.SubscriberPOJO;
import fc.user.Subscriber;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDAO extends DAO<SubscriberPOJO> {

    protected SubscriberDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SubscriberPOJO read(int id) {
        SubscriberPOJO subscriberPOJO = entityManager.find(SubscriberPOJO.class, id);
        if (subscriberPOJO == null) {
            throw new EntityNotFoundException("Can't find subscriber for ID " + id);
        }
        return subscriberPOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(subscriberId) from Subscribers", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }

    public int readNextSubscriptionCardNumber() {
        Integer maxSubscriptionCardNumber = entityManager.createQuery("select max(subscriptionCardNumber) FROM Subscribers", Integer.class).getSingleResult();
        if (maxSubscriptionCardNumber == null) {
            return 0;
        }
        return maxSubscriptionCardNumber + 1;
    }
}
