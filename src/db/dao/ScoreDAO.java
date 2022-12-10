package db.dao;

import db.pojo.ScorePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class ScoreDAO extends DAO<ScorePOJO> {

    protected ScoreDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ScorePOJO read(int id) {
        ScorePOJO scorePOJO = entityManager.find(ScorePOJO.class, id);
        if (scorePOJO == null) {
            throw new EntityNotFoundException("Can't find score for ID " + id);
        }
        return scorePOJO;
    }

    @Override
    public int getNextId() {
        Integer maxId = entityManager.createQuery("select max(scoreId) from Scores", Integer.class).getSingleResult();
        if (maxId == null) {
            return 0;
        }
        return maxId + 1;
    }

    public Set<ScorePOJO> readFromMovieId(int movieId) {
        Set<ScorePOJO> scoresPOJO = new HashSet<>();
        // TODO find all scores from a movie ID
        return scoresPOJO;
    }
}
