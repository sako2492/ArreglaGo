package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.ProveedorEntity;

public interface ProveedorService {

	List<ProveedorEntity> findAll();
	List<ProveedorEntity> findAllCustom();
	List<ProveedorEntity> findByCategoria(Long idCategoria);
	List<ProveedorEntity> buscarGeneral(String texto);

	ProveedorEntity findById(Long id); 
	ProveedorEntity add(ProveedorEntity obj); 
	ProveedorEntity update(ProveedorEntity obj, Long id); 
	ProveedorEntity delete(Long id); 
	ProveedorEntity enable(Long id);
	ProveedorEntity buscarPorUsuario(Long idUsuario);
	
    // Contador de proveedores por categoría
    Long contarPorCategoria(Long idCategoria);
}
