package com.proxiel.testoffer;

import com.proxiel.testoffer.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot main class
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@EnableSwagger2
public class TestOfferApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestOfferApplication.class, args);
    }

}
