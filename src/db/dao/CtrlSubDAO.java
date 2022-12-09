package db.dao;

import db.pojo.CtrlSubPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class CtrlSubDAO extends DAO<CtrlSubPOJO> {

    protected CtrlSubDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public CtrlSubPOJO read(int id) {
        CtrlSubPOJO ctrlSubPOJO = entityManager.find(CtrlSubPOJO.class, id);
        if (ctrlSubPOJO == null) {
            throw new EntityNotFoundException("Can't find controlled subscriber for ID " + id);
        }
        return ctrlSubPOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(controlledSubscriberId) from Controlled_Subscribers ", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }
}
