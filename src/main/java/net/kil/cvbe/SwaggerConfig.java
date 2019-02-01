/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.kil.cvbe"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("CV-port REST API")
                .description("Application to make sense a difference between Rest and Rest-HAL (HATEOAS). It's a simple skills demonstration and a tries to keep'in tonus with Spring at the one time.\n" +
                        "Its provides a set of resources about technical Experience with small and universal entities such as Employees, Customers, Projects and few utility ones.\n" +
                        "As a consequence that will be a Back-end Service for a fully and flexible reflective (HAL-based) FrontEnd application.")
                .version("1.0.0")
                .license("GNU General Public License v3.0")
                .licenseUrl("http://www.gnu.org/licenses/quick-guide-gplv3.html")
                .contact(new Contact("Alexander Kil", "https://github.com/alexander-kil", "Alexander.Kill@gmail.com"))
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}