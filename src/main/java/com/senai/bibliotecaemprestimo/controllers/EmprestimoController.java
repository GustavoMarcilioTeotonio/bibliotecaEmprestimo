package com.senai.bibliotecaemprestimo.controllers;

import com.senai.bibliotecaemprestimo.dtos.EmprestimoDTO;
import com.senai.bibliotecaemprestimo.models.Emprestimo;
import com.senai.bibliotecaemprestimo.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> buscarEmprestimoPorId(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.buscarEmprestimoPorId(id);
        return ResponseEntity.ok(emprestimoService.converterEmprestimoParaEmprestimoDTO(emprestimo));

    }

    @PostMapping()
    public ResponseEntity<EmprestimoDTO> criarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        emprestimoDTO = emprestimoService.salvarEmprestimo(emprestimoDTO);
        return ResponseEntity.ok(emprestimoDTO);
    }

    @PutMapping()
    public ResponseEntity<EmprestimoDTO> atualizarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        emprestimoDTO = emprestimoService.atualizarEmprestimo(emprestimoDTO);
        return ResponseEntity.ok(emprestimoDTO);

    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        emprestimoService.deletarEmprestimo(emprestimoDTO.getId());
        return ResponseEntity.noContent().build();
    }


}
