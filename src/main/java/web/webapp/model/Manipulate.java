package web.webapp.model;

import java.util.List;

public interface Manipulate<T> {

    T findByUrl(String url);

    List<T> getAll();

    Project add(Project project);

    void delete(Project project);

    boolean update(Project project);
}
