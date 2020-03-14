package webapp;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/download-proj")
public class RunTestsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{param}")
    public Response downloadProject(@PathParam("param") String url) {
        //загрузка проекта с GitHub
        String output = "You send url: " + url;
        return Response
                .status(200)
                .entity(url)
               // .entity(new ServiceResponse(output, "Ok"))
                .build();

    }
}