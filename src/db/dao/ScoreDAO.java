package db.dao;

import db.pojo.MoviePOJO;
import db.pojo.ScorePOJO;

import java.util.List;

public class ScoreDAO extends DAO<ScorePOJO> {
    private static ScoreDAO instance;

    private ScoreDAO() {
        super(ScorePOJO.class);
    }

    public static ScoreDAO getInstance() {
        if (instance == null) {
            instance = new ScoreDAO();
        }
        return instance;
    }

    public List<ScorePOJO> readFromMovieId(MoviePOJO movie) {
        String query = "SELECT S FROM scores S WHERE S.movie = :movie";
        return entityManager.createQuery(query, ScorePOJO.class).setParameter("movie", movie).getResultList();
    }
}
