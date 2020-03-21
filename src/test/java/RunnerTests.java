
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class RunnerTests {

    private WebTarget target;

    private static final String URI = "http://localhost:8081/checker/rest/download/url";

    @Before
    public void setUp() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonFeature.class);
        Client client = ClientBuilder.newClient(clientConfig);
        target = client.target(URI);
    }

    @Test
    public void getProjectTest() {

     //   Entity<Project> entity = Entity.json(new Project("myURL"));

      //  Response response = target
//                .request(MediaType.APPLICATION_JSON)
//                .post(entity, Response.class);
//
//        System.out.println("Response code:  " + response.getStatus());
//
//        if (response.getStatus() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + response.getStatus());
//        }

    }

    //Entity<String> model = Entity.model(
    //  "{\"url\": \"Lili\"}", MediaType.APPLICATION_JSON);

    //String str = "{\"url\": \"Lili\"}";

    ///////////////

    // Form input = new Form();
    // input.param("url", "true");

    // Response response = target.request().post(Entity.form(input));

    ///////////////

    // String result = (String) target.path(NAME).request(MediaType.APPLICATION_JSON).get(String.class);

    // assertThat(result, is(equalTo(EXPECTED_JSON)));

    //   Entity<Project> model = Entity.model(person, MediaType.APPLICATION_JSON);

    // Entity<String> model = Entity.model(
    //      "{\"name\": \"Lili\", \"address\": \"JavaInterviewPoint1212\"}",
    //           MediaType.APPLICATION_JSON);

//        ClientResponse response = target
//                .request()
//                .post(model, ClientResponse.class);

}
