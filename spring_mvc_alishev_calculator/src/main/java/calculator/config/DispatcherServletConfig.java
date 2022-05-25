
//EQUIVALNET TO web.xml (with DispatcherServlet configuration)

package calculator.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    //Mark where is config file.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    //All request from client are going on Dispatcher Servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
