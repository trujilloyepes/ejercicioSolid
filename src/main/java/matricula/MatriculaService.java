package matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaService {

    private final List<Matricula> matriculas = new ArrayList<>();

    public Matricula crearMatricula(String dni, String curso, double precioBase, boolean bonificacion) {
        // 1. Validar DNI
        validarDni(dni);

        // 2. Calcular precio final
        double precioFinal = calcularPrecio(precioBase, bonificacion);

        // 3. Crear matrícula
        Matricula m = new Matricula(dni, curso, LocalDate.now(), precioFinal);
        matriculas.add(m);

        // 4. Notificar (solo consola, responsabilidad mínima)
        notificar(m);

        return m;
    }

    // Exportar resumen separado
    public String exportarResumen() {
        StringBuilder resultado = new StringBuilder("RESUMEN MATRÍCULAS\n");
        for (Matricula m : matriculas) {
            resultado.append(m.getDni())
                     .append(" | ").append(m.getCurso())
                     .append(" | ").append(m.getFecha())
                     .append(" | ").append(m.getPrecioFinal())
                     .append("\n");
        }
        return resultado.toString();
    }

    // --- Métodos privados para separar responsabilidades ---

    private void validarDni(String dni) {
        if (dni == null || dni.isBlank() || dni.length() < 7) {
            throw new IllegalArgumentException("DNI inválido");
        }
    }

    private double calcularPrecio(double precioBase, boolean bonificacion) {
        if (precioBase <= 0) throw new IllegalArgumentException("Precio inválido");
        double total = precioBase;
        if (bonificacion) total *= 0.85; // 15% descuento
        return total + 12.0; // gastos de gestión
    }

    private void notificar(Matricula m) {
        System.out.println("[AVISO] Matriculado " + m.getDni() + " en " + m.getCurso() + " por " + m.getPrecioFinal() + "€");
    }
}
