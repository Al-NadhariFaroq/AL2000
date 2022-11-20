package db.entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Basic;

@Entity
@Table(name = "professionals", schema = "", catalog = "") //schema to specify later
public class Professional {
    @Id
    @Column
    private long professional_id;
    @Basic
    @Column(nullable = false)
    private String first_name;
    @Basic
    @Column(nullable = false)
    private String last_name;

    // constructors / standard setters / getters
    public Professional(long professional_id, String first_name, String last_name){
        this.professional_id = professional_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Professional() {
    }
    public long getId(){
        return this.professional_id;
    }
    public void setId(long id) {
        this.professional_id = id;
    }
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    public String getFirstName(){
        return this.first_name;
    }
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    public String getLastName(){
        return this.last_name;
    }

    public String toString(){
        return this.first_name + " " + this.last_name;
    }



}
