package com.pmc.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.pmc.model.base.BaseEntity;
import com.pmc.model.base.Name;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@Entity(name = "member_record")
public class MemberRecord extends BaseEntity {

    @Embedded
    private Name name;

    @OneToOne
    @JoinColumn(name = "reg_token_id", nullable = false)
    private RegistrationToken regToken;

    @Column(name = "approved_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime approvedDate;

    @Column(name = "expiration_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime expirationDate;

    @Transient
    private boolean approved;

    @Transient
    private boolean expired;

    @PostLoad
    private void onLoad() {
        approved = null != approvedDate;
        expired = null != expirationDate && expirationDate.isBefore(DateTime.now());
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
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

    public RegistrationToken getRegToken() {
        return regToken;
    }

    public void setRegToken(RegistrationToken regToken) {
        this.regToken = regToken;
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
}
