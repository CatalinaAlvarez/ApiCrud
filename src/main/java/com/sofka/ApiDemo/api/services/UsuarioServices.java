package com.sofka.ApiDemo.api.services;

import com.sofka.ApiDemo.api.models.UsuarioModel;
import com.sofka.ApiDemo.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public String guardarUsuario(UsuarioModel usuario){
        try{
            usuarioRepository.save(usuario);
            return "Guardado exitoso";
        }catch(Exception e){
            return null;
        }
    }

    public Optional<UsuarioModel> obtenerPorId(long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.buscarPorPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void borrarUsuario(UsuarioModel usuario){
        usuarioRepository.deleteById(usuario.getId());
    }

}
