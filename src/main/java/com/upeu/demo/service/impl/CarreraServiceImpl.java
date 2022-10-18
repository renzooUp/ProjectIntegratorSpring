
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Carrera;
import com.upeu.demo.repository.CarreraRepository;
import com.upeu.demo.service.CarreraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional
    @Override
    public List<Carrera> findAll() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    @Override
    public Carrera findById(Long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    @Override
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public void delete(Carrera carrera) {
        carreraRepository.delete(carrera);
    }

    @Override
    public void deleteById(Long id) {
        carreraRepository.deleteById(id);
    }
}
