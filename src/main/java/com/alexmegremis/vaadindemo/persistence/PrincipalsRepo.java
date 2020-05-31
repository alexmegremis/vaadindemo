package com.alexmegremis.vaadindemo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrincipalsRepo extends JpaRepository<ViewPrincipalEntity, Integer> {}
