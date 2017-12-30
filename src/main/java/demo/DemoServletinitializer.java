package demo;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author HODO
 */
public class DemoServletinitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //初始化root WebApplicationContext
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationRootApplicationContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //初始化 servlet WebApplicationContext
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebMvcConfiguration.class);

        //注册 servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet("demo", new DispatcherServlet(webApplicationContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        //注册 filter
        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", CharacterEncodingFilter.class);
        characterEncoding.setInitParameter("encoding", "UTF-8");
        characterEncoding.setInitParameter("forceEncoding", "true");

    }
}
