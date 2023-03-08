package com.example.demo.services.mpl;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;
import com.example.demo.respositories.UsuarioRepository;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.exceptions.DataIntegratyViolationException;
import com.example.demo.services.exceptions.ObjectNotfoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicempl implements UsuarioService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsuarioRepository repository;


    @Override
    public Usuario findById(Integer id) {

        Optional<Usuario> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotfoundException("Objeto não encontrado"));

    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    @Override
    public Usuario create(UsuarioDTO obj) {

        findByEmail(obj);

        return repository.save(mapper.map(obj, Usuario.class));
    }

    @Override
    public Usuario update(UsuarioDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    public void findByEmail(UsuarioDTO obj){
        Optional<Usuario> usuario = repository.findByEmail(obj.getEmail());

        if(usuario.isPresent() && !usuario.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema");
        }
    }

}
