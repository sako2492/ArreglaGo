package pe.com.arreglago.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	 // 🔹 Página de selección de tipo de usuario
    @GetMapping("/login-opciones")
    public String mostrarOpcionesLogin() {
        return "login-opciones"; // busca en src/main/resources/templates/login-opciones.html
    }

    // 🔹 (Opcional) Vistas para cada tipo de login
    @GetMapping("/login-profesional")
    public String loginProfesional() {
        return "login-profesional"; // puedes crear esta plantilla después
    }

    @GetMapping("/login-cliente")
    public String loginCliente() {
        return "login-cliente"; // puedes crear esta plantilla después
    }

    @GetMapping("/login-admin")
    public String loginAdmin() {
        return "login-admin"; // puedes crear esta plantilla después
    }
}
