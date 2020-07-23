package co.fac.dto;

import java.sql.Date;

/**
 *
 * @author Sebas Gordillo
 */
public class Factura {

    private int idFactura;
    private Date fecha;
    private String hora;
    private double valor;
    private Cliente Cliente;
    private Zona Zona;

    public Factura() {
    }

    public Factura(int idFactura, Date fecha, String hora, double valor) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }

    public Factura(int idFactura, Date fecha, String hora, double valor, Cliente Cliente, Zona Zona) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.Cliente = Cliente;
        this.Zona = Zona;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Zona getZona() {
        return Zona;
    }

    public void setZona(Zona Zona) {
        this.Zona = Zona;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", fecha=" + fecha + ", hora=" + hora + ", valor=" + valor + ", Cliente=" + Cliente + ", Zona=" + Zona + '}';
    }

    

}
