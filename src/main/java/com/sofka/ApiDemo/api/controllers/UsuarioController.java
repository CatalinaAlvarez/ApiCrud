package com.sofka.ApiDemo.api.controllers;

import com.sofka.ApiDemo.api.models.UsuarioModel;
import com.sofka.ApiDemo.api.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario" )
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return usuarioServices.obtenerUsuario();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
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
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id";
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    //Crear el de update

    








}
