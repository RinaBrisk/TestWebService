package web.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.webapp.model.Project;
import web.webapp.model.ProjectRepository;

public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {
}
