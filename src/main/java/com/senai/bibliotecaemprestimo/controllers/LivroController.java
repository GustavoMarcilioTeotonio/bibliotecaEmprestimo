package com.senai.bibliotecaemprestimo.controllers;

import com.senai.bibliotecaemprestimo.dtos.LivroDTO;
import com.senai.bibliotecaemprestimo.models.Livro;
import com.senai.bibliotecaemprestimo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livroService.converterLivroParaLivroDTO(livro));

    }

    @PostMapping()
    public ResponseEntity<LivroDTO> criarLivro(@RequestBody LivroDTO livroDTO) {
        livroDTO = livroService.salvarLivro(livroDTO);
        return ResponseEntity.ok(livroDTO);
    }

    @PutMapping()
    public ResponseEntity<LivroDTO> atualizarLivro(@RequestBody LivroDTO livroDTO) {
        livroDTO = livroService.atualizarLivro(livroDTO);
        return ResponseEntity.ok(livroDTO);

    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteLivro(@RequestBody LivroDTO livroDTO) {
        livroService.deletarLivro(livroDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
