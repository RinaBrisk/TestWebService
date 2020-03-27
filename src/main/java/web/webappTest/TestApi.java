package web.webappTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import web.webapp.model.Project;
import web.webapp.ResultResponse;

public class TestApi {

    private static final String URL = "http://localhost:8081/projects/";

    private RestTemplate template;

    public TestApi(RestTemplate template) {
        this.template = template;
    }

    public ResultResponse getAllProjects(){
        return template.getForObject(URL + "all", ResultResponse.class);
    }

    public ResultResponse getProjectByOwner(String owner){
        return template.getForObject(URL + owner, ResultResponse.class);
    }

    public ResultResponse postProject(Project project){
        return template.postForObject(URL + "create", project, ResultResponse.class);
    }

    public ResponseEntity<ResultResponse> updateProject(Project project){
        return template.exchange(URL + "update",
                HttpMethod.PUT, new HttpEntity<>(project), ResultResponse.class);
    }

    public ResponseEntity<ResultResponse> deleteProject(Project project){
        return template.exchange(URL + "delete",
                HttpMethod.DELETE, new HttpEntity<>(project), ResultResponse.class);
    }

}
