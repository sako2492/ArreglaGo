package pe.com.arreglago.service;

import java.util.List;
import pe.com.arreglago.entity.ResenaEntity;

public interface ResenaService {

    ResenaEntity add(ResenaEntity r);
    List<ResenaEntity> listarPorProveedor(Long idProveedor);
    Double promedioPorProveedor(Long idProveedor);
}
