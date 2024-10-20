package com.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long USerID;
    private String PhoneNumber;
    private String Name;
    private String FamilyName;
    private String BirthDate;
    private Gender gender;
    private MilitaryState militarystate;
    private String EmailAddress;
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
