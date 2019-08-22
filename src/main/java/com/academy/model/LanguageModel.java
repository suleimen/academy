package com.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
@SequenceGenerator(name = "id_gen", sequenceName = "languages_seq", initialValue = 1000, allocationSize = 1)
public class LanguageModel extends AbstractModel {

    @Column(name = "code")
    private String code;

    @Column(name = "name_ru")
    private String name_ru;

    @Column(name = "name_en")
    private String name_en;

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
    private List<SchoolModel> schools;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public List<SchoolModel> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolModel> schools) {
        this.schools = schools;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public void addSchool(SchoolModel school) {
        if (school != null) {
            if (schools == null)
                schools = new ArrayList<>();
            if (schools.contains(school))
                return;
            schools.add(school);
            school.addLanguage(this);
        }
    }
}
