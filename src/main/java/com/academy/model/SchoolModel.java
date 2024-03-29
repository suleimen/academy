package com.academy.model;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "school", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<ContactModel> contacts;

    @ManyToMany
    @JoinTable(name = "school_instructor",
                joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "instr_id", referencedColumnName = "id"))
    private Set<InstructorModel> instructors;

    @ManyToMany
    @JoinTable(name = "school_student",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<StudentModel> students;

    @ManyToMany
    @JoinTable(name = "school_language",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lang_id", referencedColumnName = "id"))
    private Set<LanguageModel> languages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "school_type",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "study_type_id", referencedColumnName = "id"))
    private Set<StudyTypeModel> studyTypes;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public Set<InstructorModel> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<InstructorModel> instructors) {
        this.instructors = instructors;
    }

    public Set<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentModel> students) {
        this.students = students;
    }

    public Set<LanguageModel> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<LanguageModel> languages) {
        this.languages = languages;
    }

    public Set<StudyTypeModel> getStudyTypes() {
        return studyTypes;
    }

    public void setStudyTypes(Set<StudyTypeModel> studyTypes) {
        this.studyTypes = studyTypes;
    }

    public void addLanguage(LanguageModel language) {
        if (language != null) {
            if (languages == null)
                languages = new HashSet<>();
            if (languages.contains(language))
                return;
            languages.add(language);
            language.addSchool(this);
        }
    }


}
