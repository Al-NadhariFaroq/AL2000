package db.dao;

import db.pojo.MoviePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.sql.Date;
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

    public MoviePOJO readFromTitleAndDate(String title, Date date) {
        MoviePOJO moviePOJO = null;
        // TODO find movie from a title and a date
        if (moviePOJO == null) {
            throw new EntityNotFoundException("Can't find movie for title " + title + " and date " + date);
        }
        return moviePOJO;
    }

    public Set<MoviePOJO> readAll() {
        Set<MoviePOJO> moviesPOJO = new HashSet<>();
        // TODO read all movies
        return moviesPOJO;
    }
}
