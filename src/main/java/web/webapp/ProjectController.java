package web.webapp;
import web.webapp.model.Project;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/project")
@Produces({MediaType.APPLICATION_JSON})
public class ProjectController {

    ProjectAdapter adapter;

//    public ProjectController(ProjectAdapter adapter){
//        this.adapter = adapter;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/build")
    public Response build(Project project) {

        return Response
                .status(Response.Status.OK)
                .entity(adapter.buildProject(project.getUrl()))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/runInnerTests")
    public Response runInnerTests(Project project) {

        ResultResponse result = new ResultResponse(project.getUrl(), Response.Status.OK.toString());

        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/runOtherTests")
    public Response runOtherTests(Project project) {

        ResultResponse result = new ResultResponse(project.getUrl(), Response.Status.OK.toString());

        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }


//    @GET
//    @Path("/{param}")
//    public Response getMessage(@PathParam("param") String url) {
//
//        Project person = new Project(url, "Nepal");
//
//        return Response
//                .status(Response.Status.OK)
//                .model(person)
//                .build();
//    }

}