import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        String[] categorias = {"Aseo", "Alimentos", "Bebidas", "Tecnología"};

        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }

        do {
            System.out.println("\n======================================");
            System.out.println("     SISTEMA DE INVENTARIO");
            System.out.println("        SUPERMERCADO");
            System.out.println("======================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrarProducto(scanner, inventario, categorias);
                        break;
                    case 2:
                        inventario.mostrarProductos();
                        break;
                    case 3:
                        buscarProducto(scanner, inventario);
                        break;
                    case 4:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Seleccione del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarProducto(Scanner scanner, Inventario inventario,
                                           String[] categorias) {
        try {
            System.out.println("\n----- REGISTRO DE PRODUCTO -----");
            System.out.print("Código: ");
            int codigo = Integer.parseInt(scanner.nextLine());

            if (inventario.existeCodigo(codigo)) {
                System.out.println("Ya existe un producto con ese código.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Categorías:");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i]);
            }
            System.out.print("Seleccione el número de categoría: ");
            int seleccion = Integer.parseInt(scanner.nextLine());

            if (nombre.trim().isEmpty() || precio < 0 || cantidad < 0
                    || seleccion < 1 || seleccion > categorias.length) {
                System.out.println("Datos inválidos. Revise nombre, precio, cantidad y categoría.");
                return;
            }

            Producto producto = new Producto(
                codigo, nombre, precio, cantidad, categorias[seleccion - 1]
            );
            inventario.agregarProducto(producto);
            System.out.println("Producto registrado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese números válidos para código, precio, cantidad y categoría.");
        }
    }

    private static void buscarProducto(Scanner scanner, Inventario inventario) {
        try {
            System.out.print("Ingrese el código del producto: ");
            int codigo = Integer.parseInt(scanner.nextLine());
            Producto producto = inventario.buscarPorCodigo(codigo);
            System.out.println("\n----- PRODUCTO ENCONTRADO -----");
            producto.mostrarInformacion();
        } catch (NumberFormatException e) {
            System.out.println("Error: el código debe ser numérico.");
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
