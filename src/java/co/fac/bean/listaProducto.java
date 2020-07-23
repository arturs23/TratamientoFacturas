package co.fac.bean;

import co.fac.dao.OperFiltros;
import co.fac.dto.Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Esteban
 */
@ManagedBean
@ViewScoped
public class listaProducto {

    private List<Producto> producto;
    private OperFiltros operefil;

    public listaProducto() {
        operefil = new OperFiltros();
    }

    @PostConstruct
    public void init() {
        producto = cargarPro();
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public OperFiltros getOperefil() {
        return operefil;
    }

    public void setOperefil(OperFiltros operefil) {
        this.operefil = operefil;
    }

    private List<Producto> cargarPro() {
        return operefil.ListarProduct();
    }

}
