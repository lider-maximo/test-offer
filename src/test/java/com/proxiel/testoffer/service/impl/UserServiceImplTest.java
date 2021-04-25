package com.proxiel.testoffer.service.impl;

import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.repository.UserRepository;
import com.proxiel.testoffer.service.UserService;
import com.proxiel.testoffer.utils.InstanceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

/**
 * User Service Implementation unit tests.
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = SpringApplicationPropertiesApplication.class)
@SpringBootTest
public class UserServiceImplTest {

    @MockBean
    private UserServiceImpl userService;

    @Mock
    private static UserRepository userRepository;

    @InjectMocks
    private UserService service = new UserServiceImpl();

    /**
     * Before tests
     */
    @Before
    public void beforeTest() {
        this.userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);
    }

    /**
     * Getters and Setters test.
     */
    @Test
    public void whenCallGettersAndSetters_thenOk() {

        userService.setUserRepository(userRepository);
        Assert.assertEquals(userService.getUserRepository(), userRepository);

        UserRepository repository = userService.getUserRepository();
        Assert.assertEquals(userService.getUserRepository(), repository);
    }

    /**
     * Find user by ID test.
     *
     * @result User Optional found
     */
    @Test
    public void whenGetUserById_thenReturnUser() {

        User user = InstanceFactory.user;

        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        Optional<User> result = userService.findUserById(user.getId());

        Assert.assertEquals(Optional.of(user), result);
    }

    /**
     * Find user by login test.
     *
     * @result User object found
     */
    @Test
    public void whenGetUserByLogin_thenReturnUser() {

        User user = InstanceFactory.user;

        Mockito.doReturn(user).when(userRepository).findUserByLogin(user.getLogin());

        User result = userService.findUserByLogin(user.getLogin());

        Assert.assertEquals(user, result);
    }

    /**
     * Get all users test.
     *
     * @result List of Users
     */
    @Test
    public void whenGetAllUsers_thenReturnListOfUsers() {

        List<User> users = InstanceFactory.users;

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        Assert.assertEquals(users, result);
    }

    /**
     * Register new user test.
     *
     * @result User created
     */
    @Test
    public void whenRegisterUser_thenOk() {

        User user = InstanceFactory.user;

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenAnswer(i -> i.getArguments()[0]);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        userService.registerUser(user);
        Optional<User> result = userService.findUserById(user.getId());

        Assert.assertEquals(Optional.of(user), result);
    }
}
