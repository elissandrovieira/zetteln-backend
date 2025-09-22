package com.zetteln.backend.repository;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.entity.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByVault_User_Id(Long userId);
    List<Note> findByVault_User_IdAndVault_Id(Long userId, Long vaultId);

    Long vault(Vault vault);
}
