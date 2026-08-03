package com.auca.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends Person {

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "village_id")
    private Location village;

    public User() {

    }

    public User(String firstName, String lastName, Gender gender, String phoneNumber, String username, String password, Role role, Location village){
        super(firstName, lastName, gender, phoneNumber);
        this.username = username;
        this.password = password;
        this.role = role;
        this.village = village;
    }

    public String getUsername(){ 
        return username; 
    }
    public void setUsername(String username){ 
        this.username = username; 
    }
    public String getPassword(){ 
        return password; 
    }
    public void setPassword(String password){ 
        this.password = password; 
    }
    public Role getRole(){ 
        return role; 
    }
    public void setRole(Role role){ 
        this.role = role; 
    }
    public Location getVillage(){ 
        return village; 
    }
    public void setVillage(Location village){ 
        this.village = village; 
    }
}