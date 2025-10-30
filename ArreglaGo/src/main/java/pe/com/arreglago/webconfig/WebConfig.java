package pe.com.arreglago.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Configuramos el cargador de plantillas Thymeleaf
    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        var templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");        // carpeta de vistas (src/main/resources/templates)
        templateResolver.setSuffix(".html");            // extensión de las vistas
        templateResolver.setTemplateMode("HTML5");      // modo de plantilla
        templateResolver.setCharacterEncoding("UTF-8"); // soporte para caracteres especiales
        templateResolver.setCacheable(false);           // desactivar cache en desarrollo
        return templateResolver;
    }

    // Configuramos el motor de plantillas
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    // Configuramos el resolvedor de vistas
    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    // Permitimos acceso a recursos estáticos (CSS, JS, imágenes)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/"); // carpeta src/main/resources/static
    }
}