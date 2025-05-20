package com.senai.bibliotecaemprestimo.services;

import com.senai.bibliotecaemprestimo.dtos.EstudanteDTO;
import com.senai.bibliotecaemprestimo.models.Estudante;
import com.senai.bibliotecaemprestimo.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteDTO salvarEstudante(EstudanteDTO estudanteDTO) {
        Estudante estudante = converterEstudanteDTOParaEstudante(estudanteDTO);
        estudante = estudanteRepository.save(estudante);
        return converterEstudanteParaEstudanteDTO(estudante);
    }


    private Estudante converterEstudanteDTOParaEstudante (EstudanteDTO estudanteDTO) {
        Estudante estudante = new Estudante(estudanteDTO);
        estudante.setId(estudanteDTO.getId());
        estudante.setNome(estudanteDTO.getNome());
        estudante.setMatricula(estudanteDTO.getMatricula());
        estudante.setNumero(estudanteDTO.getNumero());
        return estudante;
    }


    public EstudanteDTO converterEstudanteParaEstudanteDTO(Estudante estudante) {
        EstudanteDTO estudanteDTO = new EstudanteDTO();
        estudanteDTO.setId(estudante.getId());
        estudanteDTO.setNome(estudante.getNome());
        estudanteDTO.setMatricula(estudante.getMatricula());
        estudanteDTO.setNumero(estudante.getNumero());
        return estudanteDTO;
    }
    public Estudante buscarEstudantePorId(Long id) {
        return estudanteRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Estudante não encontrado"));
    }

    public List<Estudante> buscarTodosEstudantes() {
        return estudanteRepository.findAll();
    }


    public EstudanteDTO atualizarEstudante(EstudanteDTO estudanteDTO) {
        if (isNull(estudanteDTO.getId())) {
            throw new IllegalArgumentException("Estudante não encontrado");
        }
        Estudante estudante = estudanteRepository.findById(estudanteDTO.getId()).orElseThrow(() ->new IllegalArgumentException("Estudante não encontrado"));

        estudante = converterEstudanteDTOParaEstudante(estudanteDTO);
        estudante = estudanteRepository.save(estudante);

        return converterEstudanteParaEstudanteDTO(estudante);
    }


    public void deletarEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }
}
