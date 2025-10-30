package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.TipoDocumentoEntity;
import pe.com.arreglago.repository.TipoDocumentoRepository;
import pe.com.arreglago.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository repositorio;
	
	@Override
	public List<TipoDocumentoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoDocumentoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoDocumentoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
		TipoDocumentoEntity objdocumento = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdocumento, "codigo");
		return repositorio.save(objdocumento);
	}

	@Override
	public TipoDocumentoEntity delete(Long id) {
		TipoDocumentoEntity objdocumento = repositorio.findById(id).get();
		objdocumento.setEstado(false);
		return repositorio.save(objdocumento);
	}

	@Override
	public TipoDocumentoEntity enable(Long id) {
		TipoDocumentoEntity objdocumento = repositorio.findById(id).get();
		objdocumento.setEstado(true);
		return repositorio.save(objdocumento);
	}

}
