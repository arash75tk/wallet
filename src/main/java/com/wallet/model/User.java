package com.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long USerID;
    @Pattern( regexp ="^09[0-9]{9}$")
    private String PhoneNumber;
    private String Name;
    private String FamilyName;
    private String BirthDate;
    private Gender gender;
    private MilitaryState militarystate;
    @Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-] + \\.[a-zA-Z]{2,}$")
    private String EmailAddress;
    @Pattern(regexp = "^\\d{10}$")
    private Long NationalNumber;

    public Long getNationalNumber() {
        return NationalNumber;
    }

    public void setNationalNumber(Long nationalNumber) {
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
