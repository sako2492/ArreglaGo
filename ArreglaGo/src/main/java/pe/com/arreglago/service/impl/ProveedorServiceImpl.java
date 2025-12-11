package pe.com.arreglago.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ProveedorEntity;
import pe.com.arreglago.exception.ResourceNotFoundException;
import pe.com.arreglago.repository.ProveedorRepository;
import pe.com.arreglago.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository repositorio;
	
	@Override
	public List<ProveedorEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ProveedorEntity findById(Long id) {
	    return repositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado: " + id));
	}
	
	@Override
    public List<ProveedorEntity> findByCategoria(Long idCategoria) {
        return repositorio.findByCategoria(idCategoria);
    }
	
	@Override
	public ProveedorEntity add(ProveedorEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}

	@Override
	public ProveedorEntity update(ProveedorEntity obj, Long id) {
	    ProveedorEntity existing = repositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado: " + id));

	    // Solo copiamos los atributos reales del Proveedor
	    existing.setDescripcion(obj.getDescripcion());
	    existing.setExperiencia(obj.getExperiencia());
	    existing.setCategoria(obj.getCategoria());

	    return repositorio.save(existing);
	}

	@Override
	public ProveedorEntity delete(Long id) {
	    ProveedorEntity existing = repositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado: " + id));

	    existing.setEstado(false);
	    return repositorio.save(existing);
	}

	@Override
	public ProveedorEntity enable(Long id) {
	    ProveedorEntity existing = repositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado: " + id));

	    existing.setEstado(true);
	    return repositorio.save(existing);
	}
	
	@Override
	public List<ProveedorEntity> buscarGeneral(String texto) {

	    String[] palabras = texto.toLowerCase().trim().split("\\s+");

	    List<ProveedorEntity> resultados = null;

	    for (String palabra : palabras) {

	        List<ProveedorEntity> parciales = repositorio.buscarCoincidenciaGeneral(palabra);

	        if (resultados == null) {
	            resultados = parciales;
	        } else {
	            resultados.retainAll(parciales); // INTERSECCIÓN
	        }
	    }

	    return resultados == null ? new ArrayList<>() : resultados;
	}
	
	@Override
	public Long contarPorCategoria(Long idCategoria) {
	    return repositorio.contarPorCategoria(idCategoria);
	}
	
	@Override
	public ProveedorEntity buscarPorUsuario(Long idUsuario){
	    return repositorio.buscarPorUsuario(idUsuario);
	}



}
