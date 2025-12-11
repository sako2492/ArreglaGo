package pe.com.arreglago.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import pe.com.arreglago.service.PaymentService;

@Service
public class StripePaymentService implements PaymentService {
	    
	    // Este valor simularía el monto de la suscripción (ej: S/150.00)
	    private static final BigDecimal SUBSCRIPTION_AMOUNT = new BigDecimal("150.00");

	    @Override
	    public boolean processSubscriptionPayment(String token, BigDecimal amount, Integer idProveedor) {
	        System.out.println("--- SIMULACIÓN DE PAGO STRIPE ---");
	        System.out.println("Proveedor ID: " + idProveedor);
	        System.out.println("Monto Esperado: " + SUBSCRIPTION_AMOUNT);
	        System.out.println("Monto Recibido: " + amount);
	        System.out.println("Token de Pago (Ficticio): " + token);
	        
	        // *** LÓGICA FICTICIA ***
	        // En una implementación real, aquí se usaría la API de Stripe.
	        if (amount.compareTo(SUBSCRIPTION_AMOUNT) >= 0) {
	            System.out.println("Resultado: PAGO EXITOSO");
	            return true; // Simula un pago exitoso
	        } else {
	            System.out.println("Resultado: PAGO FALLIDO - Monto insuficiente");
	            return false; // Simula un pago fallido
	        }
	    
	}

}
