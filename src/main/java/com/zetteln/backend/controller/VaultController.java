package com.zetteln.backend.controller;

import com.zetteln.backend.entity.Vault;
import com.zetteln.backend.service.VaultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaults")
public class VaultController {

    private VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @GetMapping
    public List<Vault> GetAll() {
        return vaultService.GetAll();
    }

    @GetMapping("/{userId}")
    public List<Vault> GetByUserId(@PathVariable Long userId) {
        return vaultService.GetByUserId(userId);
    }

    @PostMapping
    public Vault CreateVault(@RequestBody Vault vault) {
        return vaultService.CreateVault(vault);
    }

    @PutMapping("/{id}")
    public Vault UpdateVault(@PathVariable Long id, @RequestBody Vault vault) {
        return vaultService.UpdateVault(id, vault);
    }

    @DeleteMapping("/{id}")
    public String DeleteVault(@PathVariable Long id) {
        vaultService.DeleteVault(id);
        return "Vault deleted";
    }

}
