package com.example.demo.services;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);

    List<Usuario> findAll();

    Usuario create(UsuarioDTO obj);

    Usuario update(UsuarioDTO obj);
}
