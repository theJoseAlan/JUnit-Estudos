package com.example.demo.services;

import com.example.demo.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);

    List<Usuario> findAll();
}
