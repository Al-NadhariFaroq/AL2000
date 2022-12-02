package db.dao;

import db.pojo.BluRayPOJO;

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

    public BluRayPOJO readFromSerialNumber(int serialNumber) {
        BluRayPOJO bluRayPOJO = null;
        // TODO find from a serial number
        if (bluRayPOJO == null) {
            throw new EntityNotFoundException("Can't find blu-ray for serial number " + serialNumber);
        }
        return bluRayPOJO;
    }

    public Set<BluRayPOJO> readAll() {
        Set<BluRayPOJO> bluRaysPOJO = new HashSet<>();
        // TODO read all
        return bluRaysPOJO;
    }
}
