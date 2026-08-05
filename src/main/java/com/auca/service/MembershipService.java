package com.auca.service;

import java.util.Date;
import java.util.UUID;

import com.auca.dao.GenericDao;
import com.auca.dao.MembershipDao;
import com.auca.dao.UserDao;
import com.auca.domain.Membership;
import com.auca.domain.MembershipStatus;
import com.auca.domain.MembershipType;
import com.auca.domain.User;

public class MembershipService {

    private final MembershipDao membershipDao = new MembershipDao();
    private final UserDao userDao = new UserDao();
    private final GenericDao<MembershipType, UUID> membershipTypeDao = new GenericDao<>(MembershipType.class);
    public Membership registerMembership(UUID userId, UUID membershipTypeId){
        User user = userDao.findById(userId);
        if (user == null){
            throw new IllegalArgumentException("User not found");
        }

        MembershipType type = membershipTypeDao.findById(membershipTypeId);
        if (type == null){
            throw new IllegalArgumentException("Membership type not found");
        }

        if (membershipDao.hasActiveOrPendingMembership(userId)){
            throw new IllegalStateException("User already has an active or pending membership");
        }

        Membership membership = new Membership();
        membership.setReader(user);
        membership.setMembershipType(type);
        membership.setMembershipCode("MEM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        membership.setRegistrationDate(new Date());
        membership.setMembershipStatus(MembershipStatus.PENDING);

        return membershipDao.save(membership);
    }
}