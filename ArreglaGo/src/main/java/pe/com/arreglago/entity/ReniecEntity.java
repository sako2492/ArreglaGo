package pe.com.arreglago.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class ReniecEntity {

	// Mapea el campo 'document_number' del JSON al campo Java 'numeroDocumento'
			@JsonProperty("document_number")
			private String numeroDocumento;
		    
		    // Mapea 'first_name' del JSON a 'nombres'
		    @JsonProperty("first_name")
		    private String nombres;
		    
		    // Mapea 'first_last_name' del JSON a 'apellidoPaterno'
		    @JsonProperty("first_last_name")
		    private String apellidoPaterno;
		    
		    // Mapea 'second_last_name' del JSON a 'apellidoMaterno'
		    @JsonProperty("second_last_name")
		    private String apellidoMaterno;
		    
		    // Mapea 'full_name' del JSON a 'nombreCompleto'
		    @JsonProperty("full_name")
		    private String nombreCompleto;
}
