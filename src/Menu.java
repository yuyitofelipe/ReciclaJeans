import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoServicio productoServicio = new ProductoServicio();
        ArchivoServicio archivoServicio = new ArchivoServicio();
        Utilidad utilidad = new Utilidad();
        int opcion;

        do {
            System.out.println("1. Listar Producto");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            // Manejo de entrada para opciones de menú
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir nueva línea residual

                switch (opcion) {
                    case 1:
                        productoServicio.listarProductos();
                        break;
                    case 2:
                        editarDatos(scanner, productoServicio);
                        break;
                    case 3:
                        archivoServicio.cargarDatos(productoServicio);
                        System.out.println("Datos importados correctamente.");
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }

                utilidad.esperar(2);
                utilidad.limpiarPantalla();
            } else {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.next(); // Descartar entrada no válida
                opcion = -1; // Valor inválido para continuar el bucle
            }

        } while (opcion != 4);

        scanner.close();
    }

    public static void editarDatos(Scanner scanner, ProductoServicio productoServicio) {
        System.out.print("Ingrese el código del producto a editar: ");
        String codigo = scanner.next();
        Producto producto = null;

        for (Producto p : productoServicio.getListaProductos()) {
            if (p.getCodigo().equals(codigo)) {
                producto = p;
                break;
            }
        }

        if (producto != null) {
            System.out.println("Producto encontrado: ");
            System.out.println("1.- El nombre del artículo actual es: " + producto.getArticulo());
            System.out.println("2.- El código del producto: " + producto.getCodigo());
            System.out.println("3.- El color del producto: " + producto.getColor());
            System.out.println("4.- La descripción del producto: " + producto.getDescripcion());
            System.out.println("5.- La marca del producto: " + producto.getMarca());
            System.out.println("6.- El precio del producto: " + producto.getPrecio());
            System.out.println("7.- La talla del producto: " + producto.getTalla());

            System.out.print("Ingrese la opción a editar de los datos del producto: ");

            // Manejo de entrada para opción de edición
            if (scanner.hasNextInt()) {
                int opcionEditar = scanner.nextInt();
                scanner.nextLine(); // Consumir nueva línea residual

                switch (opcionEditar) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre del artículo: ");
                        producto.setArticulo(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("El código del producto no se puede cambiar.");
                        break;
                    case 3:
                        System.out.print("Ingrese el nuevo color del producto: ");
                        producto.setColor(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Ingrese la nueva descripción del producto: ");
                        producto.setDescripcion(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Ingrese la nueva marca del producto: ");
                        producto.setMarca(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Ingrese el nuevo precio del producto: ");
                        producto.setPrecio(scanner.nextLine());
                        break;
                    case 7:
                        System.out.print("Ingrese la nueva talla del producto: ");
                        producto.setTalla(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Opción no válida. No se realizaron cambios.");
                        break;
                }

                System.out.println("Producto actualizado: " + producto);
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número para la opción de edición.");
                scanner.next(); // Descartar entrada no válida
            }
        } else {
            System.out.println("Producto no encontrado con el código: " + codigo);
        }
    }
}
