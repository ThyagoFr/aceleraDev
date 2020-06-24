package com.thyagofr.springmongodb.services;
import java.util.List;
import java.util.Optional;
import com.thyagofr.springmongodb.domain.User;
import com.thyagofr.springmongodb.dto.UserDTO;
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

  public User insert(User user) {
    return repo.insert(user);
  }

  public void delete(String id){
    findByID(id);
    repo.deleteById(id);
  }

  public User update(User user){
    findByID(user.getId());
    Optional<User> newuser = repo.findById(user.getId());
    updateUser(newuser.get(),user);
    return repo.save(newuser.get());
  }
  
  private void updateUser(User newuser, User olduser){
    newuser.setEmail(olduser.getEmail());
    newuser.setName(olduser.getName());
  } 

  public User fromDTOP(UserDTO userDTO) {
    return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
  }

}