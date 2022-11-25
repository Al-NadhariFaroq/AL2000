package db.dao;

import db.entities.RestrictionEntity;

import java.util.ArrayList;
import java.util.List;

import db.jpa.RestrictionJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RestrictionDAO implements DAO<RestrictionEntity> {

    private final List<RestrictionEntity> cards = new ArrayList<>();
    public EntityManagerFactory emf;
    private final RestrictionJPA restrictionJPA;

    public RestrictionDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        restrictionJPA = new RestrictionJPA(emf.createEntityManager());
    }

    @Override
    public RestrictionEntity get(int id) {
        return restrictionJPA.get(id);
    }

    @Override
    public List<RestrictionEntity> getAll() {
        return restrictionJPA.getAll();
    }

    @Override
    public void save(RestrictionEntity card) {
        restrictionJPA.save(card);
    }

    @Override
    public void update(RestrictionEntity card) {
        restrictionJPA.update(card);
    }

    @Override
    public void delete(RestrictionEntity card) {
        restrictionJPA.delete(card);
    }
}

