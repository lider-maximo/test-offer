package com.proxiel.testoffer.utils;

import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.dto.UserDTO;
import com.proxiel.testoffer.enums.Gender;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Instance Factory for needed objects and Lists
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
public class InstanceFactory {

    public static User user = User.builder()
            .id("1")
            .login("login")
            .password("Test@2013")
            .gender(Gender.M)
            .birthdate(LocalDate.of(1989, 8, 20))
            .country("France")
            .phone("0662165537")
            .build();

    public static List<User> users = Arrays.asList(user);

    public static UserDTO userDTO = UserDTO.builder()
            .id("1")
            .login("login")
            .password("Test@2013")
            .gender(Gender.M)
            .birthdate(LocalDate.of(1989, 8, 20))
            .country("France")
            .phone("0662165537")
            .build();

    public static UserDTO userDTOBadBirhdate = UserDTO.builder()
            .id("1")
            .login("login")
            .password("Test@2013")
            .gender(Gender.M)
            .birthdate(LocalDate.of(2015, 8, 20))
            .country("France")
            .phone("0662165537")
            .build();

    public static UserDTO userDTOBadCountry = UserDTO.builder()
            .id("1")
            .login("login")
            .password("Test@2013")
            .gender(Gender.M)
            .birthdate(LocalDate.of(1989, 8, 20))
            .country("Maroc")
            .phone("0662165537")
            .build();

    public static UserDTO userDTOBadPassword = UserDTO.builder()
            .id("1")
            .login("login")
            .password(null)
            .gender(Gender.M)
            .birthdate(LocalDate.of(1989, 8, 20))
            .country("France")
            .phone("0662165537")
            .build();

    public static List<UserDTO> usersDTO = Arrays.asList(userDTO);
}
