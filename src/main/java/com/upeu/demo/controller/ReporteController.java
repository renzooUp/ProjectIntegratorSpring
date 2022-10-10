/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Reporte;
import com.upeu.demo.service.ReporteService;
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
@RequestMapping("/reporte")
@Api(value = "Microservicios de gestion de reporte", description ="Microservicio de reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @ApiOperation(value="Lista de reporte")
    @GetMapping("/all")
    public List<Reporte> findAll() {
        return reporteService.findAll();
    }

    @ApiOperation(value="Obtiene datos de reporte")
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> findById(@PathVariable Long id) {
        Reporte reporte = reporteService.findById(id);
        return ResponseEntity.ok(reporte);
    }

    @ApiOperation(value="Elimina un reporte")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reporteService.deleteById(id);
    }

    @ApiOperation(value="Crea un reporte")
    @PostMapping("/save")
    public Reporte save(@RequestBody Reporte reporte) {
        return reporteService.save(reporte);
    }

    @ApiOperation(value="Modifica un reporte")
    @PutMapping("/update")
    public Reporte update(@RequestBody Reporte reporte) {
        return reporteService.save(reporte);
    }
}
