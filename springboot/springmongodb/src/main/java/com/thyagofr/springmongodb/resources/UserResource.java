package com.thyagofr.springmongodb.resources;
import java.util.List;
import com.thyagofr.springmongodb.domain.User;
import com.thyagofr.springmongodb.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserServices service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    List<User> users = service.findAll();
    return ResponseEntity.ok().body(users);
  }
  
}