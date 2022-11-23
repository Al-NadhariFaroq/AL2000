package db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROFESSIONALS", schema = "ALNADHAF", catalog = "")
public class Professional {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROFESSIONAL_ID")
    private int professionalId;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Professional that = (Professional) o;
        return professionalId == that.professionalId && Objects.equals(lastName, that.lastName) && Objects.equals(
                firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professionalId, lastName, firstName);
    }
}
