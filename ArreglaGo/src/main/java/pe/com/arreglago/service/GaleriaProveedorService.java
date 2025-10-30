package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.GaleriaProveedorEntity;

public interface GaleriaProveedorService {

	List<GaleriaProveedorEntity> findAll();
	List<GaleriaProveedorEntity> findAllCustom();
	GaleriaProveedorEntity findById(Long id); 
	GaleriaProveedorEntity add(GaleriaProveedorEntity obj); 
	GaleriaProveedorEntity update(GaleriaProveedorEntity obj, Long id); 
	GaleriaProveedorEntity delete(Long id); 
	GaleriaProveedorEntity enable(Long id);
}
