package com.lx.parkms.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Proxy(lazy = false)
public class Permission {

    @Id
    private Integer permissionId;

    private Integer permissionType;

    private String permissionName;
}
