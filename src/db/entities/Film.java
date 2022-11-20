package db.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "films", schema = "", catalog = "") //schema to specify later
public class Film{
    @Id
    @Column
    private long film_id;

    @Basic
    @Column(nullable = false)
    private String title;

    @Basic
    @Column(nullable = false)
    private Date release_date;

    @Basic
    @Column
    private String synopsis;

    @Basic
    @Column
    private int rating;

    @Basic
    @Column
    private int age_limit;

    @OneToMany //a verifier
    @JoinColumn(name = "blu_rays", foreignKey = @ForeignKey( name = "blu_rays_film_fk" ) )
    public List<BluRay> blu_rays;

    public Film(long film_id, String title, Date release_date, String synopsis) {
        this.film_id = film_id;
        this.title = title;
        this.release_date = release_date;
        this.synopsis = synopsis;
    }
    public Film(){

    }

    public long getId() {
        return film_id;
    }

    public void setId(long film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAgeLimit() {
        return age_limit;
    }

    public void setAgeLimit(int age_limit) {
        this.age_limit = age_limit;
    }

    public List<BluRay> getBluRays() {
        return blu_rays;
    }

    public void setBluRays(List<BluRay> blu_rays) {
        this.blu_rays = blu_rays;
    }
}

