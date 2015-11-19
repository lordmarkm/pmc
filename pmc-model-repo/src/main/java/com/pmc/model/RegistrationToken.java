package com.pmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.pmc.model.base.BaseEntity;

/**
 * @author markm
 */
@Entity(name = "reg_token")
public class RegistrationToken extends BaseEntity {

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "token_series", nullable = false)
    private String tokenSeries;

    @OneToOne
    @JoinColumn(name = "member_record_id")
    private MemberRecord memberRecord;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public void setMemberRecord(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }

    public String getTokenSeries() {
        return tokenSeries;
    }

    public void setTokenSeries(String tokenSeries) {
        this.tokenSeries = tokenSeries;
    }

}
