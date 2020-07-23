package co.fac.bean;

import co.fac.dao.OperVenta;
import co.fac.dto.Venta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Esteban
 */
@ManagedBean
@ViewScoped
public class BVenta {

    private List<Venta> producventas;
    private Venta venta;
    private List<Venta> ventasByTipoProductos;
    private OperVenta operevent;
    private String tipoproducto;
    private String busquedaTipo;
    private Map<String, String> tipoproductos = new HashMap<String, String>();

    public BVenta() {
        producventas = new ArrayList<>();
        ventasByTipoProductos = new ArrayList<>();
        venta = new Venta();
        operevent = new OperVenta();

    }

    @PostConstruct
    public void init() {
        producventas = cargarventa();
        tipoproductos = new HashMap<String, String>();
        tipoproductos.put("Aseo", "Aseo");
        tipoproductos.put("Alimento", "Alimento");
        producventas = new ArrayList<>();
        ventasByTipoProductos = new ArrayList<>();
    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getVentasByTipoProductos() {
        return ventasByTipoProductos;
    }

    public void setVentasByTipoProductos(List<Venta> ventasByTipoProductos) {
        this.ventasByTipoProductos = ventasByTipoProductos;
    }
    
    
    public List<Venta> getProducventas() {
        return producventas;
    }

    public void setProducventas(List<Venta> producventas) {
        this.producventas = producventas;
    }

    public OperVenta getOperevent() {
        return operevent;
    }

    public void setOperevent(OperVenta operevent) {
        this.operevent = operevent;
    }

    private List<Venta> cargarventa() {
        return operevent.ListarProductven();
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public Map<String, String> getTipoproductos() {
        return tipoproductos;
    }

    public void setTipoproductos(Map<String, String> tipoproductos) {
        this.tipoproductos = tipoproductos;
    }

    public String getBusquedaTipo() {
        return busquedaTipo;
    }

    public void setBusquedaTipo(String busquedaTipo) {
        this.busquedaTipo = busquedaTipo;
    }
    
    
    public void buscarTipo() {
        OperVenta oper = new OperVenta();
          ventasByTipoProductos = oper.consultarTipo(tipoproducto);
         if ( ventasByTipoProductos  == null) {
            ventasByTipoProductos = new ArrayList<>();
        }
    }
}
