package web.webapp.model;

import java.util.List;

public interface IProjectService {

    List<Project> findByOwner(String url);

    List<Project> getAll();

    boolean add(Project project);

    boolean delete(String url);

    boolean update(Project project);

}
