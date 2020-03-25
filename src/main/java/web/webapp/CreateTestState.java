package web.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.webapp.model.Project;
import web.webapp.model.ProjectService;

import java.util.List;
import java.util.Random;

@Component
public class CreateTestState {

    @Autowired
    private ProjectService projectService;

    public Project createAndUpdateProject(){
        Project project = createProject();
        projectService.add(project);
        return project;
    }

    public Project createProject(){
        Random random = new Random();
        String owner = String.valueOf(random.nextInt());

        String url = "https://github.com/"
                .concat(owner)
                .concat(".git");
        return new Project(random.nextLong(), url, owner, random.nextInt());
    }

    public Project getProject(){
        List<Project> projectList = projectService.getAll();
        if(projectList.size() > 0){
            return projectList.get(0);
        }else{
            return createProject();
        }
    }

}
