/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Asistencia;
import com.upeu.demo.repository.AsistenciaRepository;
import com.upeu.demo.service.AsistenciaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
     
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Transactional
    @Override
    public List<Asistencia> findAll() {
        return (List<Asistencia>) asistenciaRepository.findAll();
    }

    @Override
    public Asistencia findById(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void delete(Asistencia asistencia) {
        asistenciaRepository.delete(asistencia);
    }

    @Override
    public void deleteById(Long id) {
        asistenciaRepository.deleteById(id);
    }
}
