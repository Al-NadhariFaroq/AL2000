package db.dao;

import db.pojo.NonSubRentalPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class NonSubRentalDAO extends DAO<NonSubRentalPOJO> {

    protected NonSubRentalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public NonSubRentalPOJO read(int id) {
        NonSubRentalPOJO nonSubRentalPOJO = entityManager.find(NonSubRentalPOJO.class, id);
        if (nonSubRentalPOJO == null) {
            throw new EntityNotFoundException("Can't find non subscriber rental for ID " + id);
        }
        return nonSubRentalPOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(nonSubscriberRentalId) from Non_Subscriber_rentals", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }
}
