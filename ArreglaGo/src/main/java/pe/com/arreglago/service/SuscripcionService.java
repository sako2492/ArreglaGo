package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.SuscripcionEntity;

public interface SuscripcionService {

	List<SuscripcionEntity> findAll();
	List<SuscripcionEntity> findAllCustom();
	SuscripcionEntity findById(Long id); 
	SuscripcionEntity add(SuscripcionEntity obj); 
	SuscripcionEntity update(SuscripcionEntity obj, Long id); 
	SuscripcionEntity delete(Long id); 
	SuscripcionEntity enable(Long id);
}
