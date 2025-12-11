package pe.com.arreglago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.arreglago.entity.ClienteEntity;
import pe.com.arreglago.entity.RolEntity;
import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.service.ClienteService;
import pe.com.arreglago.service.DistritoService;
import pe.com.arreglago.service.TipoDocumentoService;
import pe.com.arreglago.service.UsuarioService;

@Controller
public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Mostrar formulario de registro
    @GetMapping("/cliente/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("tiposdocumento", tipoDocumentoService.findAll());
        model.addAttribute("distritos", distritoService.findAll());
        return "cliente-registro"; // apunta al HTML cliente-registro.html
    }

    // Procesar formulario de registro
    @PostMapping("/cliente/registro")
    public String registrarCliente(@ModelAttribute UsuarioEntity usuario) {

        // Encriptar clave
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        usuario.setEstado(true);

        // Asignar rol CLIENTE (asumiendo que existe en tu tabla rol con id 3, ajusta según tu BD)
        RolEntity rolCliente = new RolEntity();
        rolCliente.setCodigo(2L); // Ejemplo: 2 = CLIENTE
        usuario.setRol(rolCliente);

        // Guardar usuario primero
        UsuarioEntity nuevoUsuario = usuarioService.add(usuario);

        // Crear cliente asociado
        ClienteEntity cliente = new ClienteEntity();
        cliente.setUsuario(nuevoUsuario);
        cliente.setEstado(true);
        clienteService.add(cliente);

        return "redirect:/login-opciones";
    }
}
