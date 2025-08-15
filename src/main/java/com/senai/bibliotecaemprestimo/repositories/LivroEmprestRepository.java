package com.senai.bibliotecaemprestimo.repositories;

import com.senai.bibliotecaemprestimo.models.LivroEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroEmprestRepository extends JpaRepository <LivroEmprestimo, Long> {
    Optional<LivroEmprestimo> findById(Long id);

}
