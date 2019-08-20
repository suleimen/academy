package com.academy.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@SequenceGenerator(name = "id_gen", sequenceName = "cities_seq", initialValue = 1000, allocationSize = 1)
public class CityModel extends AbstractModel {

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "city")
    private AddressModel address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
