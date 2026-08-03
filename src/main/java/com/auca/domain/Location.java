package com.auca.domain;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "location_code", unique = true, nullable = false)
    private String locationCode;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type", nullable = false)
    private LocationType locationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Location parent;

    public Location() {

    }

    public Location(String locationCode, String locationName, LocationType locationType){
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
    }

    public UUID getLocationId(){ 
        return locationId; 
    }
    public void setLocationId(UUID locationId){ 
        this.locationId = locationId; 
    }
    public String getLocationCode(){ 
        return locationCode; 
    }
    public void setLocationCode(String locationCode){ 
        this.locationCode = locationCode; 
    }
    public String getLocationName(){ 
        return locationName; 
    }
    public void setLocationName(String locationName){ 
        this.locationName = locationName; 
    }
    public LocationType getLocationType(){ 
        return locationType; 
    }
    public void setLocationType(LocationType locationType){ 
        this.locationType = locationType; 
    }
    public Location getParent(){ 
        return parent; 
    }
    public void setParent(Location parent) { this.parent = parent; }
}