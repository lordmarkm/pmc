package com.pmc.model.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

    @Column(name = "GIVEN_NAME")
    private String givenName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "SURNAME")
    private String surname;

    public String toString() {
        StringBuilder string = new StringBuilder();
        if (null != surname) {
            string.append(surname).append(", ");
        }
        if (null != givenName) {
            string.append(givenName).append(" ");
        }
        if (null != middleName) {
            string.append(middleName);
        }
        return string.toString();
    }

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
