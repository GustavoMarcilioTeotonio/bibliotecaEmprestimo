package com.senai.bibliotecaemprestimo.repositories;

import com.senai.bibliotecaemprestimo.models.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository <Estudante, Long> {
    Optional<Estudante> findById(int id);
}
