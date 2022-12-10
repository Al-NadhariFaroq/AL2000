package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Scores")
@Table(name = "SCORES", schema = "ALNADHAF", catalog = "")
public class ScorePOJO {
    @Id
    @Column(name = "SCORE_ID")
    private int scoreId;
    @Basic
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberId;
    @Basic
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Basic
    @Column(name = "SCORE")
    private int score;

    public ScorePOJO() {

    }

    public ScorePOJO(int scoreId, int subscriberId, int movieId, int score) {
        this.scoreId = scoreId;
        this.subscriberId = subscriberId;
        this.movieId = movieId;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ScorePOJO)) {
            return false;
        }
        ScorePOJO scorePOJO = (ScorePOJO) o;
        return scoreId == scorePOJO.scoreId && subscriberId == scorePOJO.subscriberId && movieId == scorePOJO.movieId &&
               score == scorePOJO.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, subscriberId, movieId, score);
    }
}
