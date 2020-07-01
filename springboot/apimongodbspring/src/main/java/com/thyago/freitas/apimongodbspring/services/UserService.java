package com.thyago.freitas.apimongodbspring.services;
import com.thyago.freitas.apimongodbspring.dto.UserDTO;
import com.thyago.freitas.apimongodbspring.models.User;
import com.thyago.freitas.apimongodbspring.repository.UserRepository;
import com.thyago.freitas.apimongodbspring.services.exceptions.EmailAlreadyUsed;
import com.thyago.freitas.apimongodbspring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ObjectNotFoundException("Usuario nao encontrado");
    }

    public User insert(User user) {
        Optional<User> userExist = repo.searchByEmail(user.getEmail());
        System.out.println(userExist.isPresent());
        if (!userExist.isPresent()){
            return repo.insert(user);
        }
        throw new EmailAlreadyUsed("Email ja cadastrado");
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User user){
        Optional<User> userNotUpdated = repo.findById(user.getId());
        if (userNotUpdated.isPresent()){
            User userToUpdate = userNotUpdated.get();
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setName(user.getName());
            return repo.save(userToUpdate);

        }
        throw new ObjectNotFoundException("Usuario nao encontrado");

    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }

}
