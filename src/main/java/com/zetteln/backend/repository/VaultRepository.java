package com.zetteln.backend.repository;

import com.zetteln.backend.entity.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaultRepository extends JpaRepository<Vault, Long> {
}
