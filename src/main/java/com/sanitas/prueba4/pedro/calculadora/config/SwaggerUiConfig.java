package com.sanitas.prueba4.pedro.calculadora.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerUiConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Calculadora API")
            .description("Aplicacion de prueba para Sanitas con un microservicio de ejemplo")
            .version("v0.0.1")
            .license(new License().name("GNU Affero General Public License").url("https://www.gnu.org/licenses/agpl-3.0.html")));
    }
}
