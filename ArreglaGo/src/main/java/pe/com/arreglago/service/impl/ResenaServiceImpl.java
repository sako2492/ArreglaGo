package pe.com.arreglago.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.ResenaEntity;
import pe.com.arreglago.repository.ResenaRepository;
import pe.com.arreglago.service.ResenaService;

@Service
public class ResenaServiceImpl implements ResenaService {

    @Autowired
    private ResenaRepository repositorio;

    @Override
    public ResenaEntity add(ResenaEntity r) {
        r.setEstado(true);
        return repositorio.save(r);
    }

    @Override
    public List<ResenaEntity> listarPorProveedor(Long idProveedor) {
        return repositorio.listarPorProveedor(idProveedor);
    }

    @Override
    public Double promedioPorProveedor(Long idProveedor) {
        Double promedio = repositorio.promedioPorProveedor(idProveedor);
        return (promedio == null) ? 0.0 : promedio;
    }
}
