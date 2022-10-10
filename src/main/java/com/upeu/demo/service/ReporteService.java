/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Reporte;
import java.util.List;

public interface ReporteService {

    public List<Reporte> findAll();

    public Reporte findById(Long id);

    public Reporte save(Reporte reporte);

    public void delete(Reporte reporte);

    public void deleteById(Long id);
}
