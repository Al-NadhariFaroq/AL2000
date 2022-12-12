package db.dao;

import db.pojo.BluRayRentalPOJO;
import db.pojo.SubscriberPOJO;

import java.util.List;

public class BluRayRentalDAO extends DAO<BluRayRentalPOJO> {
    private static BluRayRentalDAO instance;

    private BluRayRentalDAO() {
        super(BluRayRentalPOJO.class);
    }

    public static BluRayRentalDAO getInstance() {
        if (instance == null) {
            instance = new BluRayRentalDAO();
        }
        return instance;
    }

    public BluRayRentalPOJO readFromCreditCardNumber(int creditCardNumber) {
        String query = "SELECT BR FROM blu_ray_rentals BR JOIN non_subscriber_rentals NSR ON(BR.rental = NSR.rental) WHERE NSR.creditCardNumber = :ccn AND BR.returnDate IS NOT NULL";
        return entityManager.createQuery(query, BluRayRentalPOJO.class).setParameter("ccn", creditCardNumber).getSingleResult();
    }

    public List<BluRayRentalPOJO> readFromSubscriber(SubscriberPOJO subscriberPOJO) {
        String query = "SELECT BR FROM blu_ray_rentals BR JOIN subscriber_rentals SR ON(BR.rental = SR.rental) WHERE SR.subscriber = :sub AND BR.returnDate IS NOT NULL";
        return entityManager.createQuery(query, BluRayRentalPOJO.class).setParameter("sub", subscriberPOJO).getResultList();
    }
}
