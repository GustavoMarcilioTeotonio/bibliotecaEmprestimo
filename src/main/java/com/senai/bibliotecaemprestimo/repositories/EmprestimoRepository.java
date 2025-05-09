package com.senai.bibliotecaemprestimo.repositories;

import com.senai.bibliotecaemprestimo.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Optional<Emprestimo> findById(int id);
}

