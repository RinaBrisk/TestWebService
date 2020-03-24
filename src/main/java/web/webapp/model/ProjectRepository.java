package web.webapp.model;

import java.util.List;

public interface ProjectRepository<T> {

    List<T> findByOwner(String url);

    List<T> getAll();

    boolean add(Project project);

    boolean delete(String url);

    boolean update(Project project);
}
