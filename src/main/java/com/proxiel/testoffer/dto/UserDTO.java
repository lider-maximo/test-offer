package com.proxiel.testoffer.dto;

import com.proxiel.testoffer.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * UserDTO entity
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    String id;
    String login;
    String password;
    LocalDate birthdate;
    Gender gender;
    String country;
    String phone;
}
