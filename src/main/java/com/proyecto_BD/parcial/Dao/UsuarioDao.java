package com.proyecto_BD.parcial.Dao;

import com.proyecto_BD.parcial.models.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface UsuarioDao {

    List<Usuario> getUsuarios();

}
