package com.alexmegremis.vaadindemo.persistence;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "VIEW_PRINCIPAL")
@Data
public class ViewPrincipalEntity implements Serializable {

    @Basic
    @Column (name = "ID_PERSON", nullable = true)
    private Integer idPerson;
    @Id
    @Column (name = "ID_PRINCIPAL", nullable = true)
    private Integer idPrincipal;
    @Basic
    @Column (name = "NAME_FIRST", nullable = true, length = 20)
    private String nameFirst;
    @Basic
    @Column (name = "NAME_LAST", nullable = true, length = 20)
    private String nameLast;
    @Basic
    @Column (name = "PRINCIPAL", nullable = true, length = 256)
    private String principal;

    @Override
    public int hashCode() {
        int result = idPerson != null ? idPerson.hashCode() : 0;
        result = 31 * result + (nameLast != null ? nameLast.hashCode() : 0);
        result = 31 * result + (nameFirst != null ? nameFirst.hashCode() : 0);
        result = 31 * result + (idPrincipal != null ? idPrincipal.hashCode() : 0);
        result = 31 * result + (principal != null ? principal.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ViewPrincipalEntity that = (ViewPrincipalEntity) o;

        if (idPerson != null ? ! idPerson.equals(that.idPerson) : that.idPerson != null) {
            return false;
        }
        if (nameLast != null ? ! nameLast.equals(that.nameLast) : that.nameLast != null) {
            return false;
        }
        if (nameFirst != null ? ! nameFirst.equals(that.nameFirst) : that.nameFirst != null) {
            return false;
        }
        if (idPrincipal != null ? ! idPrincipal.equals(that.idPrincipal) : that.idPrincipal != null) {
            return false;
        }
        if (principal != null ? ! principal.equals(that.principal) : that.principal != null) {
            return false;
        }

        return true;
    }
}
