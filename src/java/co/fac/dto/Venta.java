package co.fac.dto;

/**
 *
 * @author Esteban
 */
public class Venta {

    private String fechacompra;
    private int idproducto;
    private String nombreproducto;
    private String tipoproducto;
    private int cantidad; 
    private long precio;
 

    public Venta() {
    }

    public Venta(String fechacompra, int idproducto, String nombreproducto, String tipoproducto, int cantidad, long precio) {
        this.fechacompra = fechacompra;
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.tipoproducto = tipoproducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
    
    
}
