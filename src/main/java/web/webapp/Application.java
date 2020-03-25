package web.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import web.webapp.model.Project;
import web.webapp.model.ProjectRepository;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner bookDemo(ProjectRepository repository) {
        return (args) -> {
            Random random = new Random();
            repository.save(new Project(random.nextLong(), "https://github.com/edomingues/jersey.git", "Jersey", 2349));
            repository.save(new Project(random.nextLong(), "https://github.com/Jetty.git", "Jetty", 10393));
            repository.save(new Project(random.nextLong(), "https://github.com/edo/Tomcat.git", "Tomcat", 45999));

        };
    }

}