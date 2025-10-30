package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ValoracionEntity;
import pe.com.arreglago.repository.ValoracionRepository;
import pe.com.arreglago.service.ValoracionService;

@Service
public class ValoracionServiceImpl implements ValoracionService{

	@Autowired
	private ValoracionRepository repositorio;
	
	@Override
	public List<ValoracionEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ValoracionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ValoracionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ValoracionEntity add(ValoracionEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ValoracionEntity update(ValoracionEntity obj, Long id) {
		ValoracionEntity objvaloracion = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objvaloracion, "codigo");
		return repositorio.save(objvaloracion);
	}

	@Override
	public ValoracionEntity delete(Long id) {
		ValoracionEntity objvaloracion = repositorio.findById(id).get();
		objvaloracion.setEstado(false);
		return repositorio.save(objvaloracion);
	}

	@Override
	public ValoracionEntity enable(Long id) {
		ValoracionEntity objvaloracion = repositorio.findById(id).get();
		objvaloracion.setEstado(true);
		return repositorio.save(objvaloracion);
	}

}
