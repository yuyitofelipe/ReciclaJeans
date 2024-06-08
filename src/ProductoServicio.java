import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;

    public ProductoServicio() {
        this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("La Lista No Tiene Productos ¿Deberás Importar Datos? ");
        } else {
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }
}
