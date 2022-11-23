package db.dao;

import db.entities.Restriction;

import java.util.ArrayList;
import java.util.List;

import db.jpa.RestrictionJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RestrictionDAO implements DAO<Restriction> {

    private final List<Restriction> cards = new ArrayList<>();
    public EntityManagerFactory emf;
    private final RestrictionJPA restrictionJPA;

    public RestrictionDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        restrictionJPA = new RestrictionJPA(emf.createEntityManager());
    }

    @Override
    public Restriction get(int id) {
        return restrictionJPA.get(id);
    }

    @Override
    public List<Restriction> getAll() {
        return restrictionJPA.getAll();
    }

    @Override
    public void save(Restriction card) {
        restrictionJPA.save(card);
    }

    @Override
    public void update(Restriction card) {
        restrictionJPA.update(card);
    }

    @Override
    public void delete(Restriction card) {
        restrictionJPA.delete(card);
    }
}

