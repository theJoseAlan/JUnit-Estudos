package com.example.demo.services.mpl;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;
import com.example.demo.respositories.UsuarioRepository;
import com.example.demo.services.exceptions.ObjectNotfoundException;
import org.h2.engine.User;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServicemplTest {


    public static final Integer ID = 1;
    public static final String NOME = "Alan Sales";
    public static final String EMAIL = "alansales@gmail.com";
    public static final String SENHA = "1234";
    public static final int INDEX = 0;
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

    //Teste de usuário encontado pelo ID e retorno da instância do usuário
    @Test
    @DisplayName("FindByID deve retornar uma instância de usuário")
    void findById() {
        /*Quando repository.findById for chamado por qualquer numero inteiro (anyInt)
        então retorne o optional user*/
        when(repository.findById(anyInt())).thenReturn(optionalUsuario);

        Usuario response = service.findById(ID);

        //Assegure que o response não vai ser nulo
        assertNotNull(response);

        //Assegure que esses dois argumentos são iguais.
        //O primeiro é o que espero receber, o segundo é o que o método retornará
        assertEquals(Usuario.class, response.getClass());

        //Testando os atributos esperados e retornados

        //Assegure que o ID do incio da classse vai ser igual ao ID do response
        //(O mesmo vale para os demais atributos)
        assertEquals(ID, response.getId());

        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());



    }


    //Nesse teste, quando chamar o ID uma exceção deve ser gerada.
    //Assim o teste tenta (try) chamar o ID e ele deve cair no catch para só então
    //o assert comparar se a exceção esperada foi a mesma que o teste gerou
    @Test
    @DisplayName("FindByID deve retornar uma exceção de Objeto não encontrado")
    void FindByIdNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotfoundException("Objeto não encontrado"));

        try{
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotfoundException.class, ex.getClass());

            //Verificando se a menssagem que espero é a mesma retornada
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    @DisplayName("FindAll deve retornar uma lista de usuários")
    void findAll() {

        //Em list.of() podem ser mais de um usuário no parâmetro list.of(user1, user2, user3)
        when(repository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> response = service.findAll();

        //Para verificar se não retornará nulo
        assertNotNull(response);

        //O tamanho da lista deve ser apenas 1, já que só colocamos 1 usuário na lista
        assertEquals(1, response.size());

        //Verificando se o objeto no index 0 da lista tenha a classe Usuário
        assertEquals(Usuario.class, response.get(INDEX).getClass());

        //Verificando se o objeto no index 0 da lista tem o ID igual ao ID esperado
        //que está como constante no início da classe (o mesmo vale para os demais atributos)
        assertEquals(ID, response.get(
                INDEX).getId());

        assertEquals(NOME, response.get(INDEX).getNome());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(SENHA, response.get(INDEX).getSenha());
    }


    @Test
    @DisplayName("Create deve retornar sucess")
    void create() {
        when(repository.save(any())).thenReturn(usuario);

        Usuario response = service.create(usuarioDTO);

        assertNotNull(response);
        assertEquals(Usuario.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(SENHA, response.getSenha());
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