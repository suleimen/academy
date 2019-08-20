package com.academy.dto;

import java.util.Set;

public class SchoolDTO {
    private String name;
    private String description;
    private Double rating;
    private Set<String> phoneNumbers;
    private String email;
    private Set<AddressDTO> addresses;
    private Set<Long> languages;

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

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public Set<Long> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Long> languages) {
        this.languages = languages;
    }
}
