package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.RentalPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.sql.Date;

public class RentalDAO extends DAO<RentalPOJO> {

    protected RentalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public RentalPOJO read(int id) {
        RentalPOJO rentalPOJO = entityManager.find(RentalPOJO.class, id);
        if (rentalPOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return rentalPOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(rentalId) from Rentals", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }

    public RentalPOJO readFromMovieAndDate(int movieId, Date date) {
        RentalPOJO rentalPOJO = null;
        // TODO find rental from a movie ID and a date
        if (rentalPOJO == null) {
            throw new EntityNotFoundException("Can't find rental for movie " + movieId + " and date " + date);
        }
        return rentalPOJO;
    }
    public void delete(RentalPOJO rentalPOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(rentalPOJO.getMovie().getMovieId());
        if(!moviePOJO.getRentalPOJOList().isEmpty()){
            moviePOJO.getRentalPOJOList().remove(rentalPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(rentalPOJO));
    }

}
