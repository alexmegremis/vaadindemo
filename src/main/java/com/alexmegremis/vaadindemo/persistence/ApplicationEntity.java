package com.alexmegremis.vaadindemo.persistence;

import javax.persistence.*;

@Entity
@Table (name = "APPLICATION", schema = "PUBLIC", catalog = "VAADINPOC")
public class ApplicationEntity {

    private Integer id;
    private String identifier;
    private String name;

    @Id
    @Column (name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Basic
    @Column (name = "NAME", nullable = false, length = 256)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Basic
    @Column (name = "IDENTIFIER", nullable = false, length = 256)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
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

        final ApplicationEntity that = (ApplicationEntity) o;

        if (id != null ? ! id.equals(that.id) : that.id != null) {
            return false;
        }
        if (name != null ? ! name.equals(that.name) : that.name != null) {
            return false;
        }
        if (identifier != null ? ! identifier.equals(that.identifier) : that.identifier != null) {
            return false;
        }

        return true;
    }
}
