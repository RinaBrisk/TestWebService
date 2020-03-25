package web.webapp;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;
import web.webapp.dao.ProjectDao;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @GetMapping("/all")
    public ResponseEntity<ResultResponse> projects(){
        final List<Project> projects = projectDao.getAll();
        return new ResponseEntity<>(new ResultResponse(projects), HttpStatus.OK);
    }


    @GetMapping("/{owner}")
    public ResultResponse project(@PathVariable String owner) {
        final List<Project> projects = projectDao.findByOwner(owner);
        return new ResultResponse(projects);
    }


    @PostMapping("/create")
    public ResultResponse create(@RequestBody Project project) {
        final boolean result = projectDao.add(project);
        return new ResultResponse(result, TypeOfRequest.POST);
    }


    @DeleteMapping("/delete")
    public ResultResponse delete(@RequestBody Project project) {
        final boolean result = projectDao.delete(project.getUrl());
        return new ResultResponse(result, TypeOfRequest.DELETE);
    }


    @PutMapping("/update")
    public ResultResponse update(@RequestBody Project project) {
        final boolean result = projectDao.update(project);
        return new ResultResponse(result, TypeOfRequest.PUT);
    }

}