package pe.com.arreglago.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity(name="UsuarioEntity")
@Table(name="usuario") 

public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_usuario") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private  long codigo;
	@Column(name="nombre", length = 100, nullable = false)
	private String nombre;
	@Column(name="apellidoPaterno", length = 100, nullable = false)
	private String apellidoPaterno;
	@Column(name="apellidoMaterno", length = 100, nullable = false)
	private String apellidoMaterno;
	@Column(name="correo", length = 150, nullable = false, unique = true)
	private String correo;
	@Column(name="telefono", length = 9, nullable = false)
	private String telefono;
	@Column(name="direccion", length = 300, nullable = false)
	private String direccion;
	@Column(name="nro_documento", length = 20, nullable = false)
	private String nroDocumento;
	@Column(name="fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;
	@Column(name="clave", length = 100, nullable = false)
	private String clave;
	@Column(name="foto_perfil", length = 255)
	private String fotoPerfil;
	@Column(name="estado", nullable = false)
	private boolean estado;
	@Column (name="fecha_registro")
	private LocalDateTime fechaRegistro;
	

	
	@ManyToOne
	@JoinColumn(name = "id_distrito", nullable = false)
	private DistritoEntity distrito;
	@ManyToOne 
	@JoinColumn (name="id_rol", nullable = false)
	private RolEntity rol;
	@ManyToOne
	@JoinColumn (name = "id_tipoDocumento", nullable = false)
	private TipoDocumentoEntity tipodocumento;
	
	@PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }
}
