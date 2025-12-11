package pe.com.arreglago.service;

import java.util.List;

import pe.com.arreglago.entity.ContratacionEntity;

public interface ContratacionService {

	List<ContratacionEntity> findAll();
	List<ContratacionEntity> findAllCustom();
	ContratacionEntity findById(Long id); 
	ContratacionEntity add(ContratacionEntity obj); 
	ContratacionEntity update(ContratacionEntity obj, Long id); 
	ContratacionEntity delete(Long id); 
	ContratacionEntity enable(Long id);
	
    ContratacionEntity cambiarEstado(Long id, String estado);
    List<ContratacionEntity> listarPorCliente(Long idCliente);
    List<ContratacionEntity> listarPorProveedor(Long idProveedor);
    
    List<ContratacionEntity> listarDetalleCliente(Long idCliente);
    List<ContratacionEntity> listarDetalleProveedor(Long idProveedor);
}
