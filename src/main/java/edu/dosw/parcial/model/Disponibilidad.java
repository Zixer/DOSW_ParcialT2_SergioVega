import java.time.LocalTime;

public class Disponibilidad {
    private UUID id;
    private Date fecha;
    private LocalTime hora_in;
    private LocalTime hora_fin;
    private Modalidad modalidad;
    private Estado estado;
    private String correo_tutor;
    private String materia; {

    public enum Estado { LIBRE, OCUPADO }
    public enum Estado { VIRTUAL, PRESENCIAL }

    }

}