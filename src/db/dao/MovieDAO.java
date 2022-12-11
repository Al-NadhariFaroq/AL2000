package db.dao;

import db.pojo.MoviePOJO;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;

public class MovieDAO extends DAO<MoviePOJO> {
    private static MovieDAO instance;

    private MovieDAO() {
        super(MoviePOJO.class);
    }

    public static MovieDAO getInstance() {
        if (instance == null) {
            instance = new MovieDAO();
        }
        return instance;
    }

    public MoviePOJO readFromTitleAndDate(String title, Date date) {
        MoviePOJO moviePOJO = null;
        // TODO find movie from a title and a date
        if (moviePOJO == null) {
            throw new EntityNotFoundException("Can't find movie for title " + title + " and date " + date);
        }
        return moviePOJO;
    }
}
