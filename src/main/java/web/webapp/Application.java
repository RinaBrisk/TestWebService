//package web.webapp;
//
//
//import org.glassfish.hk2.api.DynamicConfiguration;
//import org.glassfish.hk2.api.DynamicConfigurationService;
//import org.glassfish.hk2.api.ServiceLocator;
//import org.glassfish.hk2.utilities.BuilderHelper;
//import org.glassfish.jersey.server.ResourceConfig;
//import web.webapp.dao.InMemoryProjectDB;
//import web.webapp.dao.ProjectDao;
//
//import javax.inject.Inject;
//
//public class Application extends ResourceConfig {
//
//    public Application() {
//
////        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
////        DynamicConfiguration config = dcs.createDynamicConfiguration();
////
////        config.bind(BuilderHelper.link(ProjectController.class).to(ProjectController.class).build());
////        config.bind(BuilderHelper.link(ProjectAdapter.class).to(ProjectController.class).build());
////        config.bind(BuilderHelper.link(ProjectDao.class).to(ProjectAdapter.class).build());
////        config.bind(BuilderHelper.link(InMemoryProjectDB.class).to(ProjectDao.class).build());
////
////        config.commit();
//
//        register(new MyAppBinder());
//        packages(true, "web.webapp");
//    }
//
//}
