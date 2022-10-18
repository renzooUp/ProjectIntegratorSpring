package com.upeu.demo.service;

import com.upeu.demo.entity.Carrera;
import java.util.List;

public interface CarreraService {

    public List<Carrera> findAll();

    public Carrera findById(Long id);

    public Carrera save(Carrera carrera);

    public void delete(Carrera carrera);

    public void deleteById(Long id);
}
