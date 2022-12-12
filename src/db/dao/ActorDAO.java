package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.ActorPOJO;

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
}
