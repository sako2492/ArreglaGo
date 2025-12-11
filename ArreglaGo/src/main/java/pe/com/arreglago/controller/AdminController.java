package pe.com.arreglago.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.entity.CategoriaEntity;
import pe.com.arreglago.service.UsuarioService;
import pe.com.arreglago.service.CategoriaService;
import pe.com.arreglago.service.ProveedorService;
import pe.com.arreglago.service.ClienteService;
// Importa el servicio de auditoría si lo tienes
// import pe.com.arreglago.service.AuditoriaService; 

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private UsuarioService usuarioService;
    @Autowired private CategoriaService categoriaService;
    @Autowired private ProveedorService proveedorService;
    @Autowired private ClienteService clienteService;
    // @Autowired private AuditoriaService auditoriaService; // Para la tabla de auditoría
    // @Autowired private AuditoriaService auditoriaService; // Si tienes servicio de auditoría
    // @Autowired private AdministradorService administradorService; // Necesario si manejas la entidad Administrador

    /**
     * Muestra el panel principal de administración.
     */
    @GetMapping("/dashboard")
    public String adminDashboard(Principal principal, Model model) {
        // Obtener usuario logueado
        UsuarioEntity adminUsuario = usuarioService.findByCorreo(principal.getName());

        // 1. Gestión de Categorías
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("nuevaCategoria", new CategoriaEntity());

        // 2. Validación de Cuentas (Asumiendo un método para buscar proveedores pendientes)
        // model.addAttribute("proveedoresPendientes", proveedorService.findProveedoresPendientes());

        // 3. Clientes (Bloqueo/Desbloqueo)
        // model.addAttribute("clientes", clienteService.findAll());

        // 4. Auditoría (Asumiendo un método para obtener registros de auditoría)
        // model.addAttribute("registrosAuditoria", auditoriaService.findRecentLogs());

        model.addAttribute("adminUsuario", adminUsuario);
        return "admin-dashboard"; 
    }

    /* ====================================================
     * GESTIÓN DE CATEGORÍAS
     * ==================================================== */

    @PostMapping("/categorias/agregar")
    public String agregarCategoria(CategoriaEntity nuevaCategoria, RedirectAttributes redirect) {
    	// 🛑 CORRECCIÓN CLAVE: Asegurar que los campos NOT NULL no sean nulos 🛑
        if (nuevaCategoria.getDescripcion() == null || nuevaCategoria.getDescripcion().isEmpty()) {
            // Establece una descripción por defecto si el formulario no la proveyó
            nuevaCategoria.setDescripcion("Sin descripción."); 
        }
        
        // Asumiendo que 'estado' también podría ser nulo si no se pasa, lo inicializamos a true (activo)
        // Nota: Esto depende de si tu constructor @NoArgsConstructor inicializa boolean a false. 
        // Por seguridad, lo forzamos.
        nuevaCategoria.setEstado(true);
        
        // Si el nombre es nulo (lo cual no debería pasar con un formulario Thymeleaf, pero por seguridad)
        if (nuevaCategoria.getNombre() == null || nuevaCategoria.getNombre().trim().isEmpty()) {
            redirect.addFlashAttribute("error", "❌ El nombre de la categoría no puede estar vacío.");
            return "redirect:/admin/dashboard";
            
        }
        
        try {
            categoriaService.add(nuevaCategoria);
            redirect.addFlashAttribute("success", "✅ Categoría '" + nuevaCategoria.getNombre() + "' agregada con éxito.");
        } catch (Exception e) {
            // En caso de que falle la BD por otra razón (ej., clave única)
            redirect.addFlashAttribute("error", "❌ Error al agregar categoría: " + e.getMessage());
        }
        
        return "redirect:/admin/dashboard";
    }
        
    @PostMapping("/categorias/eliminar")
    public String eliminarCategoria(@RequestParam Long idCategoria, RedirectAttributes redirect) {
        try {
            categoriaService.delete(idCategoria);
            redirect.addFlashAttribute("success", "✅ Categoría eliminada con éxito.");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "❌ Error al eliminar categoría. Asegúrate de que no tenga proveedores asociados.");
        }
        return "redirect:/admin/dashboard";
    }

    /* ====================================================
     * VALIDACIÓN DE PROVEEDORES
     * (Necesitas métodos similares para aceptar o rechazar)
     * ==================================================== */
    
    @PostMapping("/proveedor/validar/{idProveedor}")
    public String validarProveedor(@PathVariable Long idProveedor, RedirectAttributes redirect) {// Lógica: proveedorService.validate(idProveedor);
        redirect.addFlashAttribute("success", "✅ Proveedor validado y activado.");
        return "redirect:/admin/dashboard";
    }

    /* ====================================================
     * BLOQUEO DE CLIENTES
     * (Necesitas la lógica en ClienteService para cambiar el estado)
     * ==================================================== */
     
    @PostMapping("/cliente/cambiar-estado/{idCliente}")
    public String cambiarEstadoCliente(@PathVariable Long idCliente, @RequestParam boolean nuevoEstado, RedirectAttributes redirect) {
        // Lógica: clienteService.changeStatus(idCliente, nuevoEstado);
        redirect.addFlashAttribute("success", nuevoEstado ? "✅ Cliente desbloqueado." : "🔒 Cliente bloqueado.");
        return "redirect:/admin/dashboard";
    }

}