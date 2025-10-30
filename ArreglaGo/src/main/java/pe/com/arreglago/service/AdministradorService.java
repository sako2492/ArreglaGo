package pe.com.arreglago.service;

import java.util.List;
import pe.com.arreglago.entity.AdministradorEntity;

public interface AdministradorService {
    List<AdministradorEntity> findAll();
    List<AdministradorEntity> findAllCustom();
    AdministradorEntity findById(Long id);
    AdministradorEntity add(AdministradorEntity obj);
    AdministradorEntity update(AdministradorEntity obj, Long id);
    AdministradorEntity delete(Long id);
    AdministradorEntity enable(Long id);
}
