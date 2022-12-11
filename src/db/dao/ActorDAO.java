package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.ActorPOJO;

import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DAO<ActorPOJO> {
    private static ActorDAO instance;

    private ActorDAO() {
        super(ActorPOJO.class);
    }

    public static ActorDAO getInstance() {
        if (instance == null) {
            instance = new ActorDAO();
        }
        return instance;
    }

    @Override
    public void delete(ActorPOJO actorPOJO) {
        MoviePOJO moviePOJO = DAOFactory.getMovieDAO().read(actorPOJO.getMovie().getID());
        if (!moviePOJO.getActors().isEmpty()) {
            moviePOJO.getActors().remove(actorPOJO);
            entityManager.merge(moviePOJO);
        }
        executeInsideTransaction(entityManager -> entityManager.remove(actorPOJO));
    }

    public List<ActorPOJO> readFromMovieId(int movieId) {
        List<ActorPOJO> actorsPOJO = new ArrayList<>();
        // TODO find all actors from a movie ID order by actor_rank
        return actorsPOJO;
    }
}
