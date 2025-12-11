package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.UsuarioEntity;

public interface UsuarioService {

	List<UsuarioEntity> findAll();
	List<UsuarioEntity> findAllCustom();
	UsuarioEntity findById(Long id); 
	UsuarioEntity add(UsuarioEntity obj); 
	UsuarioEntity update(UsuarioEntity obj, Long id); 
	UsuarioEntity delete(Long id); 
	UsuarioEntity enable(Long id);
	UsuarioEntity findByCorreo(String correo);
	UsuarioEntity findByNroDocumento(String nroDocumento);
	UsuarioEntity login(String correo, String clave);
	}
