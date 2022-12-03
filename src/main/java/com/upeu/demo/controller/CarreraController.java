package com.upeu.demo.controller;

import com.upeu.demo.entity.Carrera;
import com.upeu.demo.service.CarreraService;
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
@RequestMapping("/api/carrera")
@Api(value = "Microservicios de gestion de carreras", description ="Microservicio de carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @ApiOperation(value="Lista de carreras")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de carreras");
        result.put("data", carreraService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de la carrera")
    @GetMapping("/{id}")
    public ResponseEntity<Carrera> findById(@PathVariable Long id) {
        Carrera carrera = carreraService.findById(id);
        return ResponseEntity.ok(carrera);
    }

    @ApiOperation(value="Elimina una carrera")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Carrera data = carreraService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe carrera con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            carreraService.deleteById(id);
            result.put("success", true);
            result.put("message", "Carrera eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea una carrera")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Carrera carrera) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Carrera registrado correctamente");
        result.put("data", carreraService.save(carrera));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica una carrera")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Carrera carrera) {
                HashMap<String, Object> result = new HashMap<>();
        Carrera data = carreraService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            carrera.setCarrId(id);
            carreraService.save(carrera);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", carrera);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
