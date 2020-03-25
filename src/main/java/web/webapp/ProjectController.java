package web.webapp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.webapp.enums.TypeOfRequest;
import web.webapp.model.Project;
import web.webapp.model.ProjectService;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "View a list of available projects", response = ResultResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    })
    @GetMapping(value = "/all", produces = "application/json")
    public ResultResponse projects() {
        final List<Project> projects = projectService.getAll();
        return new ResultResponse(projects);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a project")
    })
    @ApiOperation(value = "Search a project by the owner", response = ResultResponse.class)
    @GetMapping(value = "/{owner}", produces = "application/json")
    public ResultResponse project(@PathVariable String owner) {
        final List<Project> projects = projectService.findByOwner(owner);
        return new ResultResponse(projects);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added a project"),
            @ApiResponse(code = 404, message = "Error in input parameters")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation(value = "Add a project", response = ResultResponse.class)
    @PostMapping(value = "/create", produces = "application/json")
    public ResultResponse create(@RequestBody Project project) {
        final boolean result = projectService.add(project);
        return new ResultResponse(result, TypeOfRequest.POST);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted a project"),
            @ApiResponse(code = 404, message = "Project not found. You may have made an error in the input parameters")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a project", response = ResultResponse.class)
    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResultResponse delete(@RequestBody Project project) {
        final boolean result = projectService.delete(project.getUrl());
        return new ResultResponse(result, TypeOfRequest.DELETE);
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a project"),
            @ApiResponse(code = 404, message = "Project not found. You may have made an error in the input parameters")
    })
    @ApiOperation(value = "Update a project", response = ResultResponse.class)
    @PutMapping(value = "/update", produces = "application/json")
    public ResultResponse update(@RequestBody Project project) {
        final boolean result = projectService.update(project);
        return new ResultResponse(result, TypeOfRequest.PUT);
    }

}