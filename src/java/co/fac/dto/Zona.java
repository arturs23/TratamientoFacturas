package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */
public class Zona {

    private int idzona;
    private String localidad;

    public Zona() {
    }

    public Zona(int idzona, String localidad) {
        this.idzona = idzona;
        this.localidad = localidad;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    
    

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Zona{" + "idzona=" + idzona + ", localidad=" + localidad + '}';
    }


    
    

}
