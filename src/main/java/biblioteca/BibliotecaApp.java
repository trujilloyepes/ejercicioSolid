package biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrestamoService service = new PrestamoService();

        Libro[] libros = new Libro[2];
        libros[0] = new Libro("Dune");
        libros[1] = new LibroReferencia("Diccionario RAE");

        // PRESTAR
        for (Libro libro : libros) {
            service.prestar(libro, "12345678A");
        }

        System.out.println();

        // DEVOLVER
        for (Libro libro : libros) {
            System.out.println("Devuelto (" + libro.getTitulo() + "): " + service.devolver(libro));
        }
    }
}
