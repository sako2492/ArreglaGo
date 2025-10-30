package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.ValoracionEntity;


public interface ValoracionService {

	List<ValoracionEntity> findAll();
	List<ValoracionEntity> findAllCustom();
	ValoracionEntity findById(Long id); 
	ValoracionEntity add(ValoracionEntity obj); 
	ValoracionEntity update(ValoracionEntity obj, Long id); 
	ValoracionEntity delete(Long id); 
	ValoracionEntity enable(Long id); 
}
