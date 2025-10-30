package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.DistritoEntity;

public interface DistritoService {

	List<DistritoEntity> findAll();
	List<DistritoEntity> findAllCustom();
	DistritoEntity findById(Long id); 
	DistritoEntity add(DistritoEntity obj); 
	DistritoEntity update(DistritoEntity obj, Long id); 
	DistritoEntity delete(Long id); 
	DistritoEntity enable(Long id); 
}
