package com.senai.bibliotecaemprestimo.services;

import com.senai.bibliotecaemprestimo.dtos.EmprestimoDTO;
import com.senai.bibliotecaemprestimo.models.Emprestimo;
import com.senai.bibliotecaemprestimo.models.Multa;
import com.senai.bibliotecaemprestimo.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.isNull;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoDTO salvarEmprestimo(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = converterEmprestimoDTOParaEmprestimo(emprestimoDTO);
        emprestimo = emprestimoRepository.save(emprestimo);
        return converterEmprestimoParaEmprestimoDTO(emprestimo);
    }


    private Emprestimo converterEmprestimoDTOParaEmprestimo (EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = new Emprestimo(emprestimoDTO);
        emprestimo.setId(emprestimoDTO.getId());
        emprestimo.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
        emprestimo.setDataDevolucao(emprestimoDTO.getDataDevolucao());
        emprestimo.setLivro(emprestimoDTO.getLivro());
        emprestimo.setEstudante(emprestimoDTO.getEstudante());
        return emprestimo;
    }


    public EmprestimoDTO converterEmprestimoParaEmprestimoDTO(Emprestimo emprestimo) {
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setId(emprestimo.getId());
        emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
        emprestimoDTO.setDataDevolucao(emprestimo.getDataDevolucao());
        emprestimoDTO.setLivro(emprestimo.getLivro());
        emprestimoDTO.setEstudante(emprestimo.getEstudante());
        return emprestimoDTO;
    }
    public Emprestimo buscarEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Emprestimo não encontrado"));
    }


    public EmprestimoDTO atualizarEmprestimo(EmprestimoDTO emprestimoDTO) {
        if (isNull(emprestimoDTO.getId())) {
            throw new IllegalArgumentException("Emprestimo não encontrado");
        }
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoDTO.getId()).orElseThrow(() ->new IllegalArgumentException("Emprestimo não encontrado"));

        emprestimo = converterEmprestimoDTOParaEmprestimo(emprestimoDTO);
        emprestimo = emprestimoRepository.save(emprestimo);

        return converterEmprestimoParaEmprestimoDTO(emprestimo);
    }


    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }

    public

}
