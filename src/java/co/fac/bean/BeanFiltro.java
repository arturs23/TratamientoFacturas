package co.fac.bean;

import co.fac.dao.OperFactura;
import co.fac.dto.Empresa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Sebas
 */
@ManagedBean
@ViewScoped
public class BeanFiltro implements Serializable {

    //Aca se almacena el archivo txt
    private UploadedFile file;
    private Empresa user;

   

    public BeanFiltro() {

        Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        user = (Empresa) sesion.get("usuarioSesion");

    }

    public Empresa usuarioEnSesion() {

        return user;
    }

    public void cargaBD() {

        if (file != null) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", file.getFileName() + " fue cargado a la base de datos."));

            OperFactura oper = new OperFactura();
            oper.insertarBD(convertir(file));

        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Debe subir un archivo."));

        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + event.getFile().getFileName() + " subido correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    //Metodo que convierte de un uploadfile a un file
    public File convertir(UploadedFile archivo) {

        archivo = file;

        InputStream inputStream = null;
        OutputStream outputStream = null;
        //Add you expected file encoding here:
        System.setProperty("file.encoding", "UTF-8");
        File newFile = new File(archivo.getFileName());

        try {
            inputStream = archivo.getInputstream();
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            //Do something with the Exception (logging, etc.)
        }
        return newFile;
    }

     public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Empresa getUser() {
        return user;
    }

    public void setUser(Empresa user) {
        this.user = user;
    }
    
    
    
    public String salir() {
        return "salir";

    }

}
