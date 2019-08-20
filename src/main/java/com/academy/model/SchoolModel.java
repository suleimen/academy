package com.academy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schools")
@SequenceGenerator(name = "school_gen", sequenceName = "school_seq", initialValue = 1000, allocationSize = 1)
public class SchoolModel extends AbstractAuditingModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationModel location;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "school_instructor",
                joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "instr_id", referencedColumnName = "id"))
    private List<InstructorModel> instructors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public List<InstructorModel> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorModel> instructors) {
        this.instructors = instructors;
    }
}
