package com.zetteln.backend.repository;

import com.zetteln.backend.entity.User;
import com.zetteln.backend.entity.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaultRepository extends JpaRepository<Vault, Long> {
    List<Vault> findByUser_Id(Long userId);

    Long user(User user);
}
