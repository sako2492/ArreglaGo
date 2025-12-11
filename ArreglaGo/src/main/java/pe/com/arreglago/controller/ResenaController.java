package pe.com.arreglago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.arreglago.entity.ContratacionEntity;
import pe.com.arreglago.entity.ResenaEntity;
import pe.com.arreglago.service.ContratacionService;
import pe.com.arreglago.service.ResenaService;

@Controller
public class ResenaController {

    @Autowired
    private ContratacionService contratacionService;

    @Autowired
    private ResenaService resenaService;

    @PostMapping("/resena/guardar")
    public String guardarResena(@RequestParam Long idContratacion,
                                @ModelAttribute ResenaEntity resena) {

        ContratacionEntity contratacion = contratacionService.findById(idContratacion);

        if (!contratacion.getEstado().equals("finalizada")) {
            throw new IllegalStateException("No puedes valorar un servicio no finalizado.");
        }

        resena.setProveedor(contratacion.getProveedor());
        resenaService.add(resena);

        return "redirect:/cliente/mis-contrataciones";
    }
    
    
}

