package db.dao;

import db.pojo.BluRayPOJO;
import db.pojo.MoviePOJO;

import javax.persistence.EntityNotFoundException;

public class BluRayDAO extends DAO<BluRayPOJO> {
    private static BluRayDAO instance;

    private BluRayDAO() {
        super(BluRayPOJO.class);
    }

    public static BluRayDAO getInstance() {
        if (instance == null) {
            instance = new BluRayDAO();
        }
        return instance;
    }

    @Override
    public void delete(BluRayPOJO bluRayPOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(bluRayPOJO.getMovie().getMovieId());
        if (!moviePOJO.getBluRayPOJOList().isEmpty()) {
            moviePOJO.getBluRayPOJOList().remove(bluRayPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(bluRayPOJO));
    }

    public BluRayPOJO readFromSerialNumber(int serialNumber) {
        BluRayPOJO bluRayPOJO = null;
        // TODO find blu-ray from a serial number
        if (bluRayPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray for serial number " + serialNumber);
        }
        return bluRayPOJO;
    }
}
