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
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(rentalPOJO.getMovie().getID());
        if (!moviePOJO.getRentals().isEmpty()) {
            moviePOJO.getRentals().remove(rentalPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(rentalPOJO));
    }

    public RentalPOJO readFromMovieAndDate(MoviePOJO movie, Date date) {
        String query = "SELECT R FROM rentals R WHERE R.movie = :movie AND R.rentalDate = :date";
        RentalPOJO rentalPOJO = entityManager.createQuery(query, RentalPOJO.class)
                                             .setParameter("movie", movie)
                                             .setParameter("date", date)
                                             .getSingleResult();

        if (rentalPOJO == null) {
            throw new EntityNotFoundException("Can't find rental for movie " + movie.getTitle() + " and date " + date);
        }
        return rentalPOJO;
    }
}
