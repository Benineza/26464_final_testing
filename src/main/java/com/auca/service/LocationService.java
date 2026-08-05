package com.auca.service;

import java.util.UUID;

import com.auca.dao.LocationDao;
import com.auca.dao.UserDao;
import com.auca.domain.Location;
import com.auca.domain.LocationType;
import com.auca.domain.User;

public class LocationService{

    private final LocationDao locationDao = new LocationDao();
    private final UserDao userDao = new UserDao();
    public Location createLocation(Location location, UUID parentId){
        if (locationDao.findByCode(location.getLocationCode()) != null){
            throw new IllegalArgumentException("Duplicate location code: " + location.getLocationCode());
        }

        if (location.getLocationType() == LocationType.PROVINCE){
            location.setParent(null);
        } else{
            if (parentId == null){
                throw new IllegalArgumentException("Parent ID cannot be null for non Province location");
            }
            Location parent = locationDao.findById(parentId);
            if (parent == null){
                throw new IllegalArgumentException("Parent location not found for ID: " + parentId);
            }
            location.setParent(parent);
        }

        return locationDao.save(location);
    }
    public String getProvinceNameByVillageId(UUID villageId){
        Location location = locationDao.findById(villageId);
        if (location == null){
            throw new IllegalArgumentException("Location not found");
        }

        Location current = location;
        while (current != null){
            if (current.getLocationType() == LocationType.PROVINCE){
                return current.getLocationName();
            }
            current = current.getParent();
        }
        return null;
    }
    public String getProvinceNameByPersonId(UUID personId){
        User user = userDao.findById(personId);
        if (user == null || user.getVillage() == null){
            throw new IllegalArgumentException("Person or village not found");
        }
        return getProvinceNameByVillageId(user.getVillage().getLocationId());
    }
}