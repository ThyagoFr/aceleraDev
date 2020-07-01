package com.thyago.freitas.apimongodbspring.repository;
import com.thyago.freitas.apimongodbspring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Query("{ 'email' : {$eq : ?0} }")
    Optional<User> searchByEmail(String email);
}
