/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Reporte;
import com.upeu.demo.repository.ReporteRepository;
import com.upeu.demo.service.ReporteService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService{

    @Autowired
    private ReporteRepository reporteRepository;

    @Transactional
    @Override
    public List<Reporte> findAll() {
        return (List<Reporte>) reporteRepository.findAll();
    }

    @Override
    public Reporte findById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    @Override
    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @Override
    public void delete(Reporte reporte) {
        reporteRepository.delete(reporte);
    }

    @Override
    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }
}
