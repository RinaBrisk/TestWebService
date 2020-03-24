package web.webappTest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import web.webapp.dao.InMemoryProjectDB;
import web.webapp.model.Project;

import java.util.List;
import java.util.Random;

public class CreateTestState {

    private static InMemoryProjectDB projectDB;

    @Autowired
    public CreateTestState(InMemoryProjectDB projectDB){
        CreateTestState.projectDB = projectDB;
    }

    public static Project createAndUpdateProject(){
        Project project = createProject();
        projectDB.addProject(project);
        return project;
    }

    public static Project createProject(){
        Random random = new Random();
        String owner = String.valueOf(random.nextInt());

        String url = "https://github.com/"
                .concat(owner)
                .concat(".git");

        return new Project(url, owner, random.nextInt());
    }

    public static Project getProject(){
        List<Project> projectList = projectDB.getProjectList();
        if(projectList.size() > 0){
            return projectList.get(0);
        }else{
            return createProject();
        }
    }
}
