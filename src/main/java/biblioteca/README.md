# Análisis y corrección SOLID — Paquete: biblioteca

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**  
Principio: LSP (Principio de Sustitución de Liskov), porque una subclase (LibroReferencia) no se comporta igual que la clase padre (Libro).
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
-
Clase donde está el problema:
- LibroReferencia (en el método prestarA)

Síntomas que lo delatan:
- LibroReferencia hereda de Libro, pero en realidad no se puede prestar.
- Aun así, tiene el método prestarA(), pero lo usa mal.
- Ignora los datos que le pasas (dni y fecha) y pone valores fijos como "SALA".
- El servicio cree que está prestando el libro a una persona, pero el objeto hace otra cosa.

**Síntomas que lo delatan (marca y explica brevemente):**
-

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-
- Los datos pueden ser incorrectos (dice que se presta a alguien pero no es verdad).
- Código confuso y engañoso.
- Mala herencia: se obliga a una clase a tener métodos que no necesita.
- Si el programa crece, puede provocar errores difíciles de detectar.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-
- Se ha eliminado la herencia directa entre Libro y LibroReferencia.
- Se ha creado una clase base (ItemBiblioteca) con lo que comparten (el título).
- Ahora:
  - Libro se puede prestar.
  - LibroReferencia no se presta, solo se consulta en sala.
- Así cada clase hace lo que le corresponde y se evita comportamiento incorrecto.
