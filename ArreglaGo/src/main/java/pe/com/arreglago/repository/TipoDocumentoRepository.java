package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long>{

	@Query("select t from TipoDocumentoEntity t where t.estado = true")
	List<TipoDocumentoEntity> findAllCustom();
}
