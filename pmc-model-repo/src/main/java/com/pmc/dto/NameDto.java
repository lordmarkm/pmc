package com.pmc.dto;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public class NameDto {

    private String givenName;
    private String middleName;
    private String surname;

    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
