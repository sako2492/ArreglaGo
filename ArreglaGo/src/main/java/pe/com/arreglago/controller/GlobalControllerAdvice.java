package pe.com.arreglago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.com.arreglago.entity.CategoriaEntity;
import pe.com.arreglago.service.CategoriaService;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private CategoriaService categoriaService;

    @ModelAttribute("categorias")
    public List<CategoriaEntity> categoriasGlobales() {
        return categoriaService.findAllCustom();
    }
}
