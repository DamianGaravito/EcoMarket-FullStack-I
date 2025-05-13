package com.ecomarket.ecomarket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.ecomarket.ecomarket.Service.UsuarioService;
import com.ecomarket.ecomarket.model.UsuarioModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listar(){

        List<UsuarioModel> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios);
    }
    


    @PostMapping
    public ResponseEntity<UsuarioModel> guardar(@RequestBody UsuarioModel usuarioModel) {

        UsuarioModel usuarioNuevo = usuarioService.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscar(@PathVariable Long id) {

        try {
            UsuarioModel usuarioModel = usuarioService.findByid(id);
            return ResponseEntity.ok(usuarioModel);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    



    
    
    
}
