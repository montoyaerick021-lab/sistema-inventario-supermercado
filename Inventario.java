import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        double valorTotal = 0;
        System.out.println("\n========== PRODUCTOS DEL INVENTARIO ==========");
        for (Producto producto : productos) {
            producto.mostrarInformacion();
            valorTotal += producto.calcularValorTotal();
        }
        System.out.println("VALOR TOTAL DEL INVENTARIO: $" + valorTotal);
    }

    public Producto buscarPorCodigo(int codigo) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException(
            "No existe un producto con el código " + codigo + "."
        );
    }

    public boolean existeCodigo(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}
