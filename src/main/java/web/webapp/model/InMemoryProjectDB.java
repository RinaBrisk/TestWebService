package web.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class InMemoryProjectDB {

    private List<Project> projectList;

    public InMemoryProjectDB() {
        projectList = new ArrayList<>();
        addProject("https://github.com/edomingues/jersey.git", "Jersey", 2349);
        addProject("https://github.com/Jetty.git", "Jetty", 10393);
        addProject("https://github.com/edo/Tomcat.git", "Tomcat", 45999);
    }

    public Project addProject(String url, String owner, int numberOfStars) {
        Project project = new Project();
        project.setUrl(url);
        project.setOwner(owner);
        project.setNumberOfStars(numberOfStars);
        projectList.add(project);
        return project;
    }

}
