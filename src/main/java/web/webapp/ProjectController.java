package web.webapp;

import web.webapp.model.Project;
import web.webapp.model.ProjectDao;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/project")
//@NoArgsConstructor
@Produces({MediaType.APPLICATION_JSON})
public class ProjectController {

    private ProjectAdapter adapter;
    private ResultResponse response;

    // @Inject
//    public ProjectController(ProjectAdapter adapter){
//        this.adapter = adapter;
//    }

    public ProjectController() {
        this.adapter = new ProjectAdapter();
        this.response = new ResultResponse();
    }

    @GET
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response projects() {
        List<Project> projects = adapter.getAll();
        return response.getResult(TypeOfRequest.GET, projects);
    }

    @GET
    @Path("/{url}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response project(@PathParam("url") String url) {
        Object object = adapter.getByUrl(url);
        if (object.getClass().equals(Project.class)) {
            return response.getResult(TypeOfRequest.POST, object);
        } else {
            return response.getResult(object.toString());
        }
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