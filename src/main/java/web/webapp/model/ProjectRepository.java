package web.webapp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
