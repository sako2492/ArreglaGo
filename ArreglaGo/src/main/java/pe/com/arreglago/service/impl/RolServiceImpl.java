package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.RolEntity;
import pe.com.arreglago.repository.RolRepository;
import pe.com.arreglago.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repositorio;

    @Override
    public List<RolEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public RolEntity findById(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + id));
    }

    @Override
    public RolEntity findByNombre(String nombre) {
        return repositorio.findByNombreIgnoreCase(nombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombre));
    }

    @Override
    public RolEntity add(RolEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public RolEntity update(RolEntity obj, Long id) {
        RolEntity objrol = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + id));
        BeanUtils.copyProperties(obj, objrol, "codigo");
        return repositorio.save(objrol);
    }

    @Override
    public RolEntity delete(Long id) {
        RolEntity objrol = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + id));
        objrol.setEstado(false);
        return repositorio.save(objrol);
    }

    @Override
    public RolEntity enable(Long id) {
        RolEntity objrol = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + id));
        objrol.setEstado(true);
        return repositorio.save(objrol);
    }
}
