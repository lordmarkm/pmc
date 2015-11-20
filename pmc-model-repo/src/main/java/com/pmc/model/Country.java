package com.pmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pmc.model.base.BaseEntity;

@Entity(name = "ref_country")
public class Country extends BaseEntity {

    @Column(name = "country_name")
    private String name;

    @Column(name = "country_code", updatable = false)
    private String code;

    @Column(name = "country_sequence")
    private long sequence;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
