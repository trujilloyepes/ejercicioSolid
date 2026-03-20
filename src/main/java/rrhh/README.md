# Análisis y corrección SOLID — Paquete: rrhh

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
Principio: DIP (Dependency Inversion Principle) — Principio de Inversión de Dependencias.
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- 
Clase AltaEmpleadoService: esta clase depende directamente de implementaciones concretas como RepositorioEmpleadosEnMemoria y GeneradorPasswordSimple.

**Síntomas que lo delatan (marca y explica brevemente):**
-
Instanciación rígida: dentro de AltaEmpleadoService, las dependencias se crean con el operador new (private final ... = new ...).
## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-
-Dificultad de migración: si el proyecto crece y necesitamos guardar los empleados en una Base de Datos (MySQL, MongoDB) o usar un generador de contraseñas cifradas, estamos obligados a modificar y recompilar la clase AltaEmpleadoService.
-Código difícil de testear: no podemos probar el servicio de forma aislada (Unit Testing) porque está "pegado" a la persistencia en memoria. No podemos usar Mocks o Stubs fácilmente.
-Rigidez: el sistema no es flexible; está diseñado para una única configuración específica de infraestructura.
## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-
-Creación de Interfaces: se han extraído dos interfaces: EmpleadoRepository (para el almacenamiento) y PasswordGenerator (para la lógica de credenciales).
-Desacoplamiento: AltaEmpleadoService ya no instancia sus dependencias. Ahora las recibe a través del constructor (Inyección de Dependencias), trabajando siempre contra las interfaces y no contra las clases concretas.
-Inversión del Control: ahora el servicio de "Alta" define qué necesita para funcionar, y es la clase App (o un contenedor) quien decide qué implementación específica entregarle. Esto permite cambiar el repositorio de memoria a uno de base de datos sin tocar ni una línea del código del servicio.
