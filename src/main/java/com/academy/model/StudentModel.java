package com.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "students")
@SequenceGenerator(name = "id_gen", sequenceName = "student_seq", initialValue = 1000, allocationSize = 1)
public class StudentModel extends UserModel {

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolModel school;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SchoolModel getSchool() {
        return school;
    }

    public void setSchool(SchoolModel school) {
        this.school = school;
    }
}
