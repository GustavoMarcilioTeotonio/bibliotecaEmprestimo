package com.senai.bibliotecaemprestimo.controllers;

import com.senai.bibliotecaemprestimo.dtos.EstudanteDTO;
import com.senai.bibliotecaemprestimo.models.Estudante;
import com.senai.bibliotecaemprestimo.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/estudantes")

public class EtudanteController {


    @Autowired
    private EstudanteService estudanteService;

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteDTO> buscarEstudantePorId(@PathVariable Long id) {
        System.out.println("Buscando estudante com ID: " + id);
        Estudante estudante = estudanteService.buscarEstudantePorId(id);
        return ResponseEntity.ok(estudanteService.converterEstudanteParaEstudanteDTO(estudante));

    }

    @PostMapping()
    public ResponseEntity<EstudanteDTO> criarEstudante(@RequestBody EstudanteDTO estudanteDTO) {
        estudanteDTO = estudanteService.salvarEstudante(estudanteDTO);
        return ResponseEntity.ok(estudanteDTO);
    }

    @PutMapping()
    public ResponseEntity<EstudanteDTO> atualizarEstudante(@RequestBody EstudanteDTO estudanteDTO) {
        estudanteDTO = estudanteService.atualizarEstudante(estudanteDTO);
        return ResponseEntity.ok(estudanteDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Estudante> getAllCategories() {
        return estudanteService.buscarTodosEstudantes();
    }

}
