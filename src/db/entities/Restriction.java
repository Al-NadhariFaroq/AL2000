package db.entities;

import javax.persistence.*;
import db.entities.Theme;

@Entity
@Table(name = "restrictions", schema = "", catalog = "") //schema to specify later
public class Restriction {
    @Id
    @Column
    private long restriction_id;
    @Basic
    @Column(nullable = false)
    private long card_number;
    @Basic
    @Column(nullable = false)
    private String last_name;

    @ManyToOne
    @JoinColumn(
            name = "theme_id",
            foreignKey = @ForeignKey(name = "restrictions_theme_fk", value = ConstraintMode.NO_CONSTRAINT)
    ) // a verifier

    private Theme theme;

}
