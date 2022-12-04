package db.dao;

import db.pojo.RolePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO<RolePOJO> {

    protected RoleDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public RolePOJO read(int id) {
        RolePOJO rolePOJO = entityManager.find(RolePOJO.class, id);
        if (rolePOJO == null) {
            throw new EntityNotFoundException("Can't find restriction for ID " + id);
        }
        return rolePOJO;
    }

    public List<RolePOJO> readDirectorsFromMovieId(int movieId) {
        List<RolePOJO> rolesPOJO = new ArrayList<>();
        // TODO find all directors from a movie ID order by director_rank
        return rolesPOJO;
    }

    public List<RolePOJO> readActorsFromMovieId(int movieId) {
        List<RolePOJO> rolesPOJO = new ArrayList<>();
        // TODO find all actors from a movie ID order by actor_rank
        return rolesPOJO;
    }
}
