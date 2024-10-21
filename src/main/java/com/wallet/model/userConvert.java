package com.wallet.model;

public class userConvert {
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getMilitaryState() {
        return militaryState;
    }

    public void setMilitaryState(int militaryState) {
        this.militaryState = militaryState;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    private String phoneNumber;
    private String birthDate;
    private int gender; // Use int for gender
    private int militaryState; // Use int for militaryState
    private String emailAddress;
    private String nationalNumber;
    private String password;
    private String name;
    private String familyName;

    public User convertToEntity(userConvert uc) {
        User user = new User();
        user.setPhoneNumber(uc.getPhoneNumber());
        user.setBirthDate(uc.getBirthDate());
        user.setGender(Gender.values()[uc.getGender()]); // Convert int to enum
        user.setMilitaryState(MilitaryState.values()[uc.getMilitaryState()]); // Convert int to enum
        user.setEmailAddress(uc.getEmailAddress());
        user.setNationalNumber(uc.getNationalNumber());
        user.setPassword(uc.getPassword());
        user.setName(uc.getName());
        user.setFamilyName(uc.getFamilyName());
        return user;
    }
}
