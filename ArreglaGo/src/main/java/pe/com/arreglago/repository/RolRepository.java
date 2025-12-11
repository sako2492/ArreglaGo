package pe.com.arreglago.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

    @Query("select r from RolEntity r where r.estado = true")
    List<RolEntity> findAllCustom();

    // 🔹 Buscar rol por nombre (sin importar mayúsculas/minúsculas)
    Optional<RolEntity> findByNombreIgnoreCase(String nombre);
}
