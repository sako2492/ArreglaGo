package pe.com.arreglago.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name="CategoriaEntity")
@Table(name="categoria") 

public class CategoriaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name="nombre", length = 150, nullable = false)
	private String nombre;
	@Column(name="descripcion", length = 300, nullable = false)
	private String descripcion;
	@Column (name = "estado", nullable = false)
	private boolean estado;
}
