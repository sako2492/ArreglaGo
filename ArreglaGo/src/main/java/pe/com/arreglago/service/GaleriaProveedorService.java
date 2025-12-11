package pe.com.arreglago.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.com.arreglago.entity.GaleriaProveedorEntity;
import pe.com.arreglago.entity.ProveedorEntity;

public interface GaleriaProveedorService {

	List<GaleriaProveedorEntity> findAll();
	List<GaleriaProveedorEntity> findAllCustom();
	GaleriaProveedorEntity findById(Long id); 
	GaleriaProveedorEntity add(GaleriaProveedorEntity obj); 
	GaleriaProveedorEntity update(GaleriaProveedorEntity obj, Long id); 
	GaleriaProveedorEntity delete(Long id); 
	GaleriaProveedorEntity enable(Long id);
	
	List<GaleriaProveedorEntity> listarPorProveedor(Long idProveedor);
	    
	    GaleriaProveedorEntity addImagen(
	        ProveedorEntity proveedor, 
	        String descripcion, 
	        MultipartFile archivo
	    ) throws IOException;
	    
	    void deleteImagen(Long idImagen);
}
