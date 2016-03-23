package nl.ocwduo.vzub.web;

import nl.ocwduo.vzub.autorisatie.filter.AnnotatedLogxFilter;
import nl.ocwduo.vzub.web.config.WebConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Machiel de Jager on 22-3-2016.
 */
public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfiguration.class);

        // name
        rootContext.setDisplayName("VZUB 2");

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // filters
        container.addFilter("LogXFilter", AnnotatedLogxFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
    }


}

