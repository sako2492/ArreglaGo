package pe.com.arreglago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired	
	private UsuarioService usuarioService;
	
	@GetMapping("/index")
	public String login() {
		return "index"; // archivo login.html
	}

	 // 🔹 Página de selección de tipo de usuario
	 @GetMapping("/login-opciones")
	 public String mostrarOpcionesLogin() {
	 	 return "login-opciones"; // busca en src/main/resources/templates/login-opciones.html
	 }

	// ========================== //
	// ⬇️ PROCESAR EL FORMULARIO DE LOGIN ⬇️
	// ========================== //

	 
	 
	 
	
	// ========================== //
	// ⬇️ CERRAR SESIÓN ⬇️
	// ========================== //
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// Invalida (destruye) la sesión de HTTP. Esto elimina el atributo 'usuarioLogueado'.
		session.invalidate(); 
		
		// Redirige a la página de login
		return "redirect:/index"; 
	}
}
