package ru.itis.config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.itis.config.app.ApplicationConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { // это конфигурация диспатчер сервлета
    // Альтернатива файлу dispatcherServlet.xml. Объявляем один сервлет который всем управляет
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
