
package co.fac.bean;

import co.fac.dao.OperEmpresa;
import co.fac.dto.Empresa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Esteban Moreno
 */
@ManagedBean
@ViewScoped
public class listaEmpresa {
  private List<Empresa> empresa;
  private OperEmpresa operem;
  
    
    public listaEmpresa() {
        operem = new OperEmpresa();
    }
     @PostConstruct
    public void init() {
        empresa = cargarEm();
    }

    public String regresar() {
        return "irRegistrar";
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }

    public OperEmpresa getOperem() {
        return operem;
    }

    public void setOperem(OperEmpresa operem) {
        this.operem = operem;
    }
    
     private List<Empresa> cargarEm() {
    return operem.Listar();
    }
}
