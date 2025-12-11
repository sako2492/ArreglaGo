package pe.com.arreglago.service;

import java.math.BigDecimal;
import java.util.List;

import pe.com.arreglago.entity.SuscripcionEntity;

public interface SuscripcionService {

	List<SuscripcionEntity> findAll();
	List<SuscripcionEntity> findAllCustom();
	SuscripcionEntity findById(Long id); 
	SuscripcionEntity add(SuscripcionEntity obj); 
	SuscripcionEntity update(SuscripcionEntity obj, Long id); 
	SuscripcionEntity delete(Long id); 
	SuscripcionEntity enable(Long id);
	boolean existeSuscripcionActiva(Long idProveedor); // 👈 Añadir este método
	// Método para registrar la suscripción exitosa
    SuscripcionEntity registrarSuscripcionExitosa(Integer idProveedor, BigDecimal monto, String metodoPago);
}
