package db.dao;

import db.pojo.MoviePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

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
}
