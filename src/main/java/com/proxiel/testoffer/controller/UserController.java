package com.proxiel.testoffer.controller;

import com.proxiel.testoffer.LogExecutionTime;
import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.dto.UserDTO;
import com.proxiel.testoffer.mapper.UserMapper;
import com.proxiel.testoffer.service.UserService;
import com.proxiel.testoffer.utils.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * <p>User Controller
 * Rest Controller for managing User different API's
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
@Api(tags = "Users API")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * Get all users from the database controller
     *
     * @return new ResponseEntity with List of users and HttpStatut FOUND
     */
    @ApiOperation(value = "Find all the users from the database")
    @GetMapping
    public ResponseEntity<User> findAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity(users, HttpStatus.FOUND);
    }

    /**
     * Get user by login from the database controller
     *
     * @return new ResponseEntity with user and HttpStatus FOUND if OK, ApiError and HttpStatus NO_CONTENT if KO
     */
    @ApiOperation(value = "Find user by login")
    @GetMapping("/login/{login}")
    public ResponseEntity<User> findUserByLogin(@PathVariable String login) {
        User user = userService.findUserByLogin(login);
        if (user != null) {
            return new ResponseEntity(user, HttpStatus.FOUND);
        } else {
            final String error = "No element found with the following login : " + login;
            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.NO_CONTENT)
                    .message(error)
                    .build();
            return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
        }
    }

    /**
     * Register a new User controller
     *
     * @param userDTO
     * @param optionalRequestParam
     * @return HttpStatus CREATED if OK, NOT_ACCEPTABLE if less than 18 years or not leave in France,
     * BAD_REQUEST if Validation KO
     */
    @ApiOperation(value = "Register new user")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO, @RequestParam(value = "optionalRequestParam", required = false) Boolean optionalRequestParam) {
        if (optionalRequestParam == null) {
            optionalRequestParam = true;
        }
        if (Period.between(userDTO.getBirthdate(), LocalDate.now()).getYears() < 18) {
            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .message("The user should have more than 18 years")
                    .build();
            return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
        } else if (!(userDTO.getCountry().toLowerCase().trim().equals("france"))) {
            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .message("The user should leave in France")
                    .build();
            return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
        } else {
            try {
                userService.registerUser(UserMapper.INSTANCE.dtoToEntity(userDTO));
                return new ResponseEntity(userDTO, HttpStatus.CREATED);
            } catch (ConstraintViolationException ex) {
                ApiError apiError = ApiError.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message(ex.getMessage())
                        .build();
                return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
            }
        }

    }
}
