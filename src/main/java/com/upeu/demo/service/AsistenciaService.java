/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Asistencia;
import java.util.List;

public interface AsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia findById(Long id);

    public Asistencia save(Asistencia asistencia);

    public void delete(Asistencia asistencia);

    public void deleteById(Long id);
}
