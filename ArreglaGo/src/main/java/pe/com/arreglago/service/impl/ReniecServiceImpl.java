package pe.com.arreglago.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import pe.com.arreglago.entity.ReniecEntity;
import pe.com.arreglago.service.ReniecService;

@Service

public class ReniecServiceImpl  implements ReniecService {

	// 1. URL DE LA API DECOLECTA
			private final String URL_BASE = "https://api.decolecta.com/v1/reniec/dni?numero=";
		    
			// 2. IMPORTANTE: El token debe estar en una sola línea sin espacios ni saltos de línea al inicio/final.
		    private static final String RAW_TOKEN = "sk_12193.FlmO5YlO139rJWl6RldTJYwDyr7E9sIp"; // Token en crudo
			private static final String TOKEN = RAW_TOKEN.trim(); // Se aplica trim() para seguridad
			
			@Override
			public ReniecEntity consultarDni(String dni) {
		        
		        // Configuración de la Cabecera (Headers)
		        HttpHeaders headers = new HttpHeaders();
		        headers.set("Content-Type", "application/json");
		        headers.set("Authorization", "Bearer " + TOKEN);

		        // Entidad HTTP que incluye las cabeceras
		        HttpEntity<String> entity = new HttpEntity<>(headers);
		        
				try {
					RestTemplate restTemplate = new RestTemplate();
					
					
					// 🛑 DEBUG: Imprimimos la URL que intentamos consultar
		            System.out.println("DEBUG RENIEC: Intentando consultar DNI " + dni + " en: " + URL_BASE + dni);
					
		            
		            // Usamos exchange para enviar el request con las cabeceras de autorización
		            ResponseEntity<ReniecEntity> response = restTemplate.exchange(
		                URL_BASE + dni, 
		                HttpMethod.GET, 
		                entity, 
		                ReniecEntity.class
		            );
		            
		            // Si la respuesta es 200 OK, devolvemos el cuerpo
		            return response.getBody();
		            
				} catch (HttpClientErrorException e) {
									// Captura errores HTTP del lado del servidor (4xx o 5xx: Token inválido, DNI no encontrado)
								System.err.println("❌ ERROR API HTTP. Código: " + e.getStatusCode() + " | Cuerpo: " + e.getResponseBodyAsString());
								return null;
					        } catch (ResourceAccessException e) {
					            // Captura errores de CONEXIÓN (DNS, Firewall, Timeout)
					            System.err.println("❌ ERROR DE CONEXIÓN. No se pudo acceder a la API. Mensaje: " + e.getMessage());
					            return null;
					        } catch (Exception e) {
					        	// Captura otros errores (mapeo, etc.)
					        	System.err.println("❌ ERROR GENERAL AL CONSULTAR RENIEC: " + e.getMessage());
								return null;
							}
						}
}
