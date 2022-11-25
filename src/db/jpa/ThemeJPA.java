package db.jpa;

import db.entities.ThemeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class ThemeJPA implements Serializable {

    private final EntityManager entityManager;

    // standard constructors
    public ThemeJPA(EntityManager em) {
        this.entityManager = em;
    }

    public ThemeEntity get(int id) {
        ThemeEntity themeEntity = entityManager.find(ThemeEntity.class, id);
        if (themeEntity == null) {
            throw new EntityNotFoundException("Can't find theme for ID " + id);
        }
        return themeEntity;
    }

    public List<ThemeEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM ThemeEntity e");
        return query.getResultList();
    }

    public void save(ThemeEntity themeEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(themeEntity));
    }

    public void update(ThemeEntity themeEntity) {
        executeInsideTransaction(entityManager -> entityManager.merge(themeEntity));
    }

    public void delete(ThemeEntity themeEntity) {
        executeInsideTransaction(entityManager -> entityManager.remove(themeEntity));
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
