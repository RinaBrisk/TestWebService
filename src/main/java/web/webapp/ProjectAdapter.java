package web.webapp;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class ProjectAdapter {

    private final Client client;

    public ProjectAdapter(Client client){
        this.client = client;
    }

    public ResultResponse buildProject(String url){
        return new ResultResponse(url, Response.Status.OK.toString());
    }
}
