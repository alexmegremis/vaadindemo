package com.alexmegremis.vaadindemo.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "PERSON")
@Data
public class PersonEntity {

    @Id
    @Column (name = "ID", nullable = false)
    private Integer id;
    @Basic
    @Column (name = "NAME_FIRST", nullable = false, length = 20)
    private String nameFirst;
    @Basic
    @Column (name = "NAME_LAST", nullable = false, length = 20)
    private String nameLast;

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameFirst != null ? nameFirst.hashCode() : 0);
        result = 31 * result + (nameLast != null ? nameLast.hashCode() : 0);
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

        final PersonEntity that = (PersonEntity) o;

        if (id != null ? ! id.equals(that.id) : that.id != null) {
            return false;
        }
        if (nameFirst != null ? ! nameFirst.equals(that.nameFirst) : that.nameFirst != null) {
            return false;
        }
        if (nameLast != null ? ! nameLast.equals(that.nameLast) : that.nameLast != null) {
            return false;
        }

        return true;
    }
}
