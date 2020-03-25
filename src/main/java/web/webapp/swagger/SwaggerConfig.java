package web.webapp.swagger;

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
    public Docket projectApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //returns an ApiSelectorBuilder, which provides
                // the apis() and paths() methods to filter the controllers and
                // methods being documented using String predicates
                .apis(RequestHandlerSelectors.basePackage("web.webapp")) //base package to filter the API
                .paths(PathSelectors.any()) //additional filter to generate documentation only for the path starting
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(metaData());

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Test REST API")
                .description("\"Spring Boot REST API\"")
                .contact(new Contact("Rina Sergeeva", null, "rina_sergeeva@bk.ru"))
                .build();
    }
}
