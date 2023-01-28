package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_number")
    private int schoolNumber;

    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principalId;

    public School(){}

    public School(int schoolNumber, Principal principalId) {
        this.schoolNumber = schoolNumber;
        this.principalId = principalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Principal getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Principal principalId) {
        this.principalId = principalId;
    }

}
