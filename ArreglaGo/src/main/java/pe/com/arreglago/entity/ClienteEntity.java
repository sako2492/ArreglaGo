package pe.com.arreglago.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name="ClienteEntity")
@Table(name="cliente") 

public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private UsuarioEntity usuario;
}
