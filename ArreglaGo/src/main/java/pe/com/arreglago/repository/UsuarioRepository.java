package pe.com.arreglago.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	@Query("SELECT u FROM UsuarioEntity u WHERE u.estado = true")
    List<UsuarioEntity> findAllCustom();
	
	Optional<UsuarioEntity> findByCorreo(String correo);
	
	Optional<UsuarioEntity> findByNroDocumento(String nroDocumento); // Buscar por número de documento de identidad (DNI)
}
