package pe.com.arreglago.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
public class CategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @Column(name="id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name="nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name="descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    /* ===== CONTADOR DE PROFESIONALES ===== */
    @Transient
    private Long totalProveedores;

    /* ===== ICONO POR CATEGORÍA ===== */
    @Transient
    public String getIcono() {
    	switch ((int) this.codigo) {
        case 1: return "bi-bricks";                  // Albañil (Construcción, remodelación)
        case 2: return "bi-hammer";                  // Carpintero (Muebles de madera)
        case 3: return "bi-key-fill";                // Cerrajero (Cerraduras y seguridad)
        case 4: return "bi-lightning-charge-fill";   // Electricista (Sistemas eléctricos)
        case 5: return "bi-bug-fill";                // Fumigador (Control de plagas)
        case 6: return "bi-droplet-fill";            // Gasfitero (Tuberías, grifería, agua)
        case 7: return "bi-border-width";            // Instalador de Drywall (Tabiquería)
        case 8: return "bi-grid-3x3-gap-fill";       // Instalador de Pisos (Cerámicos, laminados)
        case 9: return "bi-tree-fill";               // Jardinero (Poda y áreas verdes)
        case 10: return "bi-stars";                  // Limpieza (Hogar, oficinas)
        case 11: return "bi-brush-fill";             // Pintor (Pintura de interiores y exteriores)
        case 12: return "bi-fire";                   // Soldador (Estructuras metálicas, rejas)
        case 13: return "bi-x-diamond-fill";         // Tapicero (Tapizado y reparación de muebles)
        case 14: return "bi-laptop";                 // Técnico de Computadoras (Equipos informáticos)
        case 15: return "bi-tools";                  // Técnico de Electrodomésticos (Lavadoras, refrigeradoras)
        case 16: return "bi-fuel-pump-fill";         // Técnico de Gas (Sistemas de gas)
        case 17: return "bi-snow2";                  // Técnico de Refrigeración (Aire acondicionado, congeladores)
        case 18: return "bi-tv-fill";                // Técnico de Televisores (Televisores y audio)
        case 19: return "bi-window";                 // Vidrieros (Vidrios, lunas y espejos)
        default: return "bi-briefcase-fill";
    }
    }
}
