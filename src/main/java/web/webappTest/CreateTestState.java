package web.webappTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import web.webapp.ResultResponse;
import web.webapp.model.Project;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CreateTestState {

    private RestTemplate repository;

    private static final String URL = "http://localhost:8081/projects/";

    public CreateTestState(RestTemplate repository) {
        this.repository = repository;
    }

    public Project createAndAddProject() {
        Project project = createProject();
        addProject(project);
        return project;
    }

    public void deleteAllProjects(){
        getAllProjects().forEach(this::deleteProject);
    }

    public Project createProject() {
        Random random = new Random();
        String owner = String.valueOf(Math.abs(random.nextInt()));

        String url = "https://github.com/"
                .concat(owner)
                .concat(".git");
        return new Project(url, owner, Math.abs(random.nextInt()));
    }

    public Project getProject() {
        List<Project> projectList = getAllProjects();
        if (projectList == null) {
            return createProject();
        } else {
            return projectList.get(0);
        }
    }

    public int getNumberOfProjects() {
        List<Project> projectList;
        projectList = getAllProjects();
        return projectList.size();
    }

    private List<Project> getAllProjects() {
        return Objects.requireNonNull(repository.getForObject(URL + "/all", ResultResponse.class)).getResult();
    }

    private void deleteProject(Project project) {
        ResponseEntity<ResultResponse> resultResponse = repository.exchange(URL + "/delete",
                HttpMethod.DELETE, new HttpEntity<>(project), ResultResponse.class);
    }

    public void addProject(Project project){
        repository.postForObject(URL + "/create", project, ResultResponse.class);
    }

}
