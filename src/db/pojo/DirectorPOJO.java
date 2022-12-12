package db.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity(name = "directors")
@Table(name = "directors", schema = "rocd", catalog = "")
public class DirectorPOJO implements POJO {
    @Id
    @Column(name = "director_id")
    private int directorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private MoviePOJO movie;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "director_rank")
    private int directorRank;

    public DirectorPOJO() {
        super();
    }

    public DirectorPOJO(int directorId, MoviePOJO movie, String name, int directorRank) {
        super();
        this.directorId = directorId;
        this.movie = movie;
        this.name = name;
        this.directorRank = directorRank;
    }

    public int getID() {
        return directorId;
    }

    public void setID(int directorId) {
        this.directorId = directorId;
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

    public int getDirectorRank() {
        return directorRank;
    }

    public void setDirectorRank(int director) {
        this.directorRank = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DirectorPOJO)) {
            return false;
        }
        DirectorPOJO directorPOJO = (DirectorPOJO) o;
        return directorId == directorPOJO.directorId && movie.getID() == directorPOJO.movie.getID() &&
               directorRank == directorPOJO.directorRank && Objects.equals(name, directorPOJO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId, movie.getTitle(), name, directorRank);
    }
}
