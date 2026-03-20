package rrhh;

public class AltaEmpleadoService {
    // Usamos las interfaces como tipos, no las clases concretas
    private final EmpleadoRepository repositorio;
    private final PasswordGenerator generadorPassword;

    // Inyección por constructor: eliminamos los "new" internos
    public AltaEmpleadoService(EmpleadoRepository repositorio, PasswordGenerator generador) {
        this.repositorio = repositorio;
        this.generadorPassword = generador;
    }

    public Empleado alta(String dni, String nombre) {
        if (dni == null || dni.isBlank()) throw new IllegalArgumentException("DNI requerido");
        
        // El servicio ya no sabe "cómo" se guarda, solo que se guarda
        if (repositorio.existe(dni)) throw new IllegalStateException("Ya existe empleado");

        String passwordTemporal = generadorPassword.generar();
        Empleado e = new Empleado(dni, nombre, passwordTemporal);

        repositorio.guardar(e);

        System.out.println("Creado usuario para " + nombre + " con password temporal: " + passwordTemporal);
        return e;
    }
}
