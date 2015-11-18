package com.pmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author markm
 */
@Entity(name = "reg_token")
public class RegistrationToken extends BaseEntity {

    @Column(name = "token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
