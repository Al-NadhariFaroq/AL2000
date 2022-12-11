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
        Integer maxSubscriptionCardNumber = (Integer) entityManager.createNativeQuery(
                "SELECT MAX(subscription_card_number) FROM subscribers",
                Integer.class
        ).getSingleResult();
        if (maxSubscriptionCardNumber == null) {
            return 0;
        }
        return maxSubscriptionCardNumber + 1;
    }
}
