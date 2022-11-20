package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "blu_rays", schema = "", catalog = "") //schema to specify later
public class BluRay{
    @Id
    @Column
    private long blu_ray_id;
    @Basic
    @Column(nullable = false)
    private long serial_number;
    @Basic
    @Column(nullable = false)
    private int blu_ray_position;

    @ManyToOne
    @JoinColumn(
            name = "film_id",
            foreignKey = @ForeignKey(name = "blu_rays_film_fk", value = ConstraintMode.NO_CONSTRAINT)
    )

    private Film film;

    public BluRay(long blu_ray_id, long serial_number, int blu_ray_position, Film film) {
        this.blu_ray_id = blu_ray_id;
        this.serial_number = serial_number;
        this.blu_ray_position = blu_ray_position;
        this.film = film;
    }
    public BluRay(){

    }

    public long getId() {
        return blu_ray_id;
    }

    public void setId(long blu_ray_id) {
        this.blu_ray_id = blu_ray_id;
    }

    public long getSerialNumber() {
        return serial_number;
    }

    public void setSerialnumber(long serial_number) {
        this.serial_number = serial_number;
    }

    public int getBluRayPosition() {
        return blu_ray_position;
    }

    public void setBluRayPosition(int blu_ray_position) {
        this.blu_ray_position = blu_ray_position;
    }

}

