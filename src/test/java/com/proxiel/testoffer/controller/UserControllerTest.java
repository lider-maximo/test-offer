package com.proxiel.testoffer.controller;

import com.proxiel.testoffer.TestOfferApplication;
import com.proxiel.testoffer.dto.UserDTO;
import com.proxiel.testoffer.repository.UserRepository;
import com.proxiel.testoffer.service.UserService;
import com.proxiel.testoffer.service.impl.UserServiceImpl;
import com.proxiel.testoffer.utils.InstanceFactory;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * User Controller unit tests
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestOfferApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureDataMongo
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @MockBean
    private UserServiceImpl userService;

    @Mock
    private UserService service = new UserServiceImpl();

    @Mock
    private static UserRepository userRepository;

    @LocalServerPort
    private int port;

    String baseUrl = "http://localhost:\" + port + \"/test-offer";

    /**
     * Before tests
     */
    @Before
    public void beforeTest() {
        this.userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);
    }

    /**
     * Find all users test.
     *
     * @result List of users will be displayed with HttpStatus FOUND
     */
    @Test
    public void whenFindAllUsers_thenReturnResponseEntityFound() {
        int statusCode = RestAssured
                .given()
                .get("http://localhost:" + port + "/test-offer/users")
                .statusCode();
        assertEquals(HttpStatus.FOUND.value(), statusCode);
    }

    /**
     * Find user by login test.
     *
     * @result No user found with HttpStatus NO_CONTENT
     */
    @Test
    public void whenFindUserByLogin_thenReturnStatutNoContent() {

        int statusCode = RestAssured
                .given()
                .get("http://localhost:" + port + "/test-offer/users/login/badLogin")
                .getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT.value(), statusCode);
    }

    /**
     * Register a new user test.
     *
     * @result User created with HttpStatus CREATED
     */
    @Test
    public void whenRegisterUser_thenReturnStatutCreated() {

        UserDTO userDTO = InstanceFactory.userDTO;

        int statusCode = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(userDTO)
                .post("http://localhost:" + port + "/test-offer/users/register")
                .statusCode();

        assertEquals(HttpStatus.CREATED.value(), statusCode);
    }

    /**
     * Register a new user test - Bad birthdate.
     *
     * @result User not created with HttpStatus NOT_ACCEPTABLE
     */
    @Test
    public void whenRegisterUserWithBadBirthdate_thenReturnStatutNotAcceptable() {

        UserDTO userDTO = InstanceFactory.userDTOBadBirhdate;

        int statusCode = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(userDTO)
                .post("http://localhost:" + port + "/test-offer/users/register")
                .statusCode();

        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), statusCode);
    }

    /**
     * Register a new user test - Bad country.
     *
     * @result User not created with HttpStatus NOT_ACCEPTABLE
     */
    @Test
    public void whenRegisterUserWithBadCountry_thenReturnStatutNotAcceptable() {

        UserDTO userDTO = InstanceFactory.userDTOBadCountry;

        int statusCode = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(userDTO)
                .post("http://localhost:" + port + "/test-offer/users/register")
                .statusCode();

        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), statusCode);
    }

    /**
     * Register a new user test - Bad password.
     *
     * @result User not created with HttpStatus BAD_REQUEST
     */
    @Test
    public void whenRegisterUserWithBadPassword_thenReturnStatutBadRequest() {

        UserDTO userDTO = InstanceFactory.userDTOBadPassword;

        int statusCode = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(userDTO)
                .post("http://localhost:" + port + "/test-offer/users/register")
                .statusCode();

        assertEquals(HttpStatus.CREATED.value(), statusCode);
    }
}
