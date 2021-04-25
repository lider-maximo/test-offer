package com.proxiel.testoffer.data;

import com.proxiel.testoffer.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * User entity
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Document(collection = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    String id;

    @Field("user_login")
    @NotNull(message = "Login must not be null")
    String login;

    @Field("user_password")
    @Size(min = 8, max = 15, message
            = "Password must be between 8 and 15 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must respect password rules")
    @NotNull(message = "Password must not be null")
    String password;

    @Field("user_birthdate")
    @NotNull(message = "Birthdate must not be null")
    LocalDate birthdate;

    @Field("user_gender")
    @NotNull(message = "Gender must not be null")
    Gender gender;

    @Field("user_country")
    @NotNull(message = "Country must not be null")
    String country;

    @Field("user_phone")
    String phone;
}
