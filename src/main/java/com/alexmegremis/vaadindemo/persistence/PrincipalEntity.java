package com.alexmegremis.vaadindemo.persistence;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "PRINCIPAL")
public class PrincipalEntity {

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
    @Column (name = "NAME", nullable = false, length = 256)
    private String    name;

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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

        final PrincipalEntity that = (PrincipalEntity) o;

        if (id != null ? ! id.equals(that.id) : that.id != null) {
            return false;
        }
        if (name != null ? ! name.equals(that.name) : that.name != null) {
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
