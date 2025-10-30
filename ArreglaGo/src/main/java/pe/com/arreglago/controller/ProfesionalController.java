package pe.com.arreglago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.entity.ProveedorEntity;
import pe.com.arreglago.entity.RolEntity;
import pe.com.arreglago.entity.DistritoEntity;
import pe.com.arreglago.entity.TipoDocumentoEntity;
import pe.com.arreglago.entity.CategoriaEntity;
import pe.com.arreglago.service.UsuarioService;
import pe.com.arreglago.service.ProveedorService;
import pe.com.arreglago.service.CategoriaService;
import pe.com.arreglago.service.DistritoService;
import pe.com.arreglago.service.TipoDocumentoService;

@Controller
public class ProfesionalController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    // ==========================
    // FORMULARIO DE REGISTRO
    // ==========================
    @GetMapping("/profesional/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("categorias", categoriaService.findAllCustom());
        model.addAttribute("distritos", distritoService.findAllCustom());
        model.addAttribute("tiposdocumento", tipoDocumentoService.findAllCustom());
        return "profesional-registro";
    }

    // ==========================
    // PROCESAR EL REGISTRO
    // ==========================
    @PostMapping("/profesional/registro")
    public String registrarProfesional(
            @ModelAttribute UsuarioEntity usuario,
            @RequestParam String experiencia,
            @RequestParam String descripcion,
            @RequestParam Long idCategoria) {

        // 🔹 Recuperar las relaciones desde BD
        Long idDistrito = usuario.getDistrito().getCodigo();
        Long idTipoDoc = usuario.getTipodocumento().getCodigo();

        DistritoEntity distrito = distritoService.findById(idDistrito);
        TipoDocumentoEntity tipoDocumento = tipoDocumentoService.findById(idTipoDoc);
        CategoriaEntity categoria = categoriaService.findById(idCategoria);

        // 🔹 Asignar las relaciones al usuario
        usuario.setDistrito(distrito);
        usuario.setTipodocumento(tipoDocumento);

        // 🔹 Asignar rol profesional (ajusta el ID según tu tabla rol)
        RolEntity rol = new RolEntity();
        rol.setCodigo(3L); // Ejemplo: 3 = PROFESIONAL
        usuario.setRol(rol);

        usuario.setEstado(true);
        usuarioService.add(usuario);

        // 🔹 Crear y vincular proveedor (profesional)
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setUsuario(usuario);
        proveedor.setCategoria(categoria);
        proveedor.setDescripcion(descripcion);
        proveedor.setExperiencia(experiencia);
        proveedor.setEstado(true);

        proveedorService.add(proveedor);

        // 🔹 Redirigir a página de confirmación o login
        return "redirect:/login-opciones";
    }
}
