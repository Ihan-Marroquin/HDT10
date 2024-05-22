# Graphos Estructura

Graphos Estructura es un proyecto en Java que implementa un grafo dirigido utilizando el algoritmo de Floyd-Warshall para encontrar las rutas más cortas entre ciudades y determinar la ciudad central del grafo.

## Tabla de Contenidos
- [Descripción](#descripción)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación](#instalación)
- [Uso](#uso)
- [Formato del Archivo de Entrada](#formato-del-archivo-de-entrada)
- [Funcionalidades](#funcionalidades)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Descripción

Este proyecto implementa un grafo dirigido y permite:
- Calcular la ruta más corta entre dos ciudades.
- Mostrar la ciudad que queda en el centro del grafo.
- Modificar el grafo para interrumpir el tráfico entre dos ciudades o establecer nuevas conexiones.

## Estructura del Proyecto

El proyecto está compuesto por las siguientes clases:

- `Graph`: Representa el grafo dirigido.
- `FloydWarshall`: Implementa el algoritmo de Floyd-Warshall para encontrar las rutas más cortas.
- `GraphCenter`: Determina la ciudad central del grafo.
- `Main`: Contiene el método principal para interactuar con el usuario y manejar las operaciones del grafo.

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/graphos-estructura.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd graphos-estructura
    ```

3. Asegúrate de tener Java instalado. Compila el proyecto con:
    ```bash
    javac *.java
    ```

## Uso

1. Crea un archivo llamado `guategrafo.txt` en el directorio raíz del proyecto con el siguiente formato:
    ```txt
    Ciudad1 Ciudad2 KM
    ```

    Ejemplo:
    ```txt
    Mixco Antigua 30
    Antigua Escuintla 25
    Escuintla SantaLucia 15
    SantaLucia Guatemala 20
    Guatemala SanLucas 10
    SanLucas Chimaltenango 35
    Chimaltenango Tecpan 40
    Tecpan Solola 50
    Solola Panajachel 15
    Panajachel Quetzaltenango 60
    ```

2. Ejecuta el programa:
    ```bash
    java Main
    ```

3. Sigue las instrucciones en el menú para interactuar con el grafo.

## Formato del Archivo de Entrada

El archivo `guategrafo.txt` debe tener el siguiente formato:

```txt
Ciudad1 Ciudad2 KM
