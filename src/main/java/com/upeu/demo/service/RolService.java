/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.demo.service;

import com.upeu.demo.entity.Rol;
import java.util.List;

/**
 *
 * @author Renzo Renato
 */
public interface RolService {

    public List<Rol> findAll();

    public Rol findById(Long id);

    public Rol save(Rol rol);

    public void delete(Rol rol);

    public void deleteById(Long id);
}
