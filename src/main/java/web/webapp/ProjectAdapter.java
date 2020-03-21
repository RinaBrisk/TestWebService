package web.webapp;

import web.webapp.model.ProjectDao;
import web.webapp.model.Project;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

//@NoArgsConstructor
public class ProjectAdapter {

    private ProjectDao projectDao;

//    @Inject
//    public ProjectAdapter(ProjectDao projectDao){
//        this.projectDao = projectDao;
//    }

    public ProjectAdapter() {
        this.projectDao = new ProjectDao();
    }

    List<Project> getAll() {
        return projectDao.getAll();
    }

    Object getByUrl(String url) {
        if (url == null) return ErrorMsg.MISSING_FIELD_URL;
        if (!url.contains("https://github.com")) return ErrorMsg.INCORRECT_FIELD_URL;
        Project project = projectDao.findByUrl(url);
        if (project == null)
            return ErrorMsg.PROJECT_NOT_FOUND;
        else
            return project;
    }

    Response create(Project project, UriInfo uriInfo) {
        Project createdProject = projectDao.add(project);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(createdProject.getUrl());
        return Response.created(builder.build()).build();
    }

    Response delete(String url) {
        Project project = projectDao.findByUrl(url);
        if (project != null) {
            projectDao.delete(project);
        }
        return Response.noContent().build();
    }

    Response update(Project project, UriInfo uriInfo) {
        Boolean updateOk = projectDao.update(project);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(project.getUrl());
        Response.ResponseBuilder responseBuilder = updateOk ? Response.ok() : Response.noContent();
        responseBuilder.contentLocation(builder.build());
        return responseBuilder.build();
    }

}
