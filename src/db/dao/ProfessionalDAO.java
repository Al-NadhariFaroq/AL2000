package db.dao;

import db.pojo.ProfessionalPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class ProfessionalDAO extends DAO<ProfessionalPOJO> {

    protected ProfessionalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ProfessionalPOJO read(int id) {
        ProfessionalPOJO professionalPOJO = entityManager.find(ProfessionalPOJO.class, id);
        if (professionalPOJO == null) {
            throw new EntityNotFoundException("Can't find professional for ID " + id);
        }
        return professionalPOJO;
    }
}
