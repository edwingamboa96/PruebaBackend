package com.daviplata.app.utils;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Edwin Gamboa Sanchez
 * @version 4/07/2021
 * @since 2/07/2021
 */

@Configuration
@EnableSwagger2
public class Swagger {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.daviplata.app"))
				.paths(PathSelectors.any()).build();
	}

}
