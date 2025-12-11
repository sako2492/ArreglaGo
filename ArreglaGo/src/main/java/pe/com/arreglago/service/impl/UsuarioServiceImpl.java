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
		if (obj.getClave() == null || obj.getClave().isBlank()) {
	        throw new IllegalArgumentException("La clave no puede estar vacía");
	    }

	    // Encriptar clave
	    obj.setClave(passwordEncoder.encode(obj.getClave()));

	    // GUARDAR Y RETORNAR
	    return repositorio.save(obj);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity obj, Long id) {
		UsuarioEntity objusuario = repositorio.findById(id).get();
		// Si la nueva clave NO está vacía → encriptar y actualizar
	    if (obj.getClave() != null && !obj.getClave().isBlank()) {
	        objusuario.setClave(passwordEncoder.encode(obj.getClave()));
	    }

	    // Copiar el resto de propiedades excepto la clave y el id
	    BeanUtils.copyProperties(obj, objusuario, "codigo", "clave");

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
	
	@Override
	public UsuarioEntity findByCorreo(String correo){
		 return repositorio.findByCorreo(correo).orElse(null);
	}
	
	@Override
    public UsuarioEntity findByNroDocumento(String nroDocumento) {
        // Usamos .orElse(null) para devolver null si no se encuentra el DNI
        return repositorio.findByNroDocumento(nroDocumento).orElse(null);
    }


	@Override
	public UsuarioEntity login(String correo, String clave) {
	    
	    // 1. Busca el usuario por correo (obtiene el objeto o null)
	    // USO CORRECTO: Llamar al método del servicio, que ya maneja el Optional.
	    UsuarioEntity usuario = this.findByCorreo(correo); 
	    
	    // 2. Verifica que el usuario exista y que la contraseña coincida
	    if (usuario != null && passwordEncoder.matches(clave, usuario.getClave())) {
	        // También podemos verificar que esté activo (estado = true)
	        if (usuario.isEstado()) { 
	            return usuario; // Retorna el objeto completo del usuario
	        }
	    }
	    return null; // Credenciales incorrectas o usuario inactivo
	}
}
