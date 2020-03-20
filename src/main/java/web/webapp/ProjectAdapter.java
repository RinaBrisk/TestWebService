package web.webapp;

import web.webapp.dao.ProjectDao;
import web.webapp.model.Project;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class ProjectAdapter {

    private final ProjectDao projectDao;

    public ProjectAdapter(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    Response getAll(){
        return Response
                .status(Response.Status.OK)
                .entity(projectDao.listAll())
                .build();
    }

    Response getByUrl(String url){
        return Response
                .status(Response.Status.OK)
                .entity(projectDao.findByUrl(url))
                .build();
    }

    Response create(Project project, UriInfo uriInfo){
        Project createdProject = projectDao.add(project);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(createdProject.getUrl());
        return Response.created(builder.build()).build();
    }

    Response delete(String url){
        Project project = projectDao.findByUrl(url);
        if(project != null){
            projectDao.delete(project);
        }
        return Response.noContent().build();
    }

    Response update(Project project, UriInfo uriInfo){
        Boolean updateOk = projectDao.update(project);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(project.getUrl());
        Response.ResponseBuilder responseBuilder = updateOk ? Response.ok() : Response.noContent();
        responseBuilder.contentLocation(builder.build());
        return responseBuilder.build();
    }

}
