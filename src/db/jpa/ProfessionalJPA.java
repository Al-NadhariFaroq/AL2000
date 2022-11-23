package db.jpa;

import db.entities.Professional;

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

    public Professional get(long id) {
        Professional professional = entityManager.find(Professional.class, id);
        if (professional == null) {
            throw new EntityNotFoundException("Can't find professional for ID "
                    + id);
        }
        return professional;
    }


    public List<Professional> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Professional e");
        List<Professional> professionalList = query.getResultList();
        return professionalList;
    }


    public void save(Professional professional) {
        executeInsideTransaction(entityManager -> entityManager.persist(professional));


    }


    public void update(Professional professional) {
        executeInsideTransaction(entityManager -> entityManager.merge(professional));
    }


    public void delete(Professional professional) {

        executeInsideTransaction(entityManager -> entityManager.remove(professional));
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
