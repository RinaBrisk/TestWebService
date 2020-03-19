package web.webapp;

import lombok.Getter;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/webapi")
public class Application{

    private static Client client;
    private static ProjectController projectController;

    public static void main(String[] args){
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonFeature.class);
        client = ClientBuilder.newClient(clientConfig);
        projectController = new ProjectController(new ProjectAdapter(client));
    }

}
