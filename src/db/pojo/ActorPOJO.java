package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "actors")
@Table(name = "actors", schema = "rocd", catalog = "")
public class ActorPOJO implements POJO {
    @Id
    @Column(name = "actor_id")
    private int actorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private MoviePOJO movie;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "character")
    private String character;

    @Basic
    @Column(name = "actor_rank")
    private int actorRank;

    public ActorPOJO() {
        super();
    }

    public ActorPOJO(int actorId, MoviePOJO movie, String name, String character, int actorRank) {
        super();
        this.actorId = actorId;
        this.movie = movie;
        this.name = name;
        this.character = character;
        this.actorRank = actorRank;
    }

    public int getID() {
        return actorId;
    }

    public void setID(int actorId) {
        this.actorId = actorId;
    }

    public MoviePOJO getMovie() {
        return movie;
    }

    public void setMovie(MoviePOJO movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getActorRank() {
        return actorRank;
    }

    public void setActorRank(int actor) {
        this.actorRank = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActorPOJO)) {
            return false;
        }
        ActorPOJO actorPOJO = (ActorPOJO) o;
        return actorId == actorPOJO.actorId && movie.getID() == actorPOJO.movie.getID() &&
               actorRank == actorPOJO.actorRank && Objects.equals(character, actorPOJO.character) &&
               Objects.equals(name, actorPOJO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movie.getTitle(), name, character, actorRank);
    }
}
