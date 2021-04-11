package org.booking.ticket;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    public static final String DEFAULT_INCLUDE_PATTERN = "/*";
	
	@Bean
	public Docket landManagementApi() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfo(
				"TICKET BOOKING REST API",
				"API to manage and read land, associated plots, land owners and plot owners. API uses HATEOS, provides HAL links",
				"1.0",
				"Terms of service",
				new Contact("Chaitanya Ankam | farmizen", "https://www.farmizen.com/", "support@farmizen.com"),
				"", "", Collections.emptyList());
	}
}
