package pe.com.arreglago.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.arreglago.entity.AdministradorEntity;
import pe.com.arreglago.repository.AdministradorRepository;
import pe.com.arreglago.service.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository repositorio;

    @Override
    public List<AdministradorEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<AdministradorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public AdministradorEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public AdministradorEntity add(AdministradorEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public AdministradorEntity update(AdministradorEntity obj, Long id) {
        AdministradorEntity admin = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, admin, "codigo");
        return repositorio.save(admin);
    }

    @Override
    public AdministradorEntity delete(Long id) {
        AdministradorEntity admin = repositorio.findById(id).get();
        admin.setEstado(false);
        return repositorio.save(admin);
    }

    @Override
    public AdministradorEntity enable(Long id) {
        AdministradorEntity admin = repositorio.findById(id).get();
        admin.setEstado(true);
        return repositorio.save(admin);
    }
}
