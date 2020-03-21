package web.webapp.dao;

import lombok.NoArgsConstructor;
import web.webapp.model.Project;

import javax.inject.Inject;
import java.util.List;

//@NoArgsConstructor
public class ProjectDao implements Manipulate<Project> {

    private InMemoryProjectDB projectDB;

    public ProjectDao(){
        this.projectDB = new InMemoryProjectDB();
    }

    //@Inject
    //private ProjectDao(InMemoryProjectDB projectDB){
//        this.projectDB = projectDB;
//    }

    @Override
    public Project findByUrl(String url) {
        return projectDB.getProjectList().stream().filter(project -> project.getUrl().equals(url)).findAny().get();
    }

    @Override
    public List<Project> listAll() {
        return projectDB.getProjectList();
    }

    @Override
    public Project add(Project project) {
        return projectDB.addProject(project.getUrl(), project.getOwner(), project.getNumberOfStars());
    }

    @Override
    public void delete(Project project) {
        projectDB.getProjectList().remove(project);
    }

    @Override
    public boolean update(Project project) {
        boolean ok = false;
        Project existingProject = findByUrl(project.getUrl());
        if (existingProject != null) {
            projectDB.getProjectList().forEach(p -> {
                if(p.getUrl().equals(project.getUrl())){
                    p.setOwner(project.getOwner());
                    p.setNumberOfStars(project.getNumberOfStars());
                }
            });
            ok = true;
        }
        return ok;
    }
}
