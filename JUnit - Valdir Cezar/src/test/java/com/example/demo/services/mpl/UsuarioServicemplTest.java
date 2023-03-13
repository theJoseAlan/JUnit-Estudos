package com.example.demo.services.mpl;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;
import com.example.demo.respositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServicemplTest {


    public static final Integer ID = 1;
    public static final String NOME = "Alan Sales";
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
        //Inicia os Mocks. O "this" referencia essa classe
        MockitoAnnotations.openMocks(this);
        startUser(); //Sempre que iniciar a classe, ele starta os mocks e inicia os usuários

    }

    @Test
    @DisplayName("FindByID deve retornar uma instância de usuário")
    void findById() {
        /*Quando repository.findById for chamado por qualquer numero inteiro (anyInt)
        então retorne o optional user*/
        when(repository.findById(anyInt())).thenReturn(optionalUsuario);

        Usuario response = service.findById(ID);

        //Assegure que o response não vai ser nulo
        Assertions.assertNotNull(response);

        //Assegure que esses dois argumentos são iguais.
        //O primeiro é o que espero receber, o segundo é o que o método retornará
        assertEquals(Usuario.class, response.getClass());

        //Testando os atributos esperados e retornados

        //Assegure que o ID do incio da classe
        //vai ser igual ao ID do response
        //ID esperado -> 1
        assertEquals(ID, response.getId());

        //Assegure que o NOME do incio da classe
        //vai ser igual ao NOME do response
        assertEquals(NOME, response.getNome());

        //Assegure que o EMAIL do incio da classe
        //vai ser igual ao EMAIL do response
        assertEquals(EMAIL, response.getEmail());


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
        usuario = new Usuario(ID, NOME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID, NOME, EMAIL, SENHA);
        optionalUsuario = Optional.of(new Usuario(ID, NOME, EMAIL, SENHA));
    }
}