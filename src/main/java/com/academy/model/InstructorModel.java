package com.academy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
@SequenceGenerator(name = "id_gen", sequenceName = "instructors_seq", initialValue = 1000, allocationSize = 1)
public class InstructorModel extends UserModel {

    @Column(name = "rating")
    private Double rating;

    @ManyToMany(mappedBy = "instructors")
    private List<SchoolModel> schools;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<SchoolModel> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolModel> schools) {
        this.schools = schools;
    }
}
