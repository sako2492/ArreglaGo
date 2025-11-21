package pe.com.arreglago.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

@Entity(name="ProveedorEntity")
@Table(name="proveedor") 

public class ProveedorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id_proveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@Column(name = "experiencia", length= 300, nullable = false)
	private String experiencia;
	@Column(name = "descripcion", length= 300, nullable = false)
	private String descripcion;
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private UsuarioEntity usuario;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaEntity categoria;
	
    /* 🔹 LISTA DE RESEÑAS DEL PROVEEDOR */
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<ResenaEntity> resenas;

    /* 🔹 Método para obtener promedio de calificación */
    public double getPromedioCalificacion() {
        if (resenas == null || resenas.isEmpty()) {
            return 0.0;
        }
        return resenas.stream()
                .mapToInt(ResenaEntity::getCalificacion)
                .average()
                .orElse(0.0);
    }

    /* 🔹 Número total de trabajos (reseñas) */
    public int getTotalTrabajos() {
        if (resenas == null) {
            return 0;
        }
        return resenas.size();
    }
}
