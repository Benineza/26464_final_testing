package com.auca.dao;

import org.hibernate.Session;

import com.auca.domain.Location;
import com.auca.util.DBConnection;

public class LocationDao extends GenericDao<Location, java.util.UUID> {
    public LocationDao() {
        super(Location.class);
    }

    public Location findByCode(String code){
        try (Session session = DBConnection.getSessionFactory().openSession()){
            return session.createQuery("FROM Location l WHERE l.locationCode = :code", Location.class)
                    .setParameter("code", code)
                    .uniqueResult();
        }
    }
}