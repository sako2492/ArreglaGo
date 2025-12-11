package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.arreglago.entity.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>  {

    @Query("select p from ProveedorEntity p where p.estado = true")
    List<ProveedorEntity> findAllCustom();

    // 🔹 proveedores por categoría (solo activos)
    @Query("select p from ProveedorEntity p where p.estado = true and p.categoria.codigo = :idCategoria")
    List<ProveedorEntity> findByCategoria(Long idCategoria);
    
    // metodo de busqueda de profesionales y categorias
    @Query("""
    		SELECT p FROM ProveedorEntity p
    		WHERE p.estado = true AND (
    		   LOWER(p.usuario.nombre) LIKE %:texto%
    		   OR LOWER(p.usuario.apellidoPaterno) LIKE %:texto%
    		   OR LOWER(p.categoria.nombre) LIKE %:texto%
    		)
    		""")
    		List<ProveedorEntity> buscarCoincidenciaGeneral(@Param("texto") String texto);
    //Contador de profesionales por categoria
    @Query("SELECT COUNT(p) FROM ProveedorEntity p WHERE p.categoria.codigo = :idCategoria AND p.estado = true")
    Long contarPorCategoria(Long idCategoria);

    @Query("SELECT p FROM ProveedorEntity p WHERE p.usuario.codigo = :idUsuario")
    ProveedorEntity buscarPorUsuario(@Param("idUsuario") Long idUsuario);



}
