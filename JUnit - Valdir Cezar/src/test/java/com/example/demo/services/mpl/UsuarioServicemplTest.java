package com.example.demo.services.mpl;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;
import com.example.demo.respositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServicemplTest {


    public static final int ID = 1;
    public static final String ALAN_SALES = "Alan Sales";
    public static final String EMAIL = "alansales@gmail.com";
    public static final String SENHA = "1234";
    @InjectMocks //Indicando que precisa de uma instância real para testar os métodos
    private UsuarioServicempl service; //Se vou testar, devo ter uma instância dela

    //Necessário, já que ele dá um findById para buscar um usuário
    //Se não ele dá um null pointer exception
    @Mock
    private UsuarioRepository repository;

    @Mock
    private ModelMapper mapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach
    void setUp(){
        //Inicia os Mocks. oO this faz referência a essa classe
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByEmail() {
    }


    private void startUser(){
        usuario = new Usuario(ID, ALAN_SALES, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID, ALAN_SALES, EMAIL, SENHA);
        optionalUsuario = Optional.of(new Usuario(ID, ALAN_SALES, EMAIL, SENHA));
    }
}