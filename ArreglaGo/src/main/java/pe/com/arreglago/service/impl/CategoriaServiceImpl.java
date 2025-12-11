package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.CategoriaEntity;
import pe.com.arreglago.repository.CategoriaRepository;
import pe.com.arreglago.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository repositorio; 
	
	@Override
	public List<CategoriaEntity> findAll() {
		return repositorio.findAllCustom();
	}

	@Override
	public List<CategoriaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public CategoriaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public CategoriaEntity add(CategoriaEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public CategoriaEntity update(CategoriaEntity obj, Long id) {
		CategoriaEntity objcategoria = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcategoria, "codigo");
		return repositorio.save(objcategoria);
	}

	@Override
	public CategoriaEntity delete(Long id) {
		CategoriaEntity objcategoria = repositorio.findById(id).get();
		objcategoria.setEstado(false);
		return repositorio.save(objcategoria);
	}

	@Override
	public CategoriaEntity enable(Long id) {
		CategoriaEntity objcategoria = repositorio.findById(id).get();
		objcategoria.setEstado(true);
		return repositorio.save(objcategoria);
	}

}
