package web.webapp;
import web.data.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/download")
@Produces({MediaType.APPLICATION_JSON})
public class RunTestsService {
    @GET
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String url) {

        Person person = new Person(url, "Nepal");

        return Response
                .status(Response.Status.OK)
                .entity(person)
                .build();
    }


}