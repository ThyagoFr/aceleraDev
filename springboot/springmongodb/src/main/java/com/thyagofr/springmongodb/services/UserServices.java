package com.thyagofr.springmongodb.services;
import java.util.List;
import java.util.Optional;
import com.thyagofr.springmongodb.domain.User;
import com.thyagofr.springmongodb.repository.UserRepository;
import com.thyagofr.springmongodb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findByID(String id){
    Optional<User> user = repo.findById(id);
    return user.orElseThrow( () -> new ObjectNotFoundException("Objeto nao encontrado"));
  }
  
}