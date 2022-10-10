/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Material;
import com.upeu.demo.service.MaterialService;
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
@RequestMapping("/material")
@Api(value = "Microservicios de gestion de material", description ="Microservicio de material")
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;

    @ApiOperation(value="Lista de material")
    @GetMapping("/all")
    public List<Material> findAll() {
        return materialService.findAll();
    }

    @ApiOperation(value="Obtiene datos de material")
    @GetMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable Long id) {
        Material material = materialService.findById(id);
        return ResponseEntity.ok(material);
    }

    @ApiOperation(value="Elimina un material")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        materialService.deleteById(id);
    }

    @ApiOperation(value="Crea un material")
    @PostMapping("/save")
    public Material save(@RequestBody Material material) {
        return materialService.save(material);
    }

    @ApiOperation(value="Modifica un material")
    @PutMapping("/update")
    public Material update(@RequestBody Material material) {
        return materialService.save(material);
    }
}
