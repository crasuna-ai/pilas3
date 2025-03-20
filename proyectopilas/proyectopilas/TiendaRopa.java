// una tienda de ropa requiere un sistema que le permita lo siguiente

//menu 
//1. registrar prenda
// 2. consultar prenda
// 3. modificar prenda
// 4. vender prenda
// 5. consultar stock

// 2: cada prenda tiene los siguientes atributos 
// Marca, Referencia, Precio, Cantidad

// 3 cuando voy a ingresar una prenda nueva el sistema debe validar si existe 
// si existe le debe sumar las cantidades si no debe crear una nueva

//4: cuando  se vende una prenda se debe restar la cantidad 
// si la prenda a vender no existe debe mostrar mensaje "la  prenda no existe y permitir ingresar ya sea por marca o por referencia de lo contrario debe mostrar el stock con lacantidad de la penda reducida"

import javax.swing.JOptionPane;

public class TiendaRopa { private static inventario inventario = new inventario();
    public static void main(String[] args) {
        int opcion;
    
        do {
            opcion = mostrarMenu();
    
            switch (opcion) {
                case 1:
                    registrarPrenda();
                    break;
                case 2:
                    consultarPrenda();
                    break;
                case 3:
                    modificarPrenda();
                    break;
                case 4:
                    venderPrenda();
                    break;
                case 5:
                    consultarStock();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida intente de nuevo.");
            }
        } while (opcion != 0);
    }
    
    // Mostrar el menú usando JOptionPane
    private static int mostrarMenu() {
        String menu = "Menu:\n" +
                      "1. Registrar prenda\n" +
                      "2. Consultar prenda\n" +
                      "3. Modificar prenda\n" +
                      "4. Vender prenda\n" +
                      "5. Consultar stock\n" +
                      "0. Salir";
        String opcionString = JOptionPane.showInputDialog(null, menu);
        return Integer.parseInt(opcionString);  // Convertir la opción ingresada a entero
    }
    
    // Registrar una prenda
    private static void registrarPrenda() {
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String referencia = JOptionPane.showInputDialog("Ingrese la referencia:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
    
        inventario.registrarPrenda(marca, referencia, precio, cantidad);
    }
    
    // Consultar una prenda
    private static void consultarPrenda() {
        String buscar = JOptionPane.showInputDialog("Ingrese la referencia o marca de la prenda:");
        inventario.consultarPrenda(buscar);
    }
    
    // Modificar una prenda
    private static void modificarPrenda() {
        String referencia = JOptionPane.showInputDialog("Ingrese la referencia de la prenda a modificar:");
        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad:"));
        inventario.modificarPrenda(referencia, nuevaCantidad);
    }
    
    // Vender una prenda
    private static void venderPrenda() {
        String buscar = JOptionPane.showInputDialog("Ingrese la referencia o marca de la prenda a vender:");
        int unidades = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas unidades desea vender?"));
        inventario.venderPrenda(buscar, unidades);
    }
    
    // Consultar todo el stock
    private static void consultarStock() {
        inventario.consultarStock();
    }
}