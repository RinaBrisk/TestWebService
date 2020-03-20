package web.webapp.dao;

import web.webapp.model.Project;

import java.util.List;

public interface Manipulate<T> {

    T findByUrl(String url);

    List<T> listAll();

    Project add(Project project);

    void delete(Project project);

    boolean update(Project project);
}
