package com.example.demo.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;  // Importa @JsonIgnore
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ordenes")
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_orden", nullable = false)
    private Date fechaOrden;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_solicita", nullable = false)
    private Date fechaSolicita;

    @Column(name = "estado", nullable = false)
    private String estado;

    // Relación muchos a uno con Proveedores
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id", nullable = false)
    @JsonIgnore  // Ignora la serialización de esta propiedad para evitar ciclos de referencia
    private Proveedores proveedor;

    // Relación muchos a uno con Almacenes
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "almacen_id", nullable = false)
    @JsonIgnore  // Ignora la serialización de esta propiedad para evitar ciclos de referencia
    private Almacenes almacen;

    // Relación muchos a uno con TipoOrden
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_orden_id", nullable = false)
    @JsonIgnore  // Ignora la serialización de esta propiedad para evitar ciclos de referencia
    private TipoOrden tipoOrden;

    // Relación muchos a uno con FormaPago
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "forma_pago_id", nullable = false)
    @JsonIgnore  // Ignora la serialización de esta propiedad para evitar ciclos de referencia
    private FormaPago formaPago;
    
    
}
