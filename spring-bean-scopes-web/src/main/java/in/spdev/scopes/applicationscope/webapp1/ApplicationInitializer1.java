package in.spdev.scopes.applicationscope.webapp1;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer1 implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(AppConfig1.class);

        //create the ds
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);

        //register ds
        ServletRegistration.Dynamic dynamicServletRegistration = servletContext.addServlet("ds1", dispatcherServlet);
        dynamicServletRegistration.setLoadOnStartup(1);
        dynamicServletRegistration.addMapping("/app1/*");
    }
}
