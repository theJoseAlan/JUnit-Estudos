package com.example.demo.resources;

import com.example.demo.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResources {

    @GetMapping(value = "{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(new Usuario(1, "Alan", "alan@gmail.com", "senha123 "));

    }

}
