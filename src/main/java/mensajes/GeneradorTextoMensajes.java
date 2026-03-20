Ahora el generador es una sola línea. No importa cuántos mensajes nuevos crees, esta clase nunca más se toca.

Java
package mensajes;

public class GeneradorTextoMensajes {
    public String generar(Mensaje msg) {
        String asuntoBase = "[" + msg.getCanal().toUpperCase() + "] ";
        return asuntoBase + msg.generarContenido();
    }
}
