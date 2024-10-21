package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    @Pattern( regexp ="^09[0-9]{9}$")
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
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
        return userID;
    }

    public void setUSerID(Long USerID) {
        this.userID = USerID;
    }

    public MilitaryState getMilitarystate() {
        return militaryState;
    }

    public void setMilitarystate(MilitaryState militarystate) {
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


}
