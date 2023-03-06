package com.example.demo.config;

import com.example.demo.domain.Usuario;
import com.example.demo.respositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class localConfig {

    @Autowired
    private UsuarioRepository repository;

    @Bean
    public void startDb(){
        Usuario usuario1 = new Usuario(null, "Alan", "alan@gmail.com", "12345");
        Usuario usuario2 = new Usuario(null, "Barbara", "barbaridade@gmail.com", "1234");

        repository.saveAll(List.of(usuario1, usuario2));
    }

}
