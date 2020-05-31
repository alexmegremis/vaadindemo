package com.alexmegremis.vaadindemo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionsRepo extends JpaRepository<ViewPermissionsEntity, PermissionsID> {
    List<ViewPermissionsEntity> findByNameLastStartsWithIgnoreCase(final String nameLast);
    List<ViewPermissionsEntity> findByNameFirstStartsWithIgnoreCase(final String nameFirst);
}
