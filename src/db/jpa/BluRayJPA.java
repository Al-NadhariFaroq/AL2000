package db.jpa;

import db.entities.BluRayEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class BluRayJPA implements Serializable {

    private EntityManager entityManager;

    // standard constructors
    public BluRayJPA(EntityManager em) {
        this.entityManager = em;
    }

    public BluRayEntity get(long id) {
        BluRayEntity bluRayEntity = entityManager.find(BluRayEntity.class, id);
        if (bluRayEntity == null) {
            throw new EntityNotFoundException("Can't find bluray for ID " + id);
        }
        return bluRayEntity;
    }

    public List<BluRayEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM BluRayEntity e");
        return query.getResultList();
    }

    public void save(BluRayEntity bluRayEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(bluRayEntity));
    }

    public void update(BluRayEntity bluRayEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(bluRayEntity));
    }

    public void delete(BluRayEntity bluRayEntity) {

        executeInsideTransaction(entityManager -> entityManager.remove(bluRayEntity));
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
