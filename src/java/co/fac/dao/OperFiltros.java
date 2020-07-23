
package co.fac.dao;

import co.fac.dto.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 *
 * @author Esteban Moreno
 */
public class OperFiltros  {
 private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);
    
 
 public List<Producto> ListarProduct() {
        List<Producto> lista = new ArrayList<>();

        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {

            PreparedStatement ps;
            try {
                ps = miconec.prepareStatement("SELECT idproducto, producto, marca, items\n" +
"	FROM public.productos");

                ResultSet results = ps.executeQuery();

                while (results.next()) {

                    lista.add(new Producto(results.getInt(1),results.getString(2), results.getString(3), results.getInt(4)));
                }

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
                LOG.error("Error al listar los usuarios" + ex);

            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return lista;

    }
     
    
    
   
    
}
