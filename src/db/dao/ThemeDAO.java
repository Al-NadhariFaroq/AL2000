package db.dao;

import java.util.ArrayList;
import java.util.List;

import db.entities.ThemeEntity;
import db.jpa.ThemeJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ThemeDAO implements DAO<ThemeEntity> {

    private final List<ThemeEntity> themeEntities = new ArrayList<>();
    public EntityManagerFactory emf;
    private final ThemeJPA themeJPA;

    public ThemeDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        themeJPA = new ThemeJPA(emf.createEntityManager());
    }

    @Override
    public ThemeEntity get(int id) {
        return themeJPA.get(id);
    }

    @Override
    public List<ThemeEntity> getAll() {
        return themeJPA.getAll();
    }

    @Override
    public void save(ThemeEntity themeEntity) {
        themeJPA.save(themeEntity);
    }

    @Override
    public void update(ThemeEntity themeEntity) {
        themeJPA.update(themeEntity);
    }

    @Override
    public void delete(ThemeEntity themeEntity) {
        themeJPA.delete(themeEntity);
    }
}
