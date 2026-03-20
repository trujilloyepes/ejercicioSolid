# Análisis y corrección SOLID — Paquete: matricula

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
Principio: SRP (Single Responsibility Principle), porque una misma clase (MatriculaService) hace demasiadas cosas.
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- 
Clase donde está el problema:
- MatriculaService
- CrearMatricula()
- validarDNI()
- calcularPrecio()
- exportarResumen()

**Síntomas que lo delatan (marca y explica brevemente):**
-
Síntomas que lo delatan:
- Valida el DNI
- Calcula el precio
- Crea la matrícula
- Guarda datos
- Muestra mensajes

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-
Cambios futuros son caros o arriesgados, porque si modifico la forma de calcular precios o exportar resumen, puedo romper otras funcionalidades.
Partes difíciles de probar: es complicado probar el cálculo de precios o la validación de DNI sin que se mezcle con la creación de matrículas o la impresión en consola.
Fácil de introducir errores: cualquier cambio en la validación o exportación puede afectar otras funciones de la misma clase.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-
Separar responsabilidades:
Validación de DNI en su propia clase o método específico.
Cálculo de precios en otra clase o método separado.
Exportar resumen en otra clase/método distinto.
De esta forma cada clase o método solo hace una cosa, cumpliendo SRP y facilitando mantenimiento y pruebas.
