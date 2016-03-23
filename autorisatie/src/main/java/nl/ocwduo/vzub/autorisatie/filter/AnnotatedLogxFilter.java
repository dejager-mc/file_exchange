package nl.ocwduo.vzub.autorisatie.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by in434jag on 22-3-2016.
 */
@WebFilter(
        initParams = {
            @WebInitParam(name = "applicationId", value = "JI"),
            @WebInitParam(name = "subApplicationId", value = "JI")
        },
        filterName = "logxFilter",
        urlPatterns = {"/*"}
)

//            @WebInitParam(name = "uri:/rest/", value = "gui-private"),
//            @WebInitParam(name = "uri:/jms/iets/in", value = "gui-private"),
//            @WebInitParam(name = "uri:/jms/iets/out", value = "gui-private"),
//            @WebInitParam(name = "uri:/", value = "gui-private")
public final class AnnotatedLogxFilter implements Filter {
    private Filter filter;

    public AnnotatedLogxFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            Class e = Class.forName("nl.ocwduo.logx.filter.LogxFilterImpl");
            this.filter = (Filter)e.newInstance();
            this.filter.init(filterConfig);
        } catch (Exception var3) {
            throw new ServletException("Kan geen implementatie van het LogxFilter initialiseren", var3);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.filter.doFilter(request, response, chain);
    }

    public void destroy() {
        this.filter.destroy();
    }
}