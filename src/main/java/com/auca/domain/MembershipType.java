package com.auca.domain;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership_types")
public class MembershipType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "membership_type_id")
    private UUID membershipTypeId;

    @Column(name = "membership_name", nullable = false)
    private String membershipName;

    @Column(name = "max_books", nullable = false)
    private int maxBooks;

    @Column(name = "price", nullable = false)
    private int price;

    public MembershipType() {}

    public MembershipType(String membershipName, int maxBooks, int price) {
        this.membershipName = membershipName;
        this.maxBooks = maxBooks;
        this.price = price;
    }

    public UUID getMembershipTypeId(){ 
        return membershipTypeId; 
    }
    public void setMembershipTypeId(UUID membershipTypeId){ 
        this.membershipTypeId = membershipTypeId; 
    }
    public String getMembershipName(){ 
        return membershipName; 
    }
    public void setMembershipName(String membershipName){ 
        this.membershipName = membershipName; 
    }
    public int getMaxBooks(){ 
        return maxBooks; 
    }
    public void setMaxBooks(int maxBooks){ 
        this.maxBooks = maxBooks; 
    }
    public int getPrice(){ 
        return price; 
    }
    public void setPrice(int price){ 
        this.price = price; 
    }
}
