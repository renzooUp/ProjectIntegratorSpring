/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.TipoPersona;
import com.upeu.demo.service.TipoPersonaService;
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
@RequestMapping("/api/tipo-persona")
@Api(value = "Microservicios de gestion de tipo persona", description ="Microservicio de tipo persona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaService tipoPersonaService;

    @ApiOperation(value="Lista de tipo persona")
    @GetMapping("/all")
    public List<TipoPersona> findAll() {
        return tipoPersonaService.findAll();
    }

    @ApiOperation(value="Obtiene datos de tipo persona")
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> findById(@PathVariable Long id) {
        TipoPersona tipoPersona = tipoPersonaService.findById(id);
        return ResponseEntity.ok(tipoPersona);
    }

    @ApiOperation(value="Elimina un tipo persona")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tipoPersonaService.deleteById(id);
    }

    @ApiOperation(value="Crea un tipo persona")
    @PostMapping("/save")
    public TipoPersona save(@RequestBody TipoPersona tipoPersona) {
        return tipoPersonaService.save(tipoPersona);
    }

    @ApiOperation(value="Modifica un tipo persona")
    @PutMapping("/update")
    public TipoPersona update(@RequestBody TipoPersona tipoPersona) {
        return tipoPersonaService.save(tipoPersona);
    }
}
