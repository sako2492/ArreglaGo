package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.CategoriaEntity;

public interface CategoriaService {

	List<CategoriaEntity> findAll();
	List<CategoriaEntity> findAllCustom();
	CategoriaEntity findById(Long id); 
	CategoriaEntity add(CategoriaEntity obj); 
	CategoriaEntity update(CategoriaEntity obj, Long id); 
	CategoriaEntity delete(Long id); 
	CategoriaEntity enable(Long id);
}
