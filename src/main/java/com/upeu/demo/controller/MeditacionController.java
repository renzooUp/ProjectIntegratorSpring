/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Meditacion;
import com.upeu.demo.service.MeditacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})/*Hare peticiones a tal ruta externa*/
@RestController
@RequestMapping("/api/meditacion")
@Api(value = "Microservicios de gestion de meditacion", description ="Microservicio de meditacion")
public class MeditacionController {

    @Autowired
    private MeditacionService meditacionService;

    @ApiOperation(value="Lista de meditacion")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de meditacion");
        result.put("data", meditacionService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de la meditacion")
    @GetMapping("/{id}")
    public ResponseEntity<Meditacion> findById(@PathVariable Long id) {
        Meditacion meditacion = meditacionService.findById(id);
        return ResponseEntity.ok(meditacion);
    }

    @ApiOperation(value="Elimina una meditacion")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Meditacion data = meditacionService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe programa con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            meditacionService.deleteById(id);
            result.put("success", true);
            result.put("message", "Meditacion eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una meditacion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Meditacion meditacion) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Meditación registrado correctamente");
        result.put("data", meditacionService.save(meditacion));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una meditación")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Meditacion meditacion){
        HashMap<String, Object> result = new HashMap<>();
        Meditacion data = meditacionService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            meditacion.setMediId(id);
            meditacionService.save(meditacion);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", meditacion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
