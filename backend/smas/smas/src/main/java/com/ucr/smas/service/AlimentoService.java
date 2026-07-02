package com.ucr.smas.service;

import com.ucr.smas.model.Alimento;
import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.model.dto.AlimentoRequestDTO;
import com.ucr.smas.repository.AlimentoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoJpaRepository repository;

    @Autowired
    private PadecimientoService padecimientoService;

    public List<Alimento> findAll() {
        return repository.findAll();
    }

    public Alimento getById(Integer id) {
        Optional<Alimento> alimento = repository.findById(id);
        return alimento.orElse(null);
    }

    public List<Alimento> getByPadecimiento(Integer padecimientoId) {
        return repository.findByPadecimiento_Id(padecimientoId);
    }

    public Alimento add(AlimentoRequestDTO alimentoRequest) {
        Padecimiento padecimiento = padecimientoService.getById(alimentoRequest.getPadecimientoId());
        if (padecimiento == null) {
            return null;
        }

        Alimento alimento = new Alimento();
        alimento.setPadecimiento(padecimiento);
        alimento.setFood(alimentoRequest.getFood());
        alimento.setDescription(alimentoRequest.getDescription());
        alimento.setNivelRecomendacion(alimentoRequest.getNivelRecomendacion());

        return repository.save(alimento);
    }

    public Alimento update(Integer id, AlimentoRequestDTO dto) {
        Optional<Alimento> existe = repository.findById(id);
        if (existe.isEmpty()) {
            return null;
        }

        Alimento alimento = existe.get();

        if (dto.getFood() != null && !dto.getFood().isEmpty()) {
            alimento.setFood(dto.getFood());
        }
        if (dto.getDescription() != null && !dto.getDescription().isEmpty()) {
            alimento.setDescription(dto.getDescription());
        }
        if (dto.getNivelRecomendacion() != null) {
            alimento.setNivelRecomendacion(dto.getNivelRecomendacion());
        }
        if (dto.getPadecimientoId() != null) {
            Padecimiento padecimiento = padecimientoService.getById(dto.getPadecimientoId());
            if (padecimiento != null) {
                alimento.setPadecimiento(padecimiento);
            }
        }

        return repository.save(alimento);
    }

    public Alimento delete(Integer id) {
        Optional<Alimento> existe = repository.findById(id);
        if (existe.isPresent()) {
            repository.deleteById(id);
            return existe.get();
        }
        return null;
    }
}
