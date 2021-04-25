package com.proxiel.testoffer.repository;

import com.proxiel.testoffer.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>User Repository
 * Extends MongoRepository
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByLogin(String login) throws NullPointerException;
}
