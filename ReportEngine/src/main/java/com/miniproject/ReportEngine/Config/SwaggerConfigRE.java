package com.miniproject.ReportEngine.Config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfigRE {

	@Bean
	public Docket eksadAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.miniproject.ReportEngine"))
				.paths(regex("/miniprojectapi.*"))
				.build()
				.tags(
			//		new Tag("Report Engine", "Report Management API"),
			//		new Tag("Hubungi Kami","Service Management API"),
					new Tag("Data Profile",""),
					new Tag("Data Klaster",""))
				.apiInfo(metaInfo()
				);
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Mini Project - Report Engine - REST API",
				"Rest API Collection for Mini Project -Report Engine-", 
				"1.0.0", 
				"http://eksad.com",
				new Contact("EKSAD PRO", "http://www.eksadPro.com", "nhanggraeni@gmail.com"),
				"Anggraeni 2.0",
				"http://www.google.com",
				Collections.emptyList());

		return apiInfo;
	}
}