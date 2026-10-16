package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
@Table(name = "Solicitud")
public class Tutoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID TutoriaID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disponibilidadID", nullable = false)
    private Disponibilidad disponibilidad;

    @NotBlank
    @Column(nullable = false, length = 20)
    private Estado estado;

    @Column(nullable = false)
    private String correo_estudiante;


    // Constructor vacío
    public Tutoria() {
    }

    // Constructor con atributos
    public Tutoria(UUID TutoriaID, Estado estado, Usuario estudiante) {

        this.TutoriaID = trabajadorTutoriaID;
        this.estado = estado;
        this.correo_estudiante = estudiante;
    }

    // Getters y Setters

    public Long getId() {
        return TutoriaID;
    }

    public void setId(UUID id) {
        this.TutoriaID = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEstudiante() {
        return correo_estudiante;
    }

    public void setEstudiante(Usuario correo_estudiante) {
        this.correo_estudiante = correo_estudiante;
    }
}