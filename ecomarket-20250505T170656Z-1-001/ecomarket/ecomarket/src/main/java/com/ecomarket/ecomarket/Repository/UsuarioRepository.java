package com.ecomarket.ecomarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecomarket.ecomarket.model.UsuarioModel;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
