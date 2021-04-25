package com.proxiel.testoffer.service.impl;

import com.proxiel.testoffer.LogExecutionTime;
import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.repository.UserRepository;
import com.proxiel.testoffer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>User Service Implementation
 * Service for implementing CRUD methods for User entity
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    /**
     * Register a new user service
     *
     * @param user
     * @since 1.0
     */
    @Override
    @LogExecutionTime
    public void registerUser(User user) {
        userRepository.save(user);
    }

    /**
     * Find a user by his ID service
     *
     * @param id
     * @return User with the given ID
     */
    @Override
    @LogExecutionTime
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    /**
     * Find a user by his login service
     *
     * @param login
     * @return User with the given login
     */
    @Override
    @LogExecutionTime
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    /**
     * Get all users service
     *
     * @return List of users
     */
    @Override
    @LogExecutionTime
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Getters and Setters

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
