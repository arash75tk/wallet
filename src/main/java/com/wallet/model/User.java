package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long USerID;
    @Pattern( regexp ="^09[0-9]{9}$")
    @Column(nullable = false)
    private String PhoneNumber;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String FamilyName;
    @Column(nullable = false)
    private String BirthDate;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private MilitaryState militarystate;
    @Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-] + \\.[a-zA-Z]{2,}$")
    @Column(nullable = true)
    private String EmailAddress;
    @Pattern(regexp = "^\\d{10}$")
    @Column(nullable = false, unique=true)
    private String NationalNumber;

    public String getNationalNumber() {
        return NationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        NationalNumber = nationalNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public Long getUSerID() {
        return USerID;
    }

    public void setUSerID(Long USerID) {
        this.USerID = USerID;
    }

    public MilitaryState getMilitarystate() {
        return militarystate;
    }

    public void setMilitarystate(MilitaryState militarystate) {
        this.militarystate = militarystate;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public User() {}


}
