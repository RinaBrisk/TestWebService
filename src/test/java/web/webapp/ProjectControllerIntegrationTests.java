package web.webapp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import web.webapp.enums.ErrorMsg;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;
import web.webappTest.CreateTestState;
import web.webappTest.TestApi;
import web.webappTest.utils.CheckUtil;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectControllerIntegrationTests {

    private CreateTestState testState;
    private TestApi api;

    private RestTemplate restTemplate;

    @Before
    public void set() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        testState = new CreateTestState(restTemplate);
        api = new TestApi(restTemplate);
    }

    @Test
    public void whenGetAllProjects_thenStatus200() {
        ResultResponse response = api.getAllProjects();
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
        assertThat(response.getResult(), notNullValue());
        assertThat(response.getResult().isEmpty(), is(false));
    }

    @Test
    public void whenGetAllProjects_thenNotProjectsStatus200() {
        testState.deleteAllProjects();
        ResultResponse response = api.getAllProjects();
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
        assertThat(response.getResult(), nullValue());
        assertThat(response.getMessage(), is(ErrorMsg.PROJECTS_NOT_FOUND.getText()));
    }

    @Test
    public void givenOwner_whenFindByOwner_thenStatus200(){
        Project expectedProject = testState.createAndAddProject();

        ResultResponse response = api.getProjectByOwner(expectedProject.getOwner());
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
        assertThat(response.getResult(), notNullValue());
        assertThat(response.getResult().size(), is(1));

        Project realProject = response.getResult().get(0);
        assertThat(realProject, is(expectedProject));
    }

    @Test
    public void givenNonexistentOwner_whenFindByOwner_thenStatus200(){
        ResultResponse response = api.getProjectByOwner("Test");
        CheckUtil.checkOkResponse(response, TypeOfRequest.GET);
        assertThat(response.getResult(), nullValue());
        assertThat(response.getMessage(), is(ErrorMsg.PROJECTS_NOT_FOUND.getText()));
    }

    @Test
    public void givenProject_whenCreate_thenStatus201(){
        Project project = testState.createAndAddProject();
        ResultResponse response = api.postProject(project);
        CheckUtil.checkOkResponse(response, TypeOfRequest.POST);
    }

    @Test
    public void givenProjectWithEmptyUrl_whenCreate_thenStatus404(){
        Project project = testState.createProject();
        project.setUrl("");
        ResultResponse response = api.postProject(project);
        CheckUtil.checkErrorResponse(response);
    }

    @Test
    public void givenProject_whenUpdate_thenStatus200(){
        Project project = testState.getProject();
        ResponseEntity<ResultResponse> response = api.updateProject(project);
        CheckUtil.checkOkResponse(response.getBody(), TypeOfRequest.PUT);
    }

    @Test
    public void givenProject_whenDelete_thenStatus204(){
        Project project = testState.getProject();
        int numberOfProjectBefore = testState.getNumberOfProjects();
        ResponseEntity<ResultResponse> response = api.deleteProject(project);
        CheckUtil.checkOkResponse(response.getBody(), TypeOfRequest.DELETE);
        assertThat(testState.getNumberOfProjects(), is(--numberOfProjectBefore));
    }

}
