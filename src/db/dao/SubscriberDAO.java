package db.dao;

import db.pojo.SubscriberPOJO;

public class SubscriberDAO extends DAO<SubscriberPOJO> {
    private static SubscriberDAO instance;

    private SubscriberDAO() {
        super(SubscriberPOJO.class);
    }

    public static SubscriberDAO getInstance() {
        if (instance == null) {
            instance = new SubscriberDAO();
        }
        return instance;
    }

    public int readNextSubscriptionCardNumber() {
        String query = "SELECT MAX(subscriptionCardNumber) FROM subscribers";
        Integer maxSubscriptionCardNumber = entityManager.createQuery(query, Integer.class).getSingleResult();
        return maxSubscriptionCardNumber == null ? 0 : maxSubscriptionCardNumber + 1;
    }

    public SubscriberPOJO readFromSubscriptionCardNumber(int subscriptionCardNumber) {
        String query = "SELECT S FROM subscribers S WHERE S.subscriptionCardNumber = :scn";
        return entityManager.createQuery(query, SubscriberPOJO.class).setParameter("scn", subscriptionCardNumber).getSingleResult();
    }
}
