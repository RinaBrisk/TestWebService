//package web.webapp;
//
//import com.google.inject.*;
//import com.google.inject.servlet.GuiceServletContextListener;
//import com.google.inject.servlet.ServletModule;
//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.jackson.JacksonFeature;
//import org.glassfish.jersey.server.ResourceConfig;
//import sun.security.pkcs11.Secmod;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//
//public class Application{
//
//    public static void main(String[] args) {
//        add(new AbstractModule() {
//            @Override
//            protected void configure() {
//                // ...
//            }
//        });
//
//        Injector injector = Guice.createInjector(modules);
//        JerseyGuiceUtils.install(injector);
//    }
//
//}
//
//public class Application{
//
//    private static Client client;
//    private static ProjectController projectController;
//
//    public static void main(String[] args){
//        ClientConfig clientConfig = new ClientConfig();
//        clientConfig.register(JacksonFeature.class);
//        client = ClientBuilder.newClient(clientConfig);
//        projectController = new ProjectController(new ProjectAdapter(client));
//    }
//
//}
