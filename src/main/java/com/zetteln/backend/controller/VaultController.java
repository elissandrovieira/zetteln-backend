package com.zetteln.backend.controller;

import com.zetteln.backend.entity.Vault;
import com.zetteln.backend.service.VaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
