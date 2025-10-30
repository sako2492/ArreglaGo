package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.RolEntity;


public interface RolService {

	List<RolEntity> findAll();
	List<RolEntity> findAllCustom();
	RolEntity findById(Long id); 
	RolEntity add(RolEntity obj); 
	RolEntity update(RolEntity obj, Long id); 
	RolEntity delete(Long id); 
	RolEntity enable(Long id);
}
