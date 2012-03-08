package com.unilever.api.unileverheartbeatapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/heartbeat.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Unilever HeartBeat REST API")
				.description("Unilever Heartbeat REST API documentation")
				.termsOfServiceUrl("http://www.unilever.com")
				.contact("vibhash.kumar@oracle.com")
				.license("Unilever License")
				.licenseUrl("http://unilever.com")
				.version("1.0").build();
	}

	//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.concretepage.controller"))
//				//.paths(regex("/product.*"))
//				.build()
//				.apiInfo(metaData());
//	}
//	private ApiInfo metaData() {
//		return new ApiInfoBuilder()
//				.title("Spring Boot REST API")
//				.description("\"Spring Boot REST API for Online Store\"")
//				.version("1.0.0")
//				.license("Apache License Version 2.0")
//				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//				.contact(new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"))
//				.build();
//	}
//	@Override
//	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html")
//				.addResourceLocations("classpath:/META-INF/resources/");
//
//		registry.addResourceHandler("/webjars/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}

}