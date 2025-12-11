package pe.com.arreglago.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.arreglago.entity.ReniecEntity;
import pe.com.arreglago.service.ReniecService;

@RestController
@RequestMapping("/api/dni")

public class ReniecRestController {

	@Autowired
    private ReniecService dniService;
	
	@GetMapping("/buscar")
    public ReniecEntity buscarDni(@RequestParam String numero) {
        return dniService.consultarDni(numero);
    }
}
