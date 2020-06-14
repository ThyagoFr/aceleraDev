package com.thyagofr.springboottest.resources;
import com.thyagofr.springboottest.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<User> index() {
    User u = new User(1L, "Thyago","thyagofr@alu.ufc.br","99999","12345");
    return ResponseEntity.ok().body(u);
  }

}
