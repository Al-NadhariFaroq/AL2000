package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "scores")
@Table(name = "scores", schema = "rocd", catalog = "")
public class ScorePOJO implements POJO {
    @Id
    @Column(name = "score_id")
    private int scoreId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subscriber_id")
    private SubscriberPOJO subscriber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private MoviePOJO movie;

    @Basic(optional = false)
    @Column(name = "score")
    private int score;

    public ScorePOJO() {
        super();
    }

    public ScorePOJO(int scoreId, SubscriberPOJO subscriber, MoviePOJO movie, int score) {
        super();
        this.scoreId = scoreId;
        this.subscriber = subscriber;
        this.movie = movie;
        this.score = score;
    }

    public int getID() {
        return scoreId;
    }

    public void setID(int scoreId) {
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
        return scoreId == scorePOJO.scoreId && subscriber.getID() == scorePOJO.subscriber.getID() &&
               movie.getID() == scorePOJO.movie.getID() && score == scorePOJO.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId,
                            subscriber.getFirstName() + " " + subscriber.getLastName(),
                            movie.getTitle(),
                            score
        );
    }
}
