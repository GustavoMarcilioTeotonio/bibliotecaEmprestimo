package com.senai.bibliotecaemprestimo.controllers;

import com.senai.bibliotecaemprestimo.dtos.MultaDTO;
import com.senai.bibliotecaemprestimo.models.Multa;
import com.senai.bibliotecaemprestimo.services.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/multas")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @GetMapping("/{id}")
    public ResponseEntity<MultaDTO> buscarMultaPorId(@PathVariable Long id) {
        Multa multa = multaService.buscarMultaPorId(id);
        return ResponseEntity.ok(multaService.converterMultaParaMultaDTO(multa));

    }

    @PostMapping()
    public ResponseEntity<MultaDTO> criarMulta(@RequestBody MultaDTO multaDTO) {
        multaDTO = multaService.salvarMulta(multaDTO);
        return ResponseEntity.ok(multaDTO);
    }

    @PutMapping()
    public ResponseEntity<MultaDTO> atualizarMulta(@RequestBody MultaDTO multaDTO) {
        multaDTO = multaService.atualizarMulta(multaDTO);
        return ResponseEntity.ok(multaDTO);

    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteMulta(@RequestBody MultaDTO multaDTO) {
        multaService.deletarMulta(multaDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
