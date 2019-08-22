package com.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@SequenceGenerator(name = "id_gen", sequenceName = "student_seq", initialValue = 1000, allocationSize = 1)
public class StudentModel extends UserModel {

    @Column(name = "phone")
    private String phone;

    @ManyToMany(mappedBy = "students")
    private Set<SchoolModel> schools;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<SchoolModel> getSchools() {
        return schools;
    }

    public void setSchools(Set<SchoolModel> schools) {
        this.schools = schools;
    }
}
