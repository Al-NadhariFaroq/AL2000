package db.dao;

import db.pojo.BluRayPOJO;
import db.pojo.MoviePOJO;
import db.pojo.RolePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class BluRayDAO extends DAO<BluRayPOJO> {

    protected BluRayDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public BluRayPOJO read(int id) {
        BluRayPOJO bluRayPOJO = entityManager.find(BluRayPOJO.class, id);
        if (bluRayPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray for ID " + id);
        }
        return bluRayPOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(bluRayId) from Blu_Rays", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }

    public BluRayPOJO readFromSerialNumber(int serialNumber) {
        BluRayPOJO bluRayPOJO = null;
        // TODO find blu-ray from a serial number
        if (bluRayPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray for serial number " + serialNumber);
        }
        return bluRayPOJO;
    }

    public Set<BluRayPOJO> readAll() {
        Set<BluRayPOJO> bluRaysPOJO = new HashSet<>();
        // TODO read all blu-rays
        return bluRaysPOJO;
    }

    public void delete(BluRayPOJO bluRayPOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(bluRayPOJO.getMovie().getMovieId());
        if(!moviePOJO.getBluRayPOJOList().isEmpty()){
            moviePOJO.getBluRayPOJOList().remove(bluRayPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(bluRayPOJO));
    }
}
