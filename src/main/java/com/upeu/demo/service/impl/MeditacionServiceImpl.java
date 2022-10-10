/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.service.impl;

import com.upeu.demo.entity.Meditacion;
import com.upeu.demo.repository.MeditacionRepository;
import com.upeu.demo.service.MeditacionService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeditacionServiceImpl implements MeditacionService{

    @Autowired
    private MeditacionRepository meditacionRepository;

    @Transactional
    @Override
    public List<Meditacion> findAll() {
        return (List<Meditacion>) meditacionRepository.findAll();
    }

    @Override
    public Meditacion findById(Long id) {
        return meditacionRepository.findById(id).orElse(null);
    }

    @Override
    public Meditacion save(Meditacion meditacion) {
        return meditacionRepository.save(meditacion);
    }

    @Override
    public void delete(Meditacion meditacion) {
        meditacionRepository.delete(meditacion);
    }

    @Override
    public void deleteById(Long id) {
        meditacionRepository.deleteById(id);
    }
}
