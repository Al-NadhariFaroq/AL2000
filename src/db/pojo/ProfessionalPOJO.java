package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROFESSIONALS", schema = "ALNADHAF", catalog = "")
public class ProfessionalPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROFESSIONAL_ID")
    private int professionalId;
    @Basic
    @Column(name = "NAME")
    private String name;

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfessionalPOJO that = (ProfessionalPOJO) o;
        return professionalId == that.professionalId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professionalId, name);
    }
}
