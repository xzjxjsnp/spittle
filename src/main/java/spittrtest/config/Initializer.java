package spittrtest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{webConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    multipart请求
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/", 2097152, 4194304, 0));
    }
}

