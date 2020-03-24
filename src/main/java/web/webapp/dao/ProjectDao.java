package web.webapp.dao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.webapp.model.ProjectRepository;
import web.webapp.model.Project;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Component
public class ProjectDao implements ProjectRepository<Project> {

    @Autowired
    public InMemoryProjectDB projectDB;

//    public ProjectDao(InMemoryProjectDB projectDB){
//        ProjectDao.projectDB = projectDB;
//    }

    @Override
    public List<Project> findByOwner(String owner) {
        return projectDB.getProjectList().stream().filter(project -> project.getOwner().equals(owner)).collect(Collectors.toList());
    }

    @Override
    public List<Project> getAll() {
        return projectDB.getProjectList();
    }

    @Override
    public boolean add(Project project) {
        boolean isOk = false;
        if (project.getUrl() == null || project.getUrl().isEmpty()) {
            return isOk;
        }
        if (findByUrl(project.getUrl()) == null) {
            projectDB.addProject(project.getUrl(), project.getOwner(), project.getNumberOfStars());
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
            projectDB.getProjectList().remove(project);
            isOk = true;
        }
        return isOk;
    }

    @Override
    public boolean update(Project project) {
        boolean isOk = false;
        if (findByUrl(project.getUrl()) != null) {
            projectDB.getProjectList().forEach(p -> {
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
                projectDB.getProjectList().stream().filter(project -> project.getUrl().equals(url)).findAny().get() : null;
    }

    private boolean projectExists(String url) {
        return projectDB.getProjectList().stream().anyMatch(project -> project.getUrl().equals(url));
    }
}
