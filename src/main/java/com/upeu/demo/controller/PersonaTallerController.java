/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.PersonaTaller;
import com.upeu.demo.service.PersonaTallerService;
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
@RequestMapping("/api/persona-taller")
@Api(value = "Microservicios de gestion de persona taller", description ="Microservicio de persona taller")
public class PersonaTallerController {
    @Autowired
    private PersonaTallerService personaTallerService;

    @ApiOperation(value="Lista de persona taller")
    @GetMapping("/all")
    public List<PersonaTaller> findAll() {
        return personaTallerService.findAll();
    }

    @ApiOperation(value="Obtiene datos de persona taller")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personaTaller = personaTallerService.findById(id);
        return ResponseEntity.ok(personaTaller);
    }

    @ApiOperation(value="Elimina una persona taller")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personaTallerService.deleteById(id);
    }

    @ApiOperation(value="Crea una persona taller")
    @PostMapping("/save")
    public PersonaTaller save(@RequestBody PersonaTaller personaTaller) {
        return personaTallerService.save(personaTaller);
    }

    @ApiOperation(value="Modifica una persona taller")
    @PutMapping("/update")
    public PersonaTaller update(@RequestBody PersonaTaller personaTaller) {
        return personaTallerService.save(personaTaller);
    }
}
