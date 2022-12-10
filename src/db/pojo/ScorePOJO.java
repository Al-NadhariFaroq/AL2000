package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Scores")
@Table(name = "SCORES", schema = "ALNADHAF", catalog = "")
public class ScorePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCORE_ID")
    private int scoreId;

    @ManyToOne
    @JoinColumn(name = "SUBSCRIBER_ID")
    private SubscriberPOJO subscriber;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private MoviePOJO movie;
    @Basic
    @Column(name = "SCORE")
    private int score;

    public ScorePOJO() {

    }

    public ScorePOJO(SubscriberPOJO subscriber, MoviePOJO movie, int score) {
        this.subscriber = subscriber;
        this.movie = movie;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public SubscriberPOJO getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberPOJO subscriber) {
        this.subscriber = subscriber;
    }

    public MoviePOJO getMovieId() {
        return movie;
    }

    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
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
        return scoreId == scorePOJO.scoreId && subscriber.getSubscriberId() == scorePOJO.subscriber.getSubscriberId() && movie.getMovieId() == scorePOJO.movie.getMovieId() &&
               score == scorePOJO.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, subscriber.getFirstName()+" "+subscriber.getLastName(), movie.getTitle(), score);
    }
}
