package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Roles")
@Table(name = "ROLES", schema = "ALNADHAF", catalog = "")
public class RolePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int roleId;
    @JoinColumn(name="MOVIE_ID", referencedColumnName = "MOVIE_ID")
    @ManyToOne(optional = false)
    private MoviePOJO movie;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "ACTOR_RANK")
    private int actorRank;
    @Basic
    @Column(name = "DIRECTOR_RANK")
    private int directorRank;
    @Basic
    @Column(name = "CHARACTER")
    private String character;

    public RolePOJO() {

    }

    public RolePOJO(MoviePOJO movie, String name, int actorRank, int directorRank, String character) {
        this.movie = movie;
        this.name = name;
        this.actorRank = actorRank;
        this.directorRank = directorRank;
        this.character = character;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public int getActorRank() {
        return actorRank;
    }

    public void setActorRank(int actor) {
        this.actorRank = actor;
    }

    public int getDirectorRank() {
        return directorRank;
    }

    public void setDirectorRank(int director) {
        this.directorRank = director;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RolePOJO)) {
            return false;
        }
        RolePOJO rolePOJO = (RolePOJO) o;
        return roleId == rolePOJO.roleId && movie.getMovieId() == rolePOJO.movie.getMovieId() && actorRank == rolePOJO.actorRank &&
               directorRank == rolePOJO.directorRank && Objects.equals(name, rolePOJO.name) &&
               Objects.equals(character, rolePOJO.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, movie.getTitle(), name, actorRank, directorRank, character);
    }
}
