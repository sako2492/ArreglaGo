package pe.com.arreglago.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.arreglago.entity.AdministradorEntity;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {

    @Query("select a from AdministradorEntity a where a.estado = true")
    List<AdministradorEntity> findAllCustom();
}
