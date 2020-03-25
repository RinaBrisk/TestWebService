package web.webapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public List<Project> findByOwner(String owner) {
        return getAll().stream().filter(project -> project.getOwner().equals(owner)).collect(Collectors.toList());
    }

    @Override
    public List<Project> getAll() {
        List<Project> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public boolean add(Project project) {
        boolean isOk = false;
        if (project.getUrl() == null || project.getUrl().isEmpty()) {
            return isOk;
        }
        if (findByUrl(project.getUrl()) == null) {
            repository.save(project);
            isOk = true;
        }
        return isOk;
    }

    @Override
    public boolean delete(String url) {
        boolean isOk = false;
        if (url == null || url.isEmpty()) {
            return isOk;
        }
        Project project = findByUrl(url);
        if (project != null) {
            getAll().remove(project);
            isOk = true;
        }
        return isOk;
    }

    @Override
    public boolean update(Project project) {
        boolean isOk = false;
        if (findByUrl(project.getUrl()) != null) {
            getAll().forEach(p -> {
                if (p.getUrl().equals(project.getUrl())) {
                    p.setOwner(project.getOwner());
                    p.setNumberOfStars(project.getNumberOfStars());
                }
            });
            isOk = true;
        }
        return isOk;
    }

    private Project findByUrl(String url) {
        return projectExists(url) ?
                getAll().stream().filter(project -> project.getUrl().equals(url)).findAny().get() : null;
    }

    private boolean projectExists(String url) {
        return getAll().stream().anyMatch(project -> project.getUrl().equals(url));
    }

}
