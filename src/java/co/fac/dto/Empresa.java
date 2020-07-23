package co.fac.dto;

import java.io.Serializable;

/**
 *
 * @author Sebas Gordillo
 */

public class Empresa implements Serializable{

    private String usuario;
    private String contrasena;
    private String direccion;
    private int telefono;
    private int nit;
    private String privilegio;

    public Empresa() {
    }

    public Empresa(String usuario, String contrasena, String privilegio) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.privilegio = privilegio;
    }

    public Empresa(String usuario, String contrasena, String direccion, int telefono, int nit, String privilegio) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.privilegio = privilegio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    @Override
    public String toString() {
        return "Empresa{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", direccion=" + direccion + ", telefono=" + telefono + ", nit=" + nit + ", privilegio=" + privilegio + '}';
    }

}
