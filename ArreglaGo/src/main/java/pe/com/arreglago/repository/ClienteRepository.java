package pe.com.arreglago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.arreglago.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query("SELECT c FROM ClienteEntity c WHERE c.estado = true")
    List<ClienteEntity> findAllCustom();

    @Query("SELECT c FROM ClienteEntity c WHERE c.usuario.codigo = :idUsuario")
    ClienteEntity buscarPorUsuario(@Param("idUsuario") Long idUsuario);
}
