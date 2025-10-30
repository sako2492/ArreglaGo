package pe.com.arreglago.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name="ServicioEntity")
@Table(name="servicio") 

public class ServicioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_servicio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name = "titulo", length= 150, nullable = false)
	private String titulo;
	@Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
	private String descripcion;
	@Column(name="estado", nullable = false)
	private boolean estado;
	@Column(name = "fecha_publicacion")
	private LocalDateTime fechaPublicacion;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProveedorEntity proveedor;
	
	@PrePersist
    protected void onCreate() {
        this.fechaPublicacion = LocalDateTime.now();
    }
}
