package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ContratacionEntity;
import pe.com.arreglago.repository.ContratacionRepository;
import pe.com.arreglago.service.ContratacionService;

@Service

public class ContratacionServiceImpl implements ContratacionService{

	@Autowired
	private ContratacionRepository repositorio;
	
	@Override
	public List<ContratacionEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ContratacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ContratacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ContratacionEntity add(ContratacionEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ContratacionEntity update(ContratacionEntity obj, Long id) {
		ContratacionEntity objcontratacion = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcontratacion, "codigo");
		return repositorio.save(objcontratacion);
	}

	@Override
	public ContratacionEntity delete(Long id) {
	    ContratacionEntity objcontratacion = repositorio.findById(id).orElse(null);
	    if (objcontratacion != null) {
	        objcontratacion.setEstado("finalizado");
	        return repositorio.save(objcontratacion);
	    }
	    return null;
	}

	@Override
	public ContratacionEntity enable(Long id) {
	    ContratacionEntity objcontratacion = repositorio.findById(id).orElse(null);
	    if (objcontratacion != null) {
	        objcontratacion.setEstado("pendiente");
	        return repositorio.save(objcontratacion);
	    }
	    return null;
	}

}
