package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.GaleriaProveedorEntity;
import pe.com.arreglago.repository.GaleriaProveedorRepository;
import pe.com.arreglago.service.GaleriaProveedorService;

@Service

public class GaleriaProveedorServiceImpl implements GaleriaProveedorService{

	@Autowired
	private GaleriaProveedorRepository repositorio;
	
	@Override
	public List<GaleriaProveedorEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<GaleriaProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public GaleriaProveedorEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public GaleriaProveedorEntity add(GaleriaProveedorEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public GaleriaProveedorEntity update(GaleriaProveedorEntity obj, Long id) {
		GaleriaProveedorEntity objgaleria = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objgaleria, "codigo");
		return repositorio.save(objgaleria);
	}

	@Override
	public GaleriaProveedorEntity delete(Long id) {
		GaleriaProveedorEntity objgaleria = repositorio.findById(id).get();
		objgaleria.setEstado(false);
		return repositorio.save(objgaleria);
	}

	@Override
	public GaleriaProveedorEntity enable(Long id) {
		GaleriaProveedorEntity objgaleria = repositorio.findById(id).get();
		objgaleria.setEstado(true);
		return repositorio.save(objgaleria);
	}

}
