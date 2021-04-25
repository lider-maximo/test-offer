package com.proxiel.testoffer.service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Application Properties configuration
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class SpringApplicationPropertiesApplication {
}
