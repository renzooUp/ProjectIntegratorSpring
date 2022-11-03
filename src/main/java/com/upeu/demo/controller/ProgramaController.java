/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Programa;
import com.upeu.demo.service.ProgramaService;
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
@RequestMapping("/api/programa")
@Api(value = "Microservicios de gestion de programa", description ="Microservicio de programa")
public class ProgramaController {
    
    @Autowired
    private ProgramaService programaService;

    @ApiOperation(value="Lista de programa")
    @GetMapping("/all")
    public List<Programa> findAll() {
        return programaService.findAll();
    }

    @ApiOperation(value="Obtiene datos de programa")
    @GetMapping("/{id}")
    public ResponseEntity<Programa> findById(@PathVariable Long id) {
        Programa programa = programaService.findById(id);
        return ResponseEntity.ok(programa);
    }

    @ApiOperation(value="Elimina un programa")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        programaService.deleteById(id);
    }

    @ApiOperation(value="Crea un programa")
    @PostMapping("/save")
    public Programa save(@RequestBody Programa programa) {
        return programaService.save(programa);
    }

    @ApiOperation(value="Modifica un programa")
    @PutMapping("/update")
    public Programa update(@RequestBody Programa programa) {
        return programaService.save(programa);
    }
}
