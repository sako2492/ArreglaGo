package pe.com.arreglago.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    	// Mapeo para fotos de perfil y registro:
        registry.addResourceHandler("/usuarios/**")
                .addResourceLocations("file:///C:/arreglago/images/"); // La carpeta de fotos de perfil

        // Mapeo para la Galería de trabajos:
        registry.addResourceHandler("/galeria/**")
                .addResourceLocations("file:///C:/arreglago/galeria/"); // La carpeta de la galería
    }

}
