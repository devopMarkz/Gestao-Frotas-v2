package com.github.devopMarkz.gestao_frotas.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de teste.",
                version = "v1",
                description = "API feita para testar a autenticação.",
                contact = @Contact(
                        name = "Marcos André",
                        email = "marcosdev2002@gmail.com"
                )
        )
)
public class OpenApiConfiguration {
}
