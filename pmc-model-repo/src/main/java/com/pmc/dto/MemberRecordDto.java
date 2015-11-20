package com.pmc.dto;

import org.joda.time.DateTime;

import com.pmc.dto.base.BaseDto;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public class MemberRecordDto extends BaseDto {

    private NameDto name;
    private DateTime approvedDate;
    private DateTime expirationDate;
    private boolean approved;
    private boolean expired;
    private RegistrationTokenDto regToken;

    public NameDto getName() {
        return name;
    }
    public void setName(NameDto name) {
        this.name = name;
    }
    public DateTime getApprovedDate() {
        return approvedDate;
    }
    public void setApprovedDate(DateTime approvedDate) {
        this.approvedDate = approvedDate;
    }
    public DateTime getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public boolean isExpired() {
        return expired;
    }
    public void setExpired(boolean expired) {
        this.expired = expired;
    }
    public RegistrationTokenDto getRegToken() {
        return regToken;
    }
    public void setRegToken(RegistrationTokenDto regToken) {
        this.regToken = regToken;
    }
}
