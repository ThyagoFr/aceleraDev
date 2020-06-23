package com.thyagofr.springmongodb.resources;
import java.util.List;
import java.util.stream.Collectors;
import com.thyagofr.springmongodb.domain.User;
import com.thyagofr.springmongodb.dto.UserDTO;
import com.thyagofr.springmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserServices service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {

    List<User> users = service.findAll();
    List<UserDTO> listDTO = users.stream().map( user -> new UserDTO(user)).collect(Collectors.toList());
    System.out.println(users);
    return ResponseEntity.ok().body(listDTO);
    
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findByID(@PathVariable String id) {
    User user = service.findByID(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
  
}