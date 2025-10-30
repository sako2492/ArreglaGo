package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.ValoracionEntity;


public interface ValoracionRepository extends JpaRepository<ValoracionEntity, Long>{

	@Query("select v from ValoracionEntity v where v.estado = true")
	List<ValoracionEntity> findAllCustom();
}
