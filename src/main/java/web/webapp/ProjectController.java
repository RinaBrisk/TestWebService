package web.webapp;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.webapp.model.Project;
import web.webapp.model.ProjectDao;

import javax.ws.rs.*;
import java.net.URISyntaxException;
import java.util.List;

@NoArgsConstructor
@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;


    @GetMapping("projects/all")
    public ResultResponse projects() throws URISyntaxException {
        final List<Project> projects = projectDao.getAll();
        return new ResultResponse(projects);
    }

    @GetMapping("projects/{owner}")
    public ResultResponse project(@PathVariable String owner) throws URISyntaxException{
        final List<Project> projects = projectDao.findByOwner(owner);
        return new ResultResponse(projects);
    }


    @PostMapping("/create")
    public ResultResponse create(@RequestBody Project project) throws URISyntaxException {
        final boolean result = projectDao.add(project);
        return new ResultResponse(result, TypeOfRequest.POST);
    }


    @DeleteMapping("/delete/{url}")
    public ResultResponse delete(@PathParam("url") String url) throws URISyntaxException {
        final boolean result = projectDao.delete(url);
        return new ResultResponse(result, TypeOfRequest.DELETE);
    }


    @PutMapping("/update")
    public ResultResponse update(Project project) throws URISyntaxException{
        final boolean result = projectDao.update(project);
        return new ResultResponse(result, TypeOfRequest.PUT);
    }

}