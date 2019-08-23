package com.academy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
@SequenceGenerator(name = "id_gen", sequenceName = "cities_seq", initialValue = 1000, allocationSize = 1)
public class CityModel extends AbstractModel {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<ContactModel> contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContactModel> getContact() {
        return contact;
    }

    public void setContact(Set<ContactModel> contact) {
        this.contact = contact;
    }
}
