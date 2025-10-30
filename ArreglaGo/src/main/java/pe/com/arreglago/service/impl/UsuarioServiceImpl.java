package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.repository.UsuarioRepository;
import pe.com.arreglago.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;
	
    // Inyectamos el PasswordEncoder definido en SecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UsuarioEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<UsuarioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public UsuarioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public UsuarioEntity add(UsuarioEntity obj) {
		// Encriptar contraseña antes de guardar
        if (obj.getClave() != null && !obj.getClave().isEmpty()) {
            obj.setClave(passwordEncoder.encode(obj.getClave()));
        }
		return repositorio.save(obj);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity obj, Long id) {
		UsuarioEntity objusuario = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objusuario, "codigo");
		return repositorio.save(objusuario);
	}

	@Override
	public UsuarioEntity delete(Long id) {
		UsuarioEntity objusuario = repositorio.findById(id).get();
		objusuario.setEstado(false);
		return repositorio.save(objusuario);
	}

	@Override
	public UsuarioEntity enable(Long id) {
		UsuarioEntity objusuario = repositorio.findById(id).get();
		objusuario.setEstado(true);
		return repositorio.save(objusuario);
	}

}
