import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {

    public void cargarDatos(ProductoServicio productoServicio) {
        String archivo = "C:\\Users\\felip\\Desktop\\workspace\\intellij\\Desafio_ReciclaJeans\\src\\ProductosImportados.csv";
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Producto producto = new Producto();
                    producto.setArticulo(datos[0]);
                    producto.setPrecio(datos[1]);
                    producto.setDescripcion(datos[2]);
                    producto.setCodigo(datos[3]);
                    producto.setTalla(datos[4]);
                    producto.setMarca(datos[5]);
                    producto.setColor(datos[6]);
                    productoServicio.getListaProductos().add(producto);
                    System.out.println("Producto agregado: " + producto);
                } else {
                    System.out.println("Línea de datos incorrecta: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
