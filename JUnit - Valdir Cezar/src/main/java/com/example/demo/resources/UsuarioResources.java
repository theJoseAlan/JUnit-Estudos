package com.example.demo.resources;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.dto.UsuarioDTO;
import com.example.demo.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResources {

    public static final String ID = "/{id}";
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsuarioService service;

    @GetMapping(value = ID)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){

        //mapper.map(fonte, destino) - Deve ser passado a fonte e o destino para conversão
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UsuarioDTO.class));

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        return ResponseEntity.ok().body(service.findAll().stream()
                .map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO obj){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ID).buildAndExpand(service.create(obj).getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @PutMapping(ID)
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO obj){

        obj.setId(id);

        return ResponseEntity.ok().body(mapper.map(service.update(obj), UsuarioDTO.class));

    }

    @DeleteMapping(ID)
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id){

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

}
