package web.webapp;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;
import web.webapp.model.ProjectDao;

import java.util.List;

@NoArgsConstructor
@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @GetMapping("projects/all")
    public ResultResponse projects(){
        final List<Project> projects = projectDao.getAll();
        return new ResultResponse(projects);
    }


    @GetMapping("projects/{owner}")
    public ResultResponse project(@PathVariable String owner) {
        final List<Project> projects = projectDao.findByOwner(owner);
        return new ResultResponse(projects);
    }


    @PostMapping("projects/create")
    public ResultResponse create(@RequestBody Project project) {
        final boolean result = projectDao.add(project);
        return new ResultResponse(result, TypeOfRequest.POST);
    }


    @DeleteMapping("projects/delete")
    public ResultResponse delete(@RequestBody Project project) {
        final boolean result = projectDao.delete(project.getUrl());
        return new ResultResponse(result, TypeOfRequest.DELETE);
    }


    @PutMapping("projects/update")
    public ResultResponse update(@RequestBody Project project) {
        final boolean result = projectDao.update(project);
        return new ResultResponse(result, TypeOfRequest.PUT);
    }

}