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

    public List<Vault> GetAll() {
        return vaultRepository.findAll();
    }

    public List<Vault> GetByUserId(Long userId) {
        return vaultRepository.findByUser_Id(userId);
    }

    public Vault CreateVault(Vault vault) {
        return vaultRepository.save(vault);
    }

    public Vault UpdateVault(Long id, Vault vault) {
        if (vaultRepository.existsById(id)) {
            vault.setId(id);
            return vaultRepository.save(vault);
        }
        return null;
    }

    public void DeleteVault(Long id) {
        vaultRepository.deleteById(id);
    }


}
