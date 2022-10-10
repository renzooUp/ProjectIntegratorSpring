package com.upeu.demo.controller;

import com.upeu.demo.entity.Taller;
import com.upeu.demo.service.TallerService;
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
@RequestMapping("/taller")
@Api(value = "Microservicios de gestion de taller", description ="Microservicio de taller")
public class TallerController {

    @Autowired
    private TallerService tallerService;

    @ApiOperation(value="Lista de taller")
    @GetMapping("/all")
    public List<Taller> findAll() {
        return tallerService.findAll();
    }

    @ApiOperation(value="Obtiene datos de taller")
    @GetMapping("/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Long id) {
        Taller taller = tallerService.findById(id);
        return ResponseEntity.ok(taller);
    }

    @ApiOperation(value="Elimina un taller")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tallerService.deleteById(id);
    }

    @ApiOperation(value="Crea un taller")
    @PostMapping("/save")
    public Taller save(@RequestBody Taller taller) {
        return tallerService.save(taller);
    }

    @ApiOperation(value="Modifica un taller")
    @PutMapping("/update")
    public Taller update(@RequestBody Taller taller) {
        return tallerService.save(taller);
    }
}
