package com.alexmegremis.vaadindemo.persistence;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionsID implements Serializable {
//    @Basic
//    @Column (name = "ID_PERSON", nullable = true)
    private Integer idPerson;
//    @Basic
//    @Column (name = "ID_PRINCIPAL", nullable = true)
    private Integer idPrincipal;
//    @Basic
//    @Column (name = "ID_REPO", nullable = true)
    private Integer idRepo;
}
