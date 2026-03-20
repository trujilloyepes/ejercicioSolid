# Análisis y corrección SOLID — Paquete: mensajes

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
Principio: OCP (Open/Closed Principle) — Principio de Abierto/Cerrado.
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- 
En la Clase Mensaje: es una "clase gorda" que acumula atributos de todos los tipos posibles (fecha, alumno, tutoría, gravedad), obligando a que muchos sean null según el contexto.

**Síntomas que lo delatan (marca y explica brevemente):**
-
Acoplamiento al Enum: si queremos añadir un nuevo tipo de mensaje, estamos obligados a modificar el código existente en el generador.
## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-
-Cambios futuros caros o arriesgados: si el instituto decide añadir mensajes de "Felicitación", "Baja" o "Examen", el método generar crecerá indefinidamente con más if/else, haciéndose difícil de leer y mantener.
-Es fácil introducir errores al olvidar actualizar alguna parte de la lógica cuando se añade un nuevo tipo.
-Las pruebas unitarias son más complejas porque una sola clase (mensaje) tiene demasiadas variantes de estado.
## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-
-Clase Abstracta: se ha convertido la clase Mensaje en abstract, definiendo un contrato común mediante el método public abstract String formatear().
-Especialización (Herencia): se han creado subclases específicas (MensajeAviso, MensajeIncidencia) que heredan de la base. Ahora cada clase solo tiene los atributos que realmente necesita (ej. gravedad solo está en MensajeIncidencia).
-Polimorfismo: el GeneradorTextoMensajes ya no necesita preguntar "¿qué tipo eres?". Simplemente llama a msg.formatear(). Ahora el sistema es abierto a la extensión (podemos crear nuevas clases de mensaje) pero cerrado a la modificación (no hay que tocar el generador nunca más).
