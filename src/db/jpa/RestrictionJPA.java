package db.jpa;

import db.entities.RestrictionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class RestrictionJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public RestrictionJPA(EntityManager em) {
        this.entityManager = em;
    }

    public RestrictionEntity get(long id) {
        RestrictionEntity restrictionEntity = entityManager.find(RestrictionEntity.class, id);
        if (restrictionEntity == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return restrictionEntity;
    }

    public List<RestrictionEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM RestrictionEntity e");
        return query.getResultList();
    }

    public void save(RestrictionEntity restrictionEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(restrictionEntity));
    }

    public void update(RestrictionEntity restrictionEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(restrictionEntity));
    }

    public void delete(RestrictionEntity restrictionEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(restrictionEntity));
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
