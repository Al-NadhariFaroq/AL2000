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
        String query = "SELECT M FROM movies M WHERE M.title = :title AND M.releaseDate = :date";
        MoviePOJO moviePOJO = entityManager.createQuery(query, MoviePOJO.class)
                                           .setParameter("title", title)
                                           .setParameter("date", date)
                                           .getSingleResult();

        if (moviePOJO == null) {
            throw new EntityNotFoundException("Can't find movie for title " + title + " and date " + date);
        }
        return moviePOJO;
    }
}
