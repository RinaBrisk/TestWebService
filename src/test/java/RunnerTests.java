
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Before;
import org.junit.Test;
import web.data.Person;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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

       // String result = (String) target.path(NAME).request(MediaType.APPLICATION_JSON).get(String.class);

       // assertThat(result, is(equalTo(EXPECTED_JSON)));

        Person person = new Person("Rina", "Bolotnikovskaya");


        Entity<Person> entity = Entity.entity(person, MediaType.APPLICATION_JSON);

        ClientResponse response = target
                .request()
                .post(entity, ClientResponse.class);

        System.out.println("Form response " + response.getStatus());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        System.out.println("Server response .... \n");
    }
}
