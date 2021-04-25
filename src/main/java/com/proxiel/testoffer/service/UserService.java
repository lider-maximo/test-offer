package com.proxiel.testoffer.service;

import com.proxiel.testoffer.data.User;

import java.util.List;
import java.util.Optional;

/**
 * <p>User Service Interface
 * Declaring methods signature for CRUD actions for User entity
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
public interface UserService {

    public void registerUser(User user);

    public Optional<User> findUserById(String id);

    public List<User> getAllUsers();

    public User findUserByLogin(String login);

}
