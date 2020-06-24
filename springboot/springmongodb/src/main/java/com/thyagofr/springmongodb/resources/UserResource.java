package com.thyagofr.springmongodb.resources;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import com.thyagofr.springmongodb.domain.User;
import com.thyagofr.springmongodb.dto.UserDTO;
import com.thyagofr.springmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO userdto) {
    User user = service.fromDTOP(userdto);
    user = service.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userdto) {
    User user = service.fromDTOP(userdto);
    user.setId(id);
    user = service.update(user);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}