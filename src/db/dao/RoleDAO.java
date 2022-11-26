package db.dao;

import db.pojo.RolePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class RoleDAO extends DAO<RolePOJO> {

    protected RoleDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public RolePOJO read(int id) {
        RolePOJO rolePOJO = entityManager.find(RolePOJO.class, id);
        if (rolePOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return rolePOJO;
    }
}
