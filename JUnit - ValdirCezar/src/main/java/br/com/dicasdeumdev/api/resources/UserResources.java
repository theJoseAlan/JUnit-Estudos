package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResources {

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new User(1, "Alan", "ala@gmail.com", "1223"));
    }

}