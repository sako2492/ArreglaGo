package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.GaleriaProveedorEntity;

public interface GaleriaProveedorRepository extends JpaRepository<GaleriaProveedorEntity, Long> {

	@Query("select g from GaleriaProveedorEntity g where g.estado = true")
	List<GaleriaProveedorEntity> findAllCustom();
}
