package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ProveedorEntity;
import pe.com.arreglago.repository.ProveedorRepository;
import pe.com.arreglago.service.ProveedorService;

@Service

public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository repositorio;
	
	@Override
	public List<ProveedorEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ProveedorEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ProveedorEntity add(ProveedorEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ProveedorEntity update(ProveedorEntity obj, Long id) {
		ProveedorEntity objproveedor = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objproveedor, "codigo");
		return repositorio.save(objproveedor);
	}

	@Override
	public ProveedorEntity delete(Long id) {
		ProveedorEntity objproveedor = repositorio.findById(id).get();
		objproveedor.setEstado(false);
		return null;
	}

	@Override
	public ProveedorEntity enable(Long id) {
		ProveedorEntity objproveedor = repositorio.findById(id).get();
		objproveedor.setEstado(true);
		return null;
	}

}
