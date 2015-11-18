package com.pmc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

/**
 * @author markm
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(name = "created")
    protected DateTime dateCreated;

    @Column(name = "updated")
    protected DateTime dateUpdated;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "updated_by")
    protected String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public DateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
