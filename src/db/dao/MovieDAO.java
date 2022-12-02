package db.dao;

import db.pojo.MoviePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class MovieDAO extends DAO<MoviePOJO> {

    protected MovieDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public MoviePOJO read(int id) {
        MoviePOJO moviePOJO = entityManager.find(MoviePOJO.class, id);
        if (moviePOJO == null) {
            throw new EntityNotFoundException("Can't find movie for ID " + id);
        }
        return moviePOJO;
    }

    public Set<MoviePOJO> readAll() {
        Set<MoviePOJO> moviesPOJO = new HashSet<>();
        // TODO read all
        return moviesPOJO;
    }
}
