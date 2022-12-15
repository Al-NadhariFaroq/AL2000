package db.dao;

import db.pojo.CtrlSubPOJO;
import db.pojo.SubscriberPOJO;

import javax.persistence.NoResultException;

public class CtrlSubDAO extends DAO<CtrlSubPOJO> {
    private static CtrlSubDAO instance;

    private CtrlSubDAO() {
        super(CtrlSubPOJO.class);
    }

    public static CtrlSubDAO getInstance() {
        if (instance == null) {
            instance = new CtrlSubDAO();
        }
        return instance;
    }

    @Override
    public void delete(CtrlSubPOJO ctrlSubPOJO) {
        SubscriberPOJO subscriberPOJO = DAOFactory.getSubscriberDAO().read(ctrlSubPOJO.getSubscriber().getID());
        if (!subscriberPOJO.getControlledSubscribers().isEmpty()) {
            subscriberPOJO.getControlledSubscribers().remove(ctrlSubPOJO);
            entityManager.merge(subscriberPOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(ctrlSubPOJO));
    }

    public CtrlSubPOJO readFromControlledSubscriber(SubscriberPOJO subscriberPOJO) {
        String query = "SELECT S FROM controlled_subscribers S WHERE S.controlledSubscriberId = :ctrlSub";
        try {
            return entityManager.createQuery(query, CtrlSubPOJO.class)
                    .setParameter("ctrlSub", subscriberPOJO.getID())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
