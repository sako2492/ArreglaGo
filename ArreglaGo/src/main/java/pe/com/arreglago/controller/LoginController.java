package pe.com.arreglago.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Página de login que usará Spring Security
    @GetMapping("/login")
    public String login() {
        return "index";   // index.html
    }

    // Página de selección de tipo de registro
    @GetMapping("/login-opciones")
    public String mostrarOpcionesLogin() {
        return "login-opciones";
    }

    @GetMapping("/login-profesional")
    public String loginProfesional() {
        return "login-profesional";
    }

    @GetMapping("/login-cliente")
    public String loginCliente() {
        return "login-cliente";
    }

    @GetMapping("/login-admin")
    public String loginAdmin() {
        return "login-admin";
    }
}
