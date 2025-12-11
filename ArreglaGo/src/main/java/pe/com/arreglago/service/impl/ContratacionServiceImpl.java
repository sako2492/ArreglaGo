package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.arreglago.entity.ContratacionEntity;
import pe.com.arreglago.repository.ContratacionRepository;
import pe.com.arreglago.service.ContratacionService;

@Service
@Transactional
public class ContratacionServiceImpl implements ContratacionService {

    @Autowired
    private ContratacionRepository repositorio;

    // ----------------------------------------------------
    // CRUD BÁSICO
    // ----------------------------------------------------
    @Override
    public List<ContratacionEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ContratacionEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ContratacionEntity findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    /*
    @Override
    public ContratacionEntity add(ContratacionEntity obj) {
        return repositorio.save(obj);
    }
    */

    @Override
    @Transactional
    public ContratacionEntity add(ContratacionEntity obj) {
        if (obj.getCliente() == null) {
            System.err.println("❌ ERROR: El objeto Cliente es NULO. NO se puede guardar.");
            throw new RuntimeException("Cliente NULO en Contratación.");
        }
        if (obj.getProveedor() == null) {
            System.err.println("❌ ERROR: El objeto Proveedor es NULO. NO se puede guardar.");
            throw new RuntimeException("Proveedor NULO en Contratación.");
        }

        try {
            return repositorio.save(obj);
        } catch (Exception e) {
            // Este es el catch de DB/JPA
            System.err.println("❌❌ FATAL ERROR DE PERSISTENCIA (Contratacion):");
            e.printStackTrace();
            throw new RuntimeException("Fallo en la persistencia de Contratación", e);
        }
    }
    
    
    @Override
    public List<ContratacionEntity> listarPorCliente(Long idCliente) {
        // Usamos el método seguro
        return repositorio.listarDetalleCliente(idCliente);
    }

    @Override
    public List<ContratacionEntity> listarPorProveedor(Long idProveedor) {
        // Usamos el método seguro
        return repositorio.listarDetalleProveedor(idProveedor);
    }
    // ----------------------------------------------------
    // NUEVOS MÉTODOS DE DETALLE
    // ----------------------------------------------------
    @Override
    public List<ContratacionEntity> listarDetalleCliente(Long idCliente) {
        return repositorio.listarDetalleCliente(idCliente);
    }
    @Override
    public List<ContratacionEntity> listarDetalleProveedor(Long idProveedor) {
        return repositorio.listarDetalleProveedor(idProveedor);
    }

    // ----------------------------------------------------
    // UPDATE — No sobrescribe ID ni campos críticos
    // ----------------------------------------------------
    @Override
    public ContratacionEntity update(ContratacionEntity obj, Long id) {
        ContratacionEntity actual = repositorio.findById(id).orElse(null);

        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, 
                "codigo", "id", "cliente", "proveedor", "fechaReserva");

            return repositorio.save(actual);
        }
        return null;
    }

    // ----------------------------------------------------
    // DELETE — No elimina, solo cambia estado a "finalizada"
    // ----------------------------------------------------
    @Override
    public ContratacionEntity delete(Long id) {
        ContratacionEntity c = repositorio.findById(id).orElse(null);
        if (c != null) {
            c.setEstado("finalizada");
            return repositorio.save(c);
        }
        return null;
    }

    // ----------------------------------------------------
    // REACTIVAR CONTRATACIÓN
    // ----------------------------------------------------
    @Override
    public ContratacionEntity enable(Long id) {
        ContratacionEntity c = repositorio.findById(id).orElse(null);
        if (c != null) {
            c.setEstado("pendiente");
            return repositorio.save(c);
        }
        return null;
    }

    // ----------------------------------------------------
    // CAMBIAR ESTADO GENERAL
    // ----------------------------------------------------
    @Override
    public ContratacionEntity cambiarEstado(Long id, String estado) {
        ContratacionEntity c = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Contratación no encontrada"));

        c.setEstado(estado);
        return repositorio.save(c);
    }
}