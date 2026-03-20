package biblioteca;

public class LibroReferencia extends Libro {

    public LibroReferencia(String titulo) {
        super(titulo);
    }

    @Override
    public void prestarA(String dni, java.time.LocalDate fechaDevolucion) {
        // No se puede prestar, solo se consulta en sala
        System.out.println("El libro de referencia \"" + titulo + "\" no se puede prestar.");
    }

    @Override
    public boolean estaPrestado() {
        // Nunca está prestado
        return false;
    }

    @Override
    public void devolver() {
        // No se puede devolver
        System.out.println("El libro de referencia \"" + titulo + "\" no se puede devolver.");
    }
}
