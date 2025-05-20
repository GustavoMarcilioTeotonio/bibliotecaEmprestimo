package com.senai.bibliotecaemprestimo.controllers;

import com.senai.bibliotecaemprestimo.dtos.AdminDTO;
import com.senai.bibliotecaemprestimo.models.Admin;
import com.senai.bibliotecaemprestimo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> buscarAdminPorId(@PathVariable Long id) {
        Admin admin = adminService.buscarAdminPorId(id);
        return ResponseEntity.ok(adminService.converterAdminParaAdminDTO(admin));

    }

    @PostMapping()
    public ResponseEntity<AdminDTO> criarAdmin(@RequestBody AdminDTO adminDTO) {
        adminDTO = adminService.salvarAdmin(adminDTO);
        return ResponseEntity.ok(adminDTO);
    }

    @PutMapping()
    public ResponseEntity<AdminDTO> atualizarAdmin(@RequestBody AdminDTO adminDTO) {
        adminDTO = adminService.atualizarAdmin(adminDTO);
        return ResponseEntity.ok(adminDTO);

    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.deletarAdmin(adminDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
