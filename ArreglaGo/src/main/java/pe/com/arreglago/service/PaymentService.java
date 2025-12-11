package pe.com.arreglago.service;

import java.math.BigDecimal;

public interface PaymentService {
	
	/**
     * Simula el procesamiento de un pago de suscripción con Stripe.
     * @param token El token ficticio de la tarjeta o del método de pago.
     * @param amount El monto a cobrar.
     * @param idProveedor El ID del proveedor que se suscribe.
     * @return true si el pago fue exitoso, false en caso contrario.
     */
    boolean processSubscriptionPayment(String token, BigDecimal amount, Integer idProveedor);

}
