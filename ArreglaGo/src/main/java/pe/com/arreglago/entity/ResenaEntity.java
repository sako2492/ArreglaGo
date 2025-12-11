package pe.com.arreglago.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name = "ResenaEntity")
@Table(name = "resena")
public class ResenaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;
    
    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    @Column(nullable = false)
    private int calificacion;   // 1 a 5

    @Column(length = 500)
    private String comentario;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @Column(nullable = false)
    @Builder.Default
    private boolean estado = true;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario") 
    private UsuarioEntity usuario;
}
