package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.DistritoEntity;
import pe.com.arreglago.repository.DistritoRepository;
import pe.com.arreglago.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService{

	@Autowired
	private DistritoRepository repositorio;
	
	@Override
	public List<DistritoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<DistritoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public DistritoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public DistritoEntity add(DistritoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public DistritoEntity update(DistritoEntity obj, Long id) {
		DistritoEntity objdistrito = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdistrito, "codigo");
		return repositorio.save(objdistrito);
	}

	@Override
	public DistritoEntity delete(Long id) {
		DistritoEntity objdistrito = repositorio.findById(id).get();
		objdistrito.setEstado(false);
		return repositorio.save(objdistrito);
	}

	@Override
	public DistritoEntity enable(Long id) {
		DistritoEntity objdistrito = repositorio.findById(id).get();
		objdistrito.setEstado(true);
		return repositorio.save(objdistrito);
	}

}
