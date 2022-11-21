package db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLES", schema = "ALNADHAF", catalog = "")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROLE_ID")
    private int roleId;
    @Basic
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Basic
    @Column(name = "IS_PRODUCER")
    private Boolean isProducer;
    @Basic
    @Column(name = "PROFESSIONAL_ID")
    private int professionalId;
    @Basic
    @Column(name = "FILM_ID")
    private int filmId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getProducer() {
        return isProducer;
    }

    public void setProducer(Boolean producer) {
        isProducer = producer;
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role that = (Role) o;
        return roleId == that.roleId && professionalId == that.professionalId && filmId == that.filmId && Objects.equals(roleName, that.roleName) && Objects.equals(isProducer, that.isProducer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, isProducer, professionalId, filmId);
    }
}
