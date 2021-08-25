package com.poc.rediscache.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Global Search Wrapper Service")
                        .version("v1.0.0")
                        .description("This service will be a wrapper to the global search Service.")
                        .termsOfService("Terms of Service")
                        .license(getLicense())
                        .contact(getContact())
                );

    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail("account_type_admin@persistent.co.in");
        contact.setName("Persistent Software Ltd.");
        contact.setUrl("www.persistent.co.in");
        contact.setExtensions(Collections.emptyMap());
        return contact;
    }

    private License getLicense() {
        License license = new License();
        license.setName("API License");
        license.setUrl("API license URL");
        license.setExtensions(Collections.emptyMap());
        return license;
    }


}