package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */
public class Cliente {

    private String nombre;
    private int cedula;
    private String apellido;

    public Cliente() {
    }

    public Cliente(String nombre, int cedula, String apellido) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + '}';
    }

}
