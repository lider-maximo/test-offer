package com.proxiel.testoffer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * MongoDB Validation Configuration
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Configuration
public class MongoValidationConfig {

    /**
     * Declare a Mongo Event Listener
     *
     * @return new ValidationgMongoListener
     */
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    /**
     * Declare a validator
     *
     * @return new LocalValidatorFactoryBean
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
