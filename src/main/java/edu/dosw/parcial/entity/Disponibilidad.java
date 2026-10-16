package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
@Table(name = "Disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disponibilidadID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitudID", nullable = false)
    private solicitud solicitudID;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false)
    private LocalTime fecha;
    
    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @Column(nullable = true)
    private String Lugar;

    @Column(nullable = false)
    private Modalidad modalidad;

    @Column(nullable = false)
    private String correo_tutor;

    @Column(nullable = false)
    private String materia;


    // Constructor vacío
    public DisponibilidadSemanal() {
    }

    // Constructor con atributos
    public Disponibilidad(UUID disponibilidadID, LocalTime fecha,
                                LocalTime hora_in, LocalTime hora_fin,
                                Modalidad modalidad, Estado estado, String correo_tutor,String materia) {

        this.disponibilidadID = disponibilidadID;
        this.fecha = fecha;
        this.hora_in = hora_in;
        this.hora_fin = hora_fin;
        this.modalidad = modalidad;
        this.estado = estado;
        this.correo_tutor = correo_tutor;
        this.materia = materia;
    }

    // Getters y Setters

    public Long getId() {
        return disponibilidadID;
    }

    public void setId(UUID id) {
        this.disponibilidadID = id;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public LocalTime getHora_in() {
        return hora_in;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado Newestado) {
        this.estado = Newestado;
    }

    public String getcorreo_tutor() {
        return correo_tutor;
    }

    public Materia getmateria() {
        return materia;
    }
    
    public void setMateria(Materia Newmateria) {
        return this.materia = Newmateria;
    }

}