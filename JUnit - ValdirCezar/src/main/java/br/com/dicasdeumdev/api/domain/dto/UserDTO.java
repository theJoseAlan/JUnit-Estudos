package br.com.dicasdeumdev.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String nome;
    private String email;

    @JsonIgnore //Assim não há retorno da senha quando houver um get. Não é interessante mostrar a senha do cliente
    private String password;

}
