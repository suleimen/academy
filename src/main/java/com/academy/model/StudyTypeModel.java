package com.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "study_type")
@SequenceGenerator(name = "id_gen", sequenceName = "study_seq", initialValue = 1000, allocationSize = 1)
public class StudyTypeModel extends AbstractModel {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "studyTypes")
    private Set<SchoolModel> schools;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SchoolModel> getSchools() {
        return schools;
    }

    public void setSchools(Set<SchoolModel> schools) {
        this.schools = schools;
    }
}
