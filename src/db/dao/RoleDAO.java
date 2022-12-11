package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.RolePOJO;

import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO<RolePOJO> {
    private static RoleDAO instance;

    private RoleDAO() {
        super(RolePOJO.class);
    }

    public static RoleDAO getInstance() {
        if (instance == null) {
            instance = new RoleDAO();
        }
        return instance;
    }

    @Override
    public void delete(RolePOJO rolePOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(rolePOJO.getMovie().getMovieId());
        if (!moviePOJO.getRolePOJOList().isEmpty()) {
            moviePOJO.getRolePOJOList().remove(rolePOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(rolePOJO));
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
