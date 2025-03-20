import javax.swing.JOptionPane;
import java.util.Stack;


public class inventario{
    private Stack<Prenda> stock;
    public inventario() {
        stock = new Stack<>();
    
    }
    
    public void registrarPrenda(String marca, String referencia, double precio, int cantidad) {
        for (Prenda p : stock) {
            if (p.referencia.equals(referencia)) {
                p.cantidad += cantidad;
                System.out.println("Prenda existente. Ya se ha sumado la cantidad.");
                return;
            }
        }
        stock.push(new Prenda(marca, referencia, precio, cantidad));
        System.out.println("Prenda registrada con éxito.");
    }
    
    public void consultarPrenda(String buscar) {
        for (Prenda p : stock) {
            if (p.referencia.equals(buscar) || p.marca.equalsIgnoreCase(buscar)) {
                System.out.println("Prenda encontrada: " + p );
                return;
            }
        }
        System.out.println("La prenda no existe.");
    }
    
    // Modificar cantidad de una prenda
    public void modificarPrenda(String referencia, int nuevaCantidad) {
        for (Prenda p : stock) {
            if (p.referencia.equals(referencia)) {
                p.cantidad = nuevaCantidad;
                System.out.println("Prenda modificada con éxito.");
                return;
            }
        }
        System.out.println("La prenda no existe.");
    }
    
    // Vender prenda
    public void venderPrenda(String buscar, int unidades) {
        for (Prenda p : stock) {
            if (p.referencia.equals(buscar) || p.marca.equalsIgnoreCase(buscar)) {
                if (p.cantidad >= unidades) {
                    p.cantidad -= unidades;
                    System.out.println("Venta realizada con éxito. Cantidad restante: " + p.cantidad );
                } else {
                    System.out.println("No hay suficiente stock.");
                }
                return;
            }
        }
        System.out.println("La prenda no existe.");
    }
    
    // Consultar todo el stock
    public void consultarStock() {
        if (stock.isEmpty()) {
            System.out.println("El stock está vacío.");
        } else {
            System.out.println("Stock de prendas:");
            for (Prenda p : stock) {
                System.out.println(p );
            }
        }
    }
}