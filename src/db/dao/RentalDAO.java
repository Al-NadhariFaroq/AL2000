package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.RentalPOJO;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;

public class RentalDAO extends DAO<RentalPOJO> {
    private static RentalDAO instance;

    private RentalDAO() {
        super(RentalPOJO.class);
    }

    public static RentalDAO getInstance() {
        if (instance == null) {
            instance = new RentalDAO();
        }
        return instance;
    }

    @Override
    public void delete(RentalPOJO rentalPOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(rentalPOJO.getMovie().getMovieId());
        if (!moviePOJO.getRentalPOJOList().isEmpty()) {
            moviePOJO.getRentalPOJOList().remove(rentalPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(rentalPOJO));
    }

    public RentalPOJO readFromMovieAndDate(int movieId, Date date) {
        RentalPOJO rentalPOJO = null;
        // TODO find rental from a movie ID and a date
        if (rentalPOJO == null) {
            throw new EntityNotFoundException("Can't find rental for movie " + movieId + " and date " + date);
        }
        return rentalPOJO;
    }
}
