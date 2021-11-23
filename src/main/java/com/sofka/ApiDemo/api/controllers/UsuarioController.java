package com.sofka.ApiDemo.api.controllers;

import antlr.Utils;
import com.sofka.ApiDemo.api.models.UsuarioModel;
import com.sofka.ApiDemo.api.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario" )
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return usuarioServices.obtenerUsuarios();
    }

    @PostMapping
    public String guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServices.guardarUsuario(usuario);

    }

    @GetMapping(path= "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioServices.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServices.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Long id){
        if(usuarioServices.eliminarUsuario(id))
            return new ResponseEntity<String>("Usuario con id " + id + " eliminado", HttpStatus.OK);
        return new ResponseEntity<String>("Usuario no encontrado", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/email")
    public UsuarioModel obtenerporEmail(@RequestBody UsuarioModel user) {
        UsuarioModel userModel = usuarioServices.obtenerporEmail(user);
        if(userModel != null) {
            return this.usuarioServices.obtenerporEmail(user);
        } else {
            return null;
        }
    }







    //Crear el de update

    








}
