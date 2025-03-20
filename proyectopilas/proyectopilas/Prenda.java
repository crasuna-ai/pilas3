public class Prenda {
    String marca;
    String referencia;
    Double precio;
    int cantidad;
    public Prenda(String marca, String referencia, Double precio, int cantidad) {
        this.marca = marca;
        this.referencia = referencia;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return "Marca: " + marca + "Referencia:" + referencia + "Precio:" + precio + "Cantidad:" + cantidad;
    }
  
    
}
