package web.webappTest.utils;

import org.springframework.stereotype.Component;
import web.webapp.dao.InMemoryProjectDB;
import web.webapp.model.Project;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Component
public class CreateTestState {

    @Resource
    private InMemoryProjectDB projectDB;

    public Project createAndUpdateProject(){
        Project project = createProject();
        projectDB.addProject(project);
        return project;
    }

    public Project createProject(){
        Random random = new Random();
        String owner = String.valueOf(random.nextInt());

        String url = "https://github.com/"
                .concat(owner)
                .concat(".git");

        return new Project(url, owner, random.nextInt());
    }

    public Project getProject(){
        List<Project> projectList = projectDB.getProjectList();
        if(projectList.size() > 0){
            return projectList.get(0);
        }else{
            return createProject();
        }
    }
}
