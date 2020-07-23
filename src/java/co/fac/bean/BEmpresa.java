package co.fac.bean;

import co.fac.dao.OperEmpresa;
import co.fac.dto.Empresa;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Esteban
 */
@ManagedBean
@ViewScoped
public class BEmpresa implements Serializable {

    private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);

    private String usuario;
    private String contrasena;
    private String direccion;
    private int telefono;
    private int nit;
    private String privilegio;
    private Map<String, String> privilegios = new HashMap<String, String>();
    private Empresa user;

    @PostConstruct
    public void init() {
        privilegios = new HashMap<String, String>();
        privilegios.put("Cliente", "Cliente");
        privilegios.put("Administrador", "Administrador");

    }

    public BEmpresa() {

        Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        user = (Empresa) sesion.get("usuarioSesion");

    }

    public Empresa usuarioEnSesion() {

        return user;
    }

    public void insertarEmpresa() {

        if (usuario == null || usuario.isEmpty() || direccion == null || direccion.isEmpty() || contrasena == null || telefono == 0 || nit == 0 || privilegio.isEmpty() || privilegio == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Datos Nulos Revise"));
            return;
        }
       System.out.println(" Placa " + this.contrasena);
        Empresa em = new Empresa();
        em.setUsuario(usuario);
        em.setContrasena(contrasena);
        em.setDireccion(direccion);
        em.setTelefono(telefono);
        em.setNit(nit);
        em.setPrivilegio(privilegio);

        OperEmpresa operEm = new OperEmpresa();
        int rta = operEm.insertar(em);
        
        System.out.println("rta " + rta);
        if (rta > 0) {
            this.limpiar();
            //this.mensaje = "Inserto "+r;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro la empresa"));
            LOG.debug("Se registro la empresa: " + em.getUsuario());

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "llave repetida"));
        }

    }

    public void borrarEmpresa() {

        OperEmpresa operEm = new OperEmpresa();
        int rtas = operEm.borrar(usuario);
        System.out.println("rta " + rtas);
        if (rtas > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se eliminado con exito"));

            LOG.debug("El usuario: " + (user.getUsuario()) + " elimino la empresa: " + usuario);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "No existe llave"));
        }
    }

    public void actualizar() {
        if (usuario == null || usuario.isEmpty() || direccion == null || direccion.isEmpty() || contrasena == null || telefono == 0 || nit == 0 || privilegio.isEmpty() || privilegio == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Datos Nulos Revise"));
            return;
        }

        Empresa em = new Empresa();
        em.setUsuario(usuario);
        em.setContrasena(contrasena);
        em.setDireccion(direccion);
        em.setTelefono(telefono);
        em.setNit(nit);
        em.setPrivilegio(privilegio);
        OperEmpresa operEm = new OperEmpresa();
        int rtas = operEm.actualizar(em);
        System.out.println("rta " + rtas);
        if (rtas > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se actualizo con exito"));
            LOG.debug("Se actualizo la empresa: " + em.getUsuario());
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "No se actualizo"));
        }
    }

    public String regresar() {

        return "irRegistrar";
    }

    public void limpiar() {
        this.usuario = "";
        this.contrasena = "";
        this.direccion = "";
        this.nit = 0;
        this.telefono = 0;
    }

    public Map<String, String> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Map<String, String> privilegios) {
        this.privilegios = privilegios;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
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

    public Empresa getUser() {
        return user;
    }

    public void setUser(Empresa user) {
        this.user = user;
    }

    public String lista() {
        return "listaEmpresa";

    }

    public String cerrarSesion() {
        return "cerrarSesion";

    }
    public String cerrarsesionmenu(){
        return "Login";
    }
    public String actuliza() {
        return "actualizarEmpresa";
    }
    public String filtocli(){
        return "filtroCliente";
    }
    public String regresarmenu(){
        return "menuPrincipal";
    }
     public String cerrarsesionfiltrocli(){
        return "Login";
    }
     public String filtofec(){
        return "filtroFecha";
    } 
}
