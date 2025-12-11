package pe.com.arreglago.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.arreglago.entity.UsuarioEntity;
import pe.com.arreglago.repository.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String rolNombre = usuario.getRol().getNombre(); // "CLIENTE", "PROFESIONAL", "Administrador", etc.
        String autoridad = "ROLE_" + rolNombre.toUpperCase(); // => ROLE_CLIENTE, ROLE_PROFESIONAL

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getClave())
                .authorities(autoridad)
                .build();
    }
}
