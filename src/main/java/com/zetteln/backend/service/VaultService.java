package com.zetteln.backend.service;

import com.zetteln.backend.entity.Vault;
import com.zetteln.backend.repository.VaultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaultService {

    private VaultRepository vaultRepository;

    public VaultService(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }

    public List<Vault> GetVault () { return vaultRepository.findAll(); }
}
