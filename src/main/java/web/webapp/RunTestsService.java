package web.webapp;
import web.data.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/download")
@Produces({MediaType.APPLICATION_JSON})
public class RunTestsService {

    @POST
    @Path("/url")
    public Response getMessage(Person person) {

        //Person person = new Person(url, "Nepal");

        return Response
                .status(Response.Status.OK)
                .entity(person)
                .build();
    }


//    @GET
//    @Path("/{param}")
//    public Response getMessage(@PathParam("param") String url) {
//
//        Person person = new Person(url, "Nepal");
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(person)
//                .build();
//    }


}