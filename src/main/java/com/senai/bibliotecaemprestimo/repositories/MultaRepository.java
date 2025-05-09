package com.senai.bibliotecaemprestimo.repositories;

import com.senai.bibliotecaemprestimo.models.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
    Optional<Multa> findById(int id);
}

