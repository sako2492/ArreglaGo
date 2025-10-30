package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.SuscripcionEntity;
import pe.com.arreglago.repository.SuscripcionRepository;
import pe.com.arreglago.service.SuscripcionService;

@Service

public class SuscripcionServiceImpl implements SuscripcionService{

	@Autowired
	private SuscripcionRepository repositorio;
	
	@Override
	public List<SuscripcionEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<SuscripcionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public SuscripcionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public SuscripcionEntity add(SuscripcionEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public SuscripcionEntity update(SuscripcionEntity obj, Long id) {
		SuscripcionEntity objsuscripcion = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objsuscripcion, "codigo");
		return repositorio.save(objsuscripcion);
	}

	@Override
	public SuscripcionEntity delete(Long id) {
		SuscripcionEntity objsuscripcion = repositorio.findById(id).get();
		objsuscripcion.setEstado("inactivo");
		return repositorio.save(objsuscripcion);
	}

	@Override
	public SuscripcionEntity enable(Long id) {
		SuscripcionEntity objsuscripcion = repositorio.findById(id).get();
		objsuscripcion.setEstado("activo");
		return repositorio.save(objsuscripcion);
	}
	
}
