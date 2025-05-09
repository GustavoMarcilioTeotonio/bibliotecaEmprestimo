package com.senai.bibliotecaemprestimo.services;

import com.senai.bibliotecaemprestimo.dtos.AdminDTO;
import com.senai.bibliotecaemprestimo.models.Admin;
import com.senai.bibliotecaemprestimo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminDTO salvarAdmin(AdminDTO adminDTO) {
        Admin admin = converterAdminDTOParaAdmin(adminDTO);
        admin = adminRepository.save(admin);
        return converterAdminParaAdminDTO(admin);
    }


    private Admin converterAdminDTOParaAdmin (AdminDTO adminDTO) {
        Admin admin = new Admin(adminDTO);
        admin.setId(adminDTO.getId());
        admin.setUsuario(adminDTO.getUsuario());
        admin.setSenha(adminDTO.getSenha());
        return admin;
    }


    public AdminDTO converterAdminParaAdminDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsuario(admin.getUsuario());
        adminDTO.setSenha(admin.getSenha());
        return adminDTO;
    }
    public Admin buscarAdminPorId(Long id) {
        return adminRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Admin não encontrado"));
    }


    public AdminDTO atualizarAdmin(AdminDTO adminDTO) {
        if (isNull(adminDTO.getId())) {
            throw new IllegalArgumentException("Admin não encontrado");
        }
        Admin admin = adminRepository.findById(adminDTO.getId()).orElseThrow(() ->new IllegalArgumentException("Admin não encontrado"));

        admin = converterAdminDTOParaAdmin(adminDTO);
        admin = adminRepository.save(admin);

        return converterAdminParaAdminDTO(admin);
    }


    public void deletarAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
