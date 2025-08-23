package com.senai.bibliotecaemprestimo.repositories;

import com.senai.bibliotecaemprestimo.models.Estudante;
import com.senai.bibliotecaemprestimo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findById(Long id);
}

