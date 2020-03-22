//package web.webapp.service;
//
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import web.webapp.model.ProjectDao;
//import web.webapp.model.Project;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriBuilder;
//import javax.ws.rs.core.UriInfo;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//@Component
//@NoArgsConstructor
//public class ProjectService {
//
//    @Autowired
//    private ProjectDao projectDao;
//
//
//    public List<Project> getAll() {
//        return projectDao.getAll();
//    }
//
//    public List<Project> getByOwner(String owner) {
////        if (url == null) return ErrorMsg.MISSING_FIELD_URL;
////        if (!url.contains("https://github.com")) return ErrorMsg.INCORRECT_FIELD_URL;
////        Project project = projectDao.findByUrl(url);
////        if (project == null)
////            return ErrorMsg.PROJECT_NOT_FOUND;
////        else
////            return project;
//        return projectDao.findByOwner(owner);
//    }
//
//    public Response create(Project project) throws URISyntaxException {
//        //Boolean  = projectDao.add(project);
//        //return Response.status(201)
//              //  .entity("Employee is created successfully with id = " + createdProject.getUrl())
//              //  .contentLocation(new URI("/project/" + createdProject.getUrl())).build();
//
//    }
//
//    public Response delete(String url) {
//        //projectDao.delete(url);
//        return Response.noContent().build();
//    }
//
//    public Response update(Project project, UriInfo uriInfo) {
//        Boolean updateOk = projectDao.update(project);
//        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
//        builder.path(project.getUrl());
//        Response.ResponseBuilder responseBuilder = updateOk ? Response.ok() : Response.noContent();
//        responseBuilder.contentLocation(builder.build());
//        return responseBuilder.build();
//    }
//
//}
