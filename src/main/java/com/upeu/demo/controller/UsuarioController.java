/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.controller;

import com.upeu.demo.entity.Usuario;
import com.upeu.demo.service.UsuarioService;
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
@RequestMapping("/api/tipo-persona")
@Api(value = "Microservicios de gestion de usuarios", description ="Microservicio de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value="Lista de usuario")
    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de usuario");
        result.put("data", usuarioService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Obtiene datos de usuario")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @ApiOperation(value="Elimina un taller")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = usuarioService.findById(id);
        if(data == null){
            result.put("success", false);
            result.put("message", "No existe usuario con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            usuarioService.deleteById(id);
            result.put("success", true);
            result.put("message", "Usuario eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value="Crea un usuario")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Usuario registrado correctamente");
        result.put("data", usuarioService.save(usuario));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="Modifica un usuario")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = usuarioService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            usuario.setUsuaId(id);
            usuarioService.save(usuario);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", usuario);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}
