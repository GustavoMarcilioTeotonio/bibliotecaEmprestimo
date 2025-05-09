package com.senai.bibliotecaemprestimo.services;

import com.senai.bibliotecaemprestimo.dtos.MultaDTO;
import com.senai.bibliotecaemprestimo.models.Multa;
import com.senai.bibliotecaemprestimo.repositories.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    public MultaDTO salvarMulta(MultaDTO multaDTO) {
        Multa multa = converterMultaDTOParaMulta(multaDTO);
        multa = multaRepository.save(multa);
        return converterMultaParaMultaDTO(multa);
    }


    private Multa converterMultaDTOParaMulta (MultaDTO multaDTO) {
        Multa multa = new Multa(multaDTO);
        multa.setId(multaDTO.getId());
        multa.setValor(multaDTO.getValor());
        multa.setDiasAtraso(multaDTO.getDiasAtraso());
        multa.setDataMulta(multaDTO.getDataMulta());
        multa.setPaga(multaDTO.getPaga());
        return multa;
    }


    public MultaDTO converterMultaParaMultaDTO(Multa multa) {
        MultaDTO multaDTO = new MultaDTO();
        multaDTO.setId(multa.getId());
        multaDTO.setValor(multa.getValor());
        multaDTO.setDiasAtraso(multa.getDiasAtraso());
        multaDTO.setDataMulta(multa.getDataMulta());
        multaDTO.setPaga(multa.getPaga());
        return multaDTO;
    }
    public Multa buscarMultaPorId(Long id) {
        return multaRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Multa não encontrado"));
    }


    public MultaDTO atualizarMulta(MultaDTO multaDTO) {
        if (isNull(multaDTO.getId())) {
            throw new IllegalArgumentException("Multa não encontrado");
        }
        Multa multa = multaRepository.findById(multaDTO.getId()).orElseThrow(() ->new IllegalArgumentException("Multa não encontrado"));

        multa = converterMultaDTOParaMulta(multaDTO);
        multa = multaRepository.save(multa);

        return converterMultaParaMultaDTO(multa);
    }


    public void deletarMulta(Long id) {
        multaRepository.deleteById(id);
    }
}
