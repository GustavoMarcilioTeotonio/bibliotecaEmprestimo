package com.senai.bibliotecaemprestimo.services;

import com.senai.bibliotecaemprestimo.dtos.LivroDTO;
import com.senai.bibliotecaemprestimo.models.Livro;
import com.senai.bibliotecaemprestimo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroDTO salvarLivro(LivroDTO livroDTO) {
        Livro livro = converterLivroDTOParaLivro(livroDTO);
        livro = livroRepository.save(livro);
        return converterLivroParaLivroDTO(livro);
    }


    private Livro converterLivroDTOParaLivro (LivroDTO livroDTO) {
        Livro livro = new Livro(livroDTO);
        livro.setId(livroDTO.getId());
        livro.setNome(livroDTO.getNome());
        return livro;
    }


    public LivroDTO converterLivroParaLivroDTO(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        return livroDTO;
    }
    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Livro não encontrado"));
    }


    public LivroDTO atualizarLivro(LivroDTO livroDTO) {
        if (isNull(livroDTO.getId())) {
            throw new IllegalArgumentException("Livro não encontrado");
        }
        Livro livro = livroRepository.findById(livroDTO.getId()).orElseThrow(() ->new IllegalArgumentException("Livro não encontrado"));

        livro = converterLivroDTOParaLivro(livroDTO);
        livro = livroRepository.save(livro);

        return converterLivroParaLivroDTO(livro);
    }


    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
