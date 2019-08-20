package com.academy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "schools")
@SequenceGenerator(name = "id_gen", sequenceName = "school_seq", initialValue = 1000, allocationSize = 1)
public class SchoolModel extends AbstractAuditingModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @ElementCollection
    @CollectionTable(name = "school_phone_numbers", joinColumns = @JoinColumn(name = "school_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "school")
    private List<AddressModel> addresses;

    @ManyToMany
    @JoinTable(name = "school_instructor",
                joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "instr_id", referencedColumnName = "id"))
    private List<InstructorModel> instructors;

    @OneToMany(mappedBy = "school")
    private List<StudentModel> students;

    @ManyToMany
    @JoinTable(name = "school_language",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lang_id", referencedColumnName = "id"))
    private List<LanguageModel> languages;



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

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public List<InstructorModel> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorModel> instructors) {
        this.instructors = instructors;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public List<LanguageModel> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageModel> languages) {
        this.languages = languages;
    }

    public void addLanguage(LanguageModel language) {
        if (language != null) {
            if (languages == null)
                languages = new ArrayList<>();
            if (languages.contains(language))
                return;
            languages.add(language);
            language.addSchool(this);
        }
    }
}
