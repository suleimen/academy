package com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "instructors")
@SequenceGenerator(name = "id_gen", sequenceName = "instructors_seq", initialValue = 1000, allocationSize = 1)
public class InstructorModel extends UserModel {

    @Column(name = "rating")
    private Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
