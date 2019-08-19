package com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@SequenceGenerator(name = "id_gen", sequenceName = "student_seq", initialValue = 1000, allocationSize = 1)
public class StudentModel extends UserModel {

    @Column(name = "phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
