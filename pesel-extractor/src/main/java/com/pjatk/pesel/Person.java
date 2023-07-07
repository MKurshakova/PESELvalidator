package com.pjatk.pesel;

import java.time.LocalDate;


public class Person {
    private String peselNumber;
    private String name;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;

    public Person(String peselNumber) {
        if (!PeselValidator.isValid(pesel)) {
            throw new IllegalArgumentException("Invalid PESEL.");
        }

        this.pesel = peselNumber;
        this.gender = extractGender(peselNumber);
        this.dateOfBirth = extractDateOfBirth(peselNumber);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private String extractGender(String peselNumber){
        int number = Integer.parseInt(String.valueOf(peselNumber.charAt(9)));
        return (gender % 2 == 0) ? "male" : "female";
    }

    private LocalDate extractDateOfBirth(String peselNumber){
        int year = Integer.parseInt(peselNumber.substring(0,2));
        int month = Integer.parseInt(peselNumber.substring(2,4));
        int day = Integer.parseInt(peselNumber.substring(4,6));
        LocalDate date = LocalDate.of(1900 + year, month, day);
        return date;
    }

}
