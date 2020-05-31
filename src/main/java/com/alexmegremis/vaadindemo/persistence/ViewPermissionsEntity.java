package com.alexmegremis.vaadindemo.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "VIEW_PERMISSIONS")
@Data
@IdClass(PermissionsID.class)
public class ViewPermissionsEntity {

    @Id
    @Column (name = "ID_PERSON", nullable = true)
    private Integer idPerson;
    @Id
    @Column (name = "ID_PRINCIPAL", nullable = true)
    private Integer idPrincipal;
    @Id
    @Column (name = "ID_REPO", nullable = true)
    private Integer idRepo;

    @Basic
    @Column (name = "NAME_FIRST", nullable = true, length = 20)
    private String nameFirst;
    @Basic
    @Column (name = "NAME_LAST", nullable = true, length = 20)
    private String nameLast;
    @Basic
    @Column (name = "PERMISSION", nullable = true, length = 256)
    private String permission;
    @Basic
    @Column (name = "PERMISSION_BITS", nullable = true)
    private Integer permissionBits;
    @Basic
    @Column (name = "PRINCIPAL", nullable = true, length = 256)
    private String principal;
    @Basic
    @Column (name = "REPO", nullable = true, length = 256)
    private String repo;
}
