package com.academy.model;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@SequenceGenerator(name = "location_gen", sequenceName = "location_seq", initialValue = 1000, allocationSize = 1)
public class LocationModel extends AbstractAuditingModel {

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToOne(mappedBy = "location")
    private SchoolModel schoolModel;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
