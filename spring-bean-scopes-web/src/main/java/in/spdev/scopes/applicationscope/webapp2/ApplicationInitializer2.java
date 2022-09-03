package in.spdev.scopes.applicationscope.webapp2;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer2 implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
                    annotationConfigWebApplicationContext.register(AppConfig2.class);

        //create the ds
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);

        //register ds
        ServletRegistration.Dynamic dynamicServletRegistration = servletContext.addServlet("ds2", dispatcherServlet);
        dynamicServletRegistration.setLoadOnStartup(1);
        dynamicServletRegistration.addMapping("/app2/*");
    }
}