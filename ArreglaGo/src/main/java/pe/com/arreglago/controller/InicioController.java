package pe.com.arreglago.controller;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.com.arreglago.service.CategoriaService;
import pe.com.arreglago.service.ProveedorService;

@Controller
public class InicioController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/menuprincipal")
    public String MostrarMenuPrincipal(Model model) {
    	
        var lista = proveedorService.findAllCustom();
        System.out.println("PROFESIONALES ENCONTRADOS: " + lista.size());

        model.addAttribute("categorias", categoriaService.findAllCustom());
        model.addAttribute("profesionales", proveedorService.findAllCustom());

        // si aún no tienes testimonios, mandamos lista vacía
        model.addAttribute("testimonios", Collections.emptyList());

        return "menuprincipal";
    }
}
