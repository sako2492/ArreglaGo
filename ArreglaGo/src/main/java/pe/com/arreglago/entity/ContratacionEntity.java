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

@Entity(name="ContratacionEntity")
@Table(name="contratacion") 

public class ContratacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contratacion")
    private Long codigo;
    
    @Column(name = "detalle_servicio", length = 500, nullable = true)
    private String detalleServicio;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;
    
    @Column(name = "fecha_tentativa", nullable = true) // ✅ HAZLO NULLABLE EN CASO QUE NO ESTÉ EN TU DB AÚN
    private LocalDate fechaTentativa; // Usamos LocalDate para manejar solo la fecha del input

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private ClienteEntity cliente;

    /*
    @ManyToOne
    @JoinColumn(name="id_servicio")
    private ServicioEntity servicio;
	*/
	
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;

    @PrePersist
    protected void onCreate() {
        this.fechaReserva = LocalDateTime.now();
    }
}