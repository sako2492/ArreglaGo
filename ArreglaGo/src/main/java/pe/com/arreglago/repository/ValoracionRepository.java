package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.arreglago.entity.ValoracionEntity;

public interface ValoracionRepository extends JpaRepository<ValoracionEntity, Long> {

    @Query("SELECT v FROM ValoracionEntity v WHERE v.estado = true")
    List<ValoracionEntity> findAllCustom();

    // --------------------------------------------------------
    // LISTAR VALORACIONES HECHAS A UN PROFESIONAL
    // --------------------------------------------------------
    @Query("""
        SELECT v FROM ValoracionEntity v
        JOIN v.contratacion c
        WHERE c.proveedor.codigo = :idProveedor
        ORDER BY v.fecha DESC
        """)
    List<ValoracionEntity> listarPorProveedor(Long idProveedor);

    // --------------------------------------------------------
    // LISTAR VALORACIONES HECHAS POR UN CLIENTE
    // --------------------------------------------------------
    @Query("""
        SELECT v FROM ValoracionEntity v
        JOIN v.contratacion c
        WHERE c.cliente.codigo = :idCliente
        ORDER BY v.fecha DESC
        """)
    List<ValoracionEntity> listarPorCliente(Long idCliente);

    // --------------------------------------------------------
    // PROMEDIO DE PUNTUACIÓN DEL PROFESIONAL
    // --------------------------------------------------------
    @Query("""
        SELECT AVG(v.puntuacion) FROM ValoracionEntity v
        JOIN v.contratacion c
        WHERE c.proveedor.codigo = :idProveedor
        """)
    Double promedioProveedor(Long idProveedor);
}
