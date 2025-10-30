package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.ContratacionEntity;

public interface ContratacionRepository extends JpaRepository<ContratacionEntity, Long> {

	@Query("select c from ContratacionEntity c where c.estado = 'finalizado'")
	List<ContratacionEntity> findAllCustom();
}
