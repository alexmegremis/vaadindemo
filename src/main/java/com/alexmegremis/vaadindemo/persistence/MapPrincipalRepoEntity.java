package com.alexmegremis.vaadindemo.persistence;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "MAP_PRINCIPAL_REPO")
@Data
public class MapPrincipalRepoEntity {

    @Basic
    @Column (name = "DATETIME_CREATED", nullable = false)
    private Timestamp datetimeCreated;
    @Basic
    @Column (name = "DATETIME_SUPERSEDED", nullable = true)
    private Timestamp datetimeSuperseded;
    @Id
    @Column (name = "ID", nullable = false)
    private Integer   id;
    @Basic
    @Column (name = "PERMISSION", nullable = false, length = 256)
    private String    permission;
    @Basic
    @Column (name = "PERMISSION_BITS", nullable = false)
    private Integer   permissionBits;

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (permissionBits != null ? permissionBits.hashCode() : 0);
        result = 31 * result + (datetimeCreated != null ? datetimeCreated.hashCode() : 0);
        result = 31 * result + (datetimeSuperseded != null ? datetimeSuperseded.hashCode() : 0);
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

        final MapPrincipalRepoEntity that = (MapPrincipalRepoEntity) o;

        if (id != null ? ! id.equals(that.id) : that.id != null) {
            return false;
        }
        if (permission != null ? ! permission.equals(that.permission) : that.permission != null) {
            return false;
        }
        if (permissionBits != null ? ! permissionBits.equals(that.permissionBits) : that.permissionBits != null) {
            return false;
        }
        if (datetimeCreated != null ? ! datetimeCreated.equals(that.datetimeCreated) : that.datetimeCreated != null) {
            return false;
        }
        if (datetimeSuperseded != null ? ! datetimeSuperseded.equals(that.datetimeSuperseded) : that.datetimeSuperseded != null) {
            return false;
        }

        return true;
    }
}
