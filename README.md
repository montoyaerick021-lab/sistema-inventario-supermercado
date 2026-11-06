# Sistema de Inventario de Supermercado

**Proyecto ACA individual — Programación Orientada a Objetos**

## Descripción
Aplicación de consola desarrollada en Java para simular el inventario de un pequeño supermercado. Permite registrar productos, consultar todos los productos, calcular el valor total del inventario y buscar productos mediante su código. La información se conserva en memoria mientras el programa está en ejecución.

## Funcionalidades
1. Registrar productos con código, nombre, precio, cantidad y categoría.
2. Mostrar todos los productos y el valor total del inventario.
3. Buscar un producto por su código.
4. Salir del programa.

## Clases utilizadas
- `Producto`: representa cada producto y almacena sus atributos.
- `Inventario`: administra la lista de productos y permite agregarlos, mostrarlos y buscarlos.
- `ProductoNoEncontradoException`: excepción personalizada cuando no existe el código buscado.
- `Main`: contiene el menú y controla la interacción con el usuario.

## Conceptos de POO aplicados
- Clases y objetos.
- Atributos privados y encapsulamiento.
- Constructores, getters y setters.
- Relación entre `Inventario` y `Producto`.
- Lista `ArrayList` y recorrido con `for`.
- Arreglo de categorías.
- Manejo de errores con `try-catch`.
- Excepción personalizada.

## Requisitos
Tener instalado el JDK de Java.

## Cómo ejecutar
Abre una terminal en la carpeta donde están los archivos y ejecuta:

```bash
javac *.java
java Main
```

## Autor
Estudiante: Erick fernando montoya peña]  
Modalidad: Individual
