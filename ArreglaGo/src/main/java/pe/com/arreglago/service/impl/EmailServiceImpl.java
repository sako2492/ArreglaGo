package pe.com.arreglago.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pe.com.arreglago.service.EmailService;

@Service

public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender mailSender; 

    @Override
    public void enviarCorreo(String to, String subject, String text) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(text);
        mailSender.send(mensaje);
    }
}
