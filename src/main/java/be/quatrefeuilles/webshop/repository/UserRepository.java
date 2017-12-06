package be.quatrefeuilles.webshop.repository;

import be.quatrefeuilles.webshop.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
