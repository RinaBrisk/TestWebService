package web.webapp;

import lombok.NoArgsConstructor;
import web.webapp.model.Project;

import javax.inject.Inject;
import javax.jws.Oneway;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/project")
//@NoArgsConstructor
@Produces({MediaType.APPLICATION_JSON})
public class ProjectController {

    private ProjectAdapter adapter;

   // @Inject
//    public ProjectController(ProjectAdapter adapter){
//        this.adapter = adapter;
//    }

    public ProjectController(){
        this.adapter = new ProjectAdapter();
    }

    @GET
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response projects() {
        return adapter.getAll();
    }

    @GET
    @Path("/{url}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response project(@PathParam("url") String url) {
        return adapter.getByUrl(url);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Project project, @Context UriInfo uriInfo) {
        return adapter.create(project, uriInfo);
    }

    @DELETE
    @Path("/delete/{url}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("url") String url) {
        return adapter.delete(url);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Project project, @Context UriInfo uriInfo) {
        return adapter.update(project, uriInfo);
    }

}