package pe.com.arreglago.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(

                    // === PÁGINAS PÚBLICAS ===
                    "/", 
                    "/inicio",
                    "/menuprincipal",
                    "/login-opciones",
                    "/profesional/registro",
                    "/cliente/registro",
                    "/administrador/registro",
                    "/categoria/**",
                    "/proveedores/**",

                    // === RECURSOS ESTÁTICOS ===
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/static/**",
                    "/favicon.ico"

                ).permitAll()

                .anyRequest().permitAll() // TODO público por ahora
            )

            .csrf(csrf -> csrf.disable())

            // USAMOS login-opciones COMO PÁGINA DE LOGIN
            .formLogin(form -> form
                .loginPage("/login-opciones")
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/menuprincipal")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
