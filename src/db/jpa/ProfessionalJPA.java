package db.jpa;

import db.entities.ProfessionalEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class ProfessionalJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public ProfessionalJPA(EntityManager em) {
        this.entityManager = em;
    }

    public ProfessionalEntity get(long id) {
        ProfessionalEntity professionalEntity = entityManager.find(ProfessionalEntity.class, id);
        if (professionalEntity == null) {
            throw new EntityNotFoundException("Can't find professional for ID " + id);
        }
        return professionalEntity;
    }

    public List<ProfessionalEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM ProfessionalEntity e");
        List<ProfessionalEntity> professionalEntityList = query.getResultList();
        return professionalEntityList;
    }

    public void save(ProfessionalEntity professionalEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(professionalEntity));
    }

    public void update(ProfessionalEntity professionalEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(professionalEntity));
    }

    public void delete(ProfessionalEntity professionalEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(professionalEntity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
