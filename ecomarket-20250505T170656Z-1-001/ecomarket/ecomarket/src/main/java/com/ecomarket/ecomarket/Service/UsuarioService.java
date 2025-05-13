package com.ecomarket.ecomarket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.ecomarket.Repository.UsuarioRepository;
import com.ecomarket.ecomarket.model.UsuarioModel;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    } 

    public UsuarioModel findByid(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public UsuarioModel save(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

}
