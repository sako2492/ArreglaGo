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

@Entity(name="ValoracionEntity")
@Table(name="valoracion") 

public class ValoracionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_valoracion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name = "puntuacion", nullable = false)
	private byte puntuacion;	
	@Column(name="comentario", length = 300)
	private String comentario;
	@Column(name = "fecha")
	private LocalDateTime fecha;	
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_contratacion")
	private ContratacionEntity contratacion;
	
	@PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }
}