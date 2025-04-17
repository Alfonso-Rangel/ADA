# Cómo correr el proyecto

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- **Java 17** o superior.
- **Git** para clonar el repositorio.
---

## Cómo descargar y correr el proyecto

### 1. Clonar el repositorio

Ejecuta el siguiente comando en tu terminal para clonar el repositorio:

```bash
git clone https://github.com/Alfonso-Rangel/ADA.git
```
### 2. Compilar y Ejecutar
Desde el directorio raíz `/ADA` ejecuta los siguientes comandos:

Compila todos los módulos:
```bash
./mvnw clean install
```
Inicia la aplicación:
```bash
./mvnw spring-boot:run -pl app-core
```
Accede a la aplicación desde tu navegador en la siguiente URL:
```bash
http://localhost:8080/index.html
```
## Cómo empezar a trabajar en los PACs
### 1. Modificar el código

Dentro de cada PAC, encontrarás las siguientes carpetas principales:

- `src/main/java`: Contiene la capa de la Abstracción y Control en Java.
- `src/main/resources`: Es la capa de la Presentación y contiene los recursos estáticos, como archivos HTML, CSS y JavaScript.

> **_NOTA:_**  Spring Boot obliga a tener las carpetas `src/main/java` y `src/main/resources`, sin ellas no puede escanear los archivos. Es por eso que no se puede modificar el nombre, pero dentro de estas carpetas puede ir cualquier código con normalidad, incluso crear más subcarpetas.

### 2. Probar los cambios

Para probar los cambios realizados, desde el directorio raíz `/ADA` ejecuta los siguientes comandos:

Compila todos los módulos:
```bash
./mvnw clean install
```
Inicia la aplicación:
```bash
./mvnw spring-boot:run -pl app-core
```