package db.dao;

import db.entities.BluRay;

import java.util.ArrayList;
import java.util.List;

import db.jpa.BluRayJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BluRayDAO implements DAO<BluRay> {

    private final List<BluRay> bluRays = new ArrayList<>();
    public EntityManagerFactory emf;
    private final BluRayJPA bluRayJpa;

    public BluRayDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        bluRayJpa = new BluRayJPA(emf.createEntityManager());
    }

    @Override
    public BluRay get(int id) {
        return bluRayJpa.get(id);
    }

    @Override
    public List<BluRay> getAll() {
        return bluRayJpa.getAll();
    }

    @Override
    public void save(BluRay bluRay) {
        bluRayJpa.save(bluRay);
    }

    @Override
    public void update(BluRay bluRay) {
        bluRayJpa.update(bluRay);
    }

    @Override
    public void delete(BluRay bluRay) {
        bluRayJpa.delete(bluRay);
    }
}
