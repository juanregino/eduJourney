package com.eduJourney.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(contact = @Contact(name = "Juan Pablo Regino", url = "https://github.com/juanregino", email = "juanreginopenagos@gmail.com"), title = "Documentation: EduJourney Api", version = "1.0"), servers = {
    @Server(description = "Local ENV", url = "http://localhost:8080/api/v1")
})
public class SwaggerConfig {
  
}
