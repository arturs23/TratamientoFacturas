package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String marca;
    private int items;
    
    

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String marca, int items) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.items = items;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", marca=" + marca + ", items=" + items + '}';
    }

   

    
  

}
