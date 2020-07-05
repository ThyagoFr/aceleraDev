package com.thyago.freitas.apimongodbspring.repository;
import com.thyago.freitas.apimongodbspring.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
