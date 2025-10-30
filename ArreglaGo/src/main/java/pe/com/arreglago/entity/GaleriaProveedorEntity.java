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

@Entity(name="GaleriaProveedorEntity")
@Table(name="galeriaproveedor") 


public class GaleriaProveedorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_imagen")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name = "url_imagen", length = 255, nullable = false)
	private String urlImagen;	
	@Column(name="descripcion", length = 200)
	private String descripcion;
	@Column(name = "fecha_subida")
	private LocalDateTime  fechaSubida;	
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProveedorEntity proveedor;
	
	@PrePersist
    protected void onCreate() {
        this.fechaSubida = LocalDateTime.now();
    }
}

