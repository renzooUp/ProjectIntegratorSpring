/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Carrera;
import com.upeu.demo.service.CarreraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrera")
@Api(value = "Microservicios de gestion de carreras", description ="Microservicio de carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @ApiOperation(value="Lista de carrera")
    @GetMapping("/all")
    public List<Carrera> findAll() {
        return carreraService.findAll();
    }

    @ApiOperation(value="Obtiene datos de la carrera")
    @GetMapping("/{id}")
    public ResponseEntity<Carrera> findById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        return ResponseEntity.ok(carrera);
    }

    @ApiOperation(value="Elimina una carrera")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        carreraService.deleteById(id);
    }

    @ApiOperation(value="Crea una carrera")
    @PostMapping("/save")
    public Carrera save(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @ApiOperation(value="Modifica una carrera")
    @PutMapping("/update")
    public Carrera update(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }
}
