package web.webapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;
import web.webappTest.utils.CheckUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerIntegrationTests {

    @Autowired
    private CreateTestState testState;

    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8081/projects/";

    @Before
    public void set() {
        this.restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    @Test
    public void whenGetAllProjects_thenStatus200() {
        ResultResponse response = restTemplate.getForObject(URL + "all", ResultResponse.class);
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
    }

    @Test
    public void givenOwner_whenFindByOwner_thenStatus200(){
        String owner = testState.createAndUpdateProject().getOwner();
        ResultResponse response = restTemplate.getForObject(URL + owner, ResultResponse.class);
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
    }

    @Test
    public void givenProject_whenCreate_thenStatus201(){
        Project project = testState.createAndUpdateProject();
        ResultResponse response = restTemplate.getForObject(URL + "create", ResultResponse.class, project);
        CheckUtil.checkOkResponse(response, TypeOfRequest.POST);
    }

    @Test
    public void givenProject_whenUpdate_thenStatus200(){
        Project project = testState.getProject();
        ResultResponse response = restTemplate.getForObject(URL + "update", ResultResponse.class, project);
        CheckUtil.checkOkResponse(response, TypeOfRequest.PUT);
    }

    @Test
    public void givenProject_whenDelete_thenStatus204(){
        Project project = testState.getProject();
        ResultResponse response = restTemplate.getForObject(URL + "delete", ResultResponse.class, project);
        CheckUtil.checkOkResponse(response, TypeOfRequest.DELETE);
    }


}
