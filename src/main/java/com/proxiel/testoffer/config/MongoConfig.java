package com.proxiel.testoffer.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * <p>MongoDB Configuration
 * Connect to MongoDB database and create a MongoTemplate
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Configuration
public class MongoConfig {

    /**
     * Create a connection with the database
     *
     * @return MongoClient
     */
    @Bean
    public MongoClient mongo() {

        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/testoffer");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    /**
     * Create a Mongo Template
     *
     * @return new MongoTemplate with our database name
     * @throws Exception
     */
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongo(), "testoffer");
    }
}
