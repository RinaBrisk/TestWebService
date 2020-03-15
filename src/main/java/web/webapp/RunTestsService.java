package web.webapp;

import web.webapp.model.Project;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/download")
@Produces({MediaType.APPLICATION_JSON})
public class RunTestsService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/url")
    public Response getMessage(Project project) {

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
//                .entity(person)
//                .build();
//    }

}