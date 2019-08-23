package com.academy.dto;

import java.util.Set;

public class SchoolDTO {
    private String name;
    private String description;
    private Double rating;
    private String email;
    private Set<ContactDTO> contacts;
    private Set<Long> languages;
    private Set<Long> studyTypes;

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

    public Set<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public Set<Long> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Long> languages) {
        this.languages = languages;
    }

    public Set<Long> getStudyTypes() {
        return studyTypes;
    }

    public void setStudyTypes(Set<Long> studyTypes) {
        this.studyTypes = studyTypes;
    }
}
