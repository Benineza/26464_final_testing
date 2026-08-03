package com.auca.domain;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "person_id")
    private UUID personId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Person() {}

    public Person(String firstName, String lastName, Gender gender, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public UUID getPersonId(){ 
        return personId; 
    }
    public void setPersonId(UUID personId){ 
        this.personId = personId; 
    }
    public String getFirstName(){
        return firstName; 
    }
    public void setFirstName(String firstName){ 
        this.firstName = firstName; 
    }
    public String getLastName(){ 
        return lastName; 
    }
    public void setLastName(String lastName){ 
        this.lastName = lastName; 
    }
    public Gender getGender(){ 
        return gender; 
    }
    public void setGender(Gender gender){ 
        this.gender = gender; 
    }
    public String getPhoneNumber(){ 
        return phoneNumber; 
    }
    public void setPhoneNumber(String phoneNumber){ 
        this.phoneNumber = phoneNumber; 
    }
}