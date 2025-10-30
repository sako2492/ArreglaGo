package pe.com.arreglago.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name="SuscripcionEntity")
@Table(name="suscripcion") 

public class SuscripcionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_suscripcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name="fecha_fin", nullable = false)
	private LocalDate fechaFin;
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;	
	@Column(name = "estado", length = 20, nullable = false)
	private String estado;
	@Column(name="monto", precision = 10, scale = 2)
	private BigDecimal monto;
	@Column(name="metodo_pago", length = 50)
	private String metodoPago;
		
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProveedorEntity proveedor;
}
