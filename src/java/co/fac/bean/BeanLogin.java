/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.fac.bean;

import co.fac.dao.OperEmpresa;
import co.fac.dto.Empresa;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Sebas
 */
@ManagedBean
@ViewScoped
public class BeanLogin implements Serializable {
    
     private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);

    private String usuario;
    private String contrasena;

    public BeanLogin() {
    }

    public String iniciarSesion() {

        String redireccion = null;
        if (usuario.isEmpty() || contrasena.isEmpty()) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "", "Datos incompletos"));

        } else {

            Empresa user = new Empresa();
            user.setUsuario(usuario);
            user.setContrasena(contrasena);

            OperEmpresa oper = new OperEmpresa();
            int rta = oper.iniciarSesion(user);
            System.out.println("rta " + rta);

            //Hay que dejarlo para mantener la sesion activa
            Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

            //Lo encontro
            switch (rta) {

                //Privilegio de administrador
                case 1:

                    sesion.put("usuarioSesion", user);
                    //FacesContext.getCurrentInstance().addMessage(null,
                    //      new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Inicio de sesión exitoso."));

                    System.out.println("Usuario:" + user.toString());
                    redireccion = "irRegistrar";
                    break;

                //Privilegio de cliente
                case 2:
                    //Hay que dejarlo para mantener la sesion activa
                    //Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
                    sesion.put("usuarioSesion", user);

                    System.out.println("Usuario:" + user.toString());
                    redireccion = "irFiltro";
                    break;

                default:
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención", "Usuario o contraseña incorrectos."));
                    LOG.warn("El Usuario: " +usuario+ " o la contrasena:"+contrasena +" son incorrectos") ;
                    
                    System.out.println("Usuario:" + user.toString());
                    
                    break;
            }
        }

        return redireccion;
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

}
