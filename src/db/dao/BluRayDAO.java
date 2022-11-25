package db.dao;

import db.entities.BluRayEntity;

import java.util.ArrayList;
import java.util.List;

import db.jpa.BluRayJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BluRayDAO implements DAO<BluRayEntity> {

    private final List<BluRayEntity> bluRayEntities = new ArrayList<>();
    public EntityManagerFactory emf;
    private final BluRayJPA bluRayJpa;

    public BluRayDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        bluRayJpa = new BluRayJPA(emf.createEntityManager());
    }

    @Override
    public BluRayEntity get(int id) {
        return bluRayJpa.get(id);
    }

    @Override
    public List<BluRayEntity> getAll() {
        return bluRayJpa.getAll();
    }

    @Override
    public void save(BluRayEntity bluRayEntity) {
        bluRayJpa.save(bluRayEntity);
    }

    @Override
    public void update(BluRayEntity bluRayEntity) {
        bluRayJpa.update(bluRayEntity);
    }

    @Override
    public void delete(BluRayEntity bluRayEntity) {
        bluRayJpa.delete(bluRayEntity);
    }
}
