package db.dao;

import java.util.ArrayList;
import java.util.List;

import db.entities.Theme;
import db.jpa.ThemeJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ThemeDAO implements DAO<Theme> {

    private final List<Theme> themes = new ArrayList<>();
    public EntityManagerFactory emf;
    private final ThemeJPA themeJPA;

    public ThemeDAO() {
        emf = Persistence.createEntityManagerFactory("AL2000");
        themeJPA = new ThemeJPA(emf.createEntityManager());
    }

    @Override
    public Theme get(int id) {
        return themeJPA.get(id);
    }

    @Override
    public List<Theme> getAll() {
        return themeJPA.getAll();
    }

    @Override
    public void save(Theme theme) {
        themeJPA.save(theme);
    }

    @Override
    public void update(Theme theme) {
        themeJPA.update(theme);
    }

    @Override
    public void delete(Theme theme) {
        themeJPA.delete(theme);
    }
}
