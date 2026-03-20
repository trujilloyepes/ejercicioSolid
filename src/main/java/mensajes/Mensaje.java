package mensajes;

public abstract class Mensaje {
    protected final String canal;
    protected final String destinatario;
    protected final String titulo;
    protected final String cuerpo;

    public Mensaje(String canal, String destinatario, String titulo, String cuerpo) {
        this.canal = canal;
        this.destinatario = destinatario;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    // Cada tipo de mensaje implementará su propio formato aquí
    public abstract String generarContenido();

    public String getCanal() { return canal; }
}
