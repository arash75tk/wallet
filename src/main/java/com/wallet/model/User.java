package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern( regexp ="^09[0-9]{9}$")
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String familyName;
    @Column(nullable = false)
    private String birthDate;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private MilitaryState militaryState;
    @Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-] + \\.[a-zA-Z]{2,}$")
    @Column(nullable = true)
    private String emailAddress;
    @Pattern(regexp = "^\\d{10}$")
    @Column(nullable = false, unique=true)
    private String nationalNumber;

    @Column(nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUSerID() {
        return id;
    }

    public void setUSerID(Long USerID) {
        this.id = USerID;
    }

    public MilitaryState getMilitaryState() {
        return militaryState;
    }

    public void setMilitaryState(MilitaryState militarystate) {
        this.militaryState = militarystate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User() {}

    public void UpdateUserFeilds(User user){
        this.phoneNumber = user.phoneNumber;
        this.name = user.name;
        this.familyName = user.familyName;
        this.birthDate = user.birthDate;
        this.gender = user.gender;
        this.militaryState = user.militaryState;
        this.emailAddress = user.emailAddress;
        this.nationalNumber = user.nationalNumber;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
