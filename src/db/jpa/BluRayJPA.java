package db.jpa;
import db.entities.BluRay;

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
        this.entityManager= em;
    }

    public BluRay get(long id) {
        BluRay bluRay = entityManager.find(BluRay.class, id);
        if (bluRay == null) {
            throw new EntityNotFoundException("Can't find bluray for ID "
                    + id);
        }
        return bluRay;
    }


    public List<BluRay> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM BluRay e");
        return query.getResultList();
    }


    public void save(BluRay bluRay) {
        executeInsideTransaction(entityManager -> entityManager.persist(bluRay));



    }


    public void update(BluRay bluRay) {
        executeInsideTransaction(entityManager -> entityManager.merge(bluRay));
    }


    public void delete(BluRay bluRay) {

        executeInsideTransaction(entityManager -> entityManager.remove(bluRay));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
