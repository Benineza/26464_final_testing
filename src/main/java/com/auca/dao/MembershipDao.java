package com.auca.dao;

import java.util.UUID;

import org.hibernate.Session;

import com.auca.domain.Membership;
import com.auca.domain.MembershipStatus;
import com.auca.util.DBConnection;

public class MembershipDao extends GenericDao<Membership, UUID> {
    public MembershipDao() {
        super(Membership.class);
    }

    public boolean hasActiveOrPendingMembership(UUID userId) {
        try (Session session = DBConnection.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(m) FROM Membership m WHERE m.reader.personId = :userId " +
                    "AND (m.membershipStatus = :approved OR m.membershipStatus = :pending)", Long.class)
                    .setParameter("userId", userId)
                    .setParameter("approved", MembershipStatus.APPROVED)
                    .setParameter("pending", MembershipStatus.PENDING)
                    .uniqueResult();
            return count != null && count > 0;
        }
    }
}