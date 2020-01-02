package com.evrenvural.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Date;

@Data // Getter and Setter
@MappedSuperclass // Entity classlarda extend edilebilir hale getirir.
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP) // Zamanı milisaniye olarak tutar
    private Date createdAt;

    @Column(name="created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP) // Zamanı milisaniye olarak tutar
    private Date updatedAt;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;
}
