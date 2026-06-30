package com.ucr.smas.service;

import com.ucr.smas.model.Padecimiento;
import com.ucr.smas.repository.PadecimientoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PadecimientoService {

    @Autowired
    private PadecimientoJpaRepository repository;

    public List<Padecimiento> findAll() {
        return repository.findAll();
    }

    public Padecimiento getById(Integer id) {
        return repository.getById(id);
    }

    public Padecimiento add(Padecimiento padecimiento) {

        Padecimiento existe = repository.getByNombre(padecimiento.getNombre());

        if (existe != null) {
            return null;
        }

        return repository.save(padecimiento);
    }

    public Padecimiento update(Padecimiento padecimiento) {

        Padecimiento existe = repository.getById(padecimiento.getId());

        if (existe == null) {
            return null;
        }

        existe.setNombre(padecimiento.getNombre());
        existe.setDescripcion(padecimiento.getDescripcion());

        return repository.save(existe);
    }

    public Padecimiento delete(Integer id) {

        Optional<Padecimiento> existe = repository.findById(id);

        if (existe.isPresent()) {
            repository.deleteById(id);
            return existe.get();
        }

        return null;
    }
}//finservice