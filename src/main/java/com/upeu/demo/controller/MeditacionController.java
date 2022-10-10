/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Meditacion;
import com.upeu.demo.service.MeditacionService;
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
@RequestMapping("/meditacion")
@Api(value = "Microservicios de gestion de meditacion", description ="Microservicio de meditacion")
public class MeditacionController {

    @Autowired
    private MeditacionService meditacionService;

    @ApiOperation(value="Lista de meditacion")
    @GetMapping("/all")
    public List<Meditacion> findAll() {
        return meditacionService.findAll();
    }

    @ApiOperation(value="Obtiene datos de la meditacion")
    @GetMapping("/{id}")
    public ResponseEntity<Meditacion> findById(@PathVariable Long id) {
        Meditacion meditacion = meditacionService.findById(id);
        return ResponseEntity.ok(meditacion);
    }

    @ApiOperation(value="Elimina una meditacion")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        meditacionService.deleteById(id);
    }

    @ApiOperation(value="Crea una meditacion")
    @PostMapping("/save")
    public Meditacion save(@RequestBody Meditacion meditacion) {
        return meditacionService.save(meditacion);
    }

    @ApiOperation(value="Modifica una meditación")
    @PutMapping("/update")
    public Meditacion update(@RequestBody Meditacion meditacion) {
        return meditacionService.save(meditacion);
    }
}
