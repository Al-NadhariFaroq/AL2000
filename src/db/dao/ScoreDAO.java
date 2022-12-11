package db.dao;

import db.pojo.ScorePOJO;

import java.util.HashSet;
import java.util.Set;

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

    public Set<ScorePOJO> readFromMovieId(int movieId) {
        Set<ScorePOJO> scoresPOJO = new HashSet<>();
        // TODO find all scores from a movie ID
        return scoresPOJO;
    }
}
