package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.GaleriaProveedorEntity;

public interface GaleriaProveedorRepository extends JpaRepository<GaleriaProveedorEntity, Long> {

	/**
     * Busca todas las imágenes activas de un proveedor específico.
     */
    @Query("SELECT g FROM GaleriaProveedorEntity g WHERE g.proveedor.codigo = :idProveedor AND g.estado = true ORDER BY g.fechaSubida DESC")
    List<GaleriaProveedorEntity> findByProveedorAndEstadoActivo(Long idProveedor);
}