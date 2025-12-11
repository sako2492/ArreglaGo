package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ClienteEntity;
import pe.com.arreglago.repository.ClienteRepository;
import pe.com.arreglago.service.ClienteService;

@Service

public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repositorio;

	@Override
	public List<ClienteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ClienteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ClienteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ClienteEntity add(ClienteEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ClienteEntity update(ClienteEntity obj, Long id) {
		ClienteEntity objcliente = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcliente, "codigo");
		return repositorio.save(objcliente);
	}

	@Override
	public ClienteEntity delete(Long id) {
		ClienteEntity objcliente = repositorio.findById(id).get();
		objcliente.setEstado(false);
		return repositorio.save(objcliente);
	}

	@Override
	public ClienteEntity enable(Long id) {
		ClienteEntity objcliente = repositorio.findById(id).get();
		objcliente.setEstado(true);
		return repositorio.save(objcliente);
	}
	
	@Override
	public ClienteEntity buscarPorUsuario(Long idUsuario){
	    return repositorio.buscarPorUsuario(idUsuario);
	}


	
}
