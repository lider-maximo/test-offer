package com.proxiel.testoffer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * <p>Swagger Configuration
 * Fill the API infos and configurate the necessary beans to implement Swagger UI
 * </p>
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * API Info method declaration
     *
     * @return new ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "User REST API",
                "API exposing 2 REST services",
                "1.0",
                "Terms of service URL",
                new Contact("Hassan JROUNDI", "www.proxiel.com", "hassan.jroundi@outlook.fr"),
                "API License",
                "API License URL",
                Collections.emptyList());
    }

    /**
     * Docket bean declaration
     *
     * @return new Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.proxiel.testoffer"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Swagger UI bean declaration
     *
     * @return new UiConfigurationBuilder
     */
    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .validatorUrl(null)
                .build();
    }
}
