package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public void prestar(Libro libro, String dni) {
        if (libro.estaPrestado()) {
            throw new IllegalStateException("Ya estaba prestado");
        }
        libro.prestarA(dni, LocalDate.now().plusDays(14));
        if (!(libro instanceof LibroReferencia)) {
            System.out.println("Prestado: " + libro.getTitulo() + " a " + dni);
        }
    }

    public boolean devolver(Libro libro) {
        libro.devolver();
        return !libro.estaPrestado();
    }
}
