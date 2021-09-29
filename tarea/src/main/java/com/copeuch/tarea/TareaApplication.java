package com.copeuch.tarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TareaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TareaApplication.class, args);
	}
	
	//Define all details for app info
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Mantenedor tareas")
                .description("Mantenedor tareas API")
                .version("1.0")
                .build();
    }   

  
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                 .groupName("mantenedortareas")
                .apiInfo(apiInfo())
                //set up JWT input
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.copeuch.tarea"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Tareas API", "") {},
                        new Tag("Tareas", "Mantener tareas"));
    }
    
}
