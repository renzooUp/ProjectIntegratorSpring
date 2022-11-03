package com.upeu.demo.controller;

import com.upeu.demo.entity.Persona;
import com.upeu.demo.service.PersonaService;
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
@RequestMapping("/api/persona")
@Api(value = "Microservicios de gestion de personas", description ="Microservicio de Persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @ApiOperation(value="Lista de personas")
    @GetMapping("/all")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @ApiOperation(value="Obtiene datos de una persona")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(persona);
    }

    @ApiOperation(value="Elimina una persona")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personaService.deleteById(id);
    }

    @ApiOperation(value="Crea una persona")
    @PostMapping("/save")
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @ApiOperation(value="Modifica una persona")
    @PutMapping("/update")
    public Persona update(@RequestBody Persona persona) {
        return personaService.save(persona);
    }
}
