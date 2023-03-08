package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;

    private String nome;

    private String email;

    //@JsonIgnore //Ignora (oculta na api) a senha. Obs.: problema é que aparece null no BD
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Libera para escrita, mas não para leitura
    private String senha;

}
