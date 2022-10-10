/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Asistencia;
import com.upeu.demo.service.AsistenciaService;
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
@RequestMapping("/asistencia")
@Api(value = "Microservicios de gestion de asistencia", description ="Microservicio de asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @ApiOperation(value="Lista de asistencia")
    @GetMapping("/all")
    public List<Asistencia> findAll() {
        return asistenciaService.findAll();
    }

    @ApiOperation(value="Obtiene datos de la asistencia")
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> findById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        return ResponseEntity.ok(asistencia);
    }

    @ApiOperation(value="Elimina una asistencia")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        asistenciaService.deleteById(id);
    }

    @ApiOperation(value="Crea una asistencia")
    @PostMapping("/save")
    public Asistencia save(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }

    @ApiOperation(value="Modifica una asistencia")
    @PutMapping("/update")
    public Asistencia update(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }
}
