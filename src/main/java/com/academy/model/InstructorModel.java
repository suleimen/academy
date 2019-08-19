package com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "instructors")
@SequenceGenerator(name = "id_gen", sequenceName = "instructors_seq", initialValue = 1000, allocationSize = 1)
public class InstructorModel extends UserModel {

    @Column(name = "rate")
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
