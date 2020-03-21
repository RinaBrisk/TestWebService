package web.webapp;

import lombok.NoArgsConstructor;
import web.webapp.model.Project;

import javax.ws.rs.core.Response;
import java.util.List;

@NoArgsConstructor
public class ResultResponse {
    private Object result;
    private String code;
    private String message;
    private String state;

    public Response getResult(TypeOfRequest request, Object result){
        this.result = result;
        if (TypeOfRequest.PUT.equals(request)) {
            code = Response.status(201).toString();
            state = Response.Status.ACCEPTED.toString();
        } else {
            code = Response.status(200).toString();
            state = Response.Status.OK.toString();
        }
        return Response
                .status(Response.Status.OK)
                .entity(this)
                .build();
    }

    public Response getResult(String message){
        code = Response.status(400).toString();
        state = Response.Status.BAD_REQUEST.toString();
        this.message = message;
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(this)
                .build();
    }

}
