package co.fac.dao;

import co.fac.dto.Venta;
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
 * @author OscarEsteban
 */
public class OperVenta {

    private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);

    public List<Venta> ListarProductven() {
        List<Venta> lista = new ArrayList<>();

        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {

            PreparedStatement ps;
            try {
                ps = miconec.prepareStatement("SELECT fecha_compra, id_producto, nombre_producto, tipo_producto, cantidad, precio\n"
                        + "	FROM public.ventas");

                ResultSet results = ps.executeQuery();

                while (results.next()) {

                    lista.add(new Venta(results.getString(1), results.getInt(2), results.getString(3), results.getString(4), results.getInt(5), results.getLong(6)));
                }

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
                LOG.error("Error al listar producto venta" + ex);

            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return lista;

    }

    public List<Venta> consultarTipo(String tipoProduc) {

        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        List<Venta> ventas = new ArrayList<>();
        if (miconec != null) {

            PreparedStatement ps;
            try {
                ps = miconec.prepareStatement("SELECT fecha_compra, id_producto, nombre_producto, tipo_producto, cantidad, precio\n"
                        + "	FROM public.ventas WHERE tipo_producto = ? ");
                ResultSet results = ps.executeQuery();
                while (results.next()) {
                    ps.setString(1, tipoProduc);
                    Venta ventaa = new Venta();
                    String  tipoproducto = results.getString(tipoProduc);
                    String fechacompra = results.getString("fecha_compra");
                    int idproducto = results.getInt("id_producto");
                    String nombreproducto = results.getString("nombre_producto");
                    int cantidad = results.getInt("cantidad");
                    long precio = results.getLong("precio");
                    
                    ventaa.setTipoproducto(tipoproducto);
                    ventaa.setFechacompra(fechacompra);
                    ventaa.setIdproducto(idproducto);
                    ventaa.setNombreproducto(nombreproducto);
                    ventaa.setCantidad(cantidad);
                    ventaa.setPrecio(precio);
                    
                  
                    Venta venta1 = new Venta(fechacompra, idproducto, nombreproducto, tipoProduc, cantidad, precio);
                     ventas.add(venta1);
                }

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
                LOG.error("Error al listar producto venta" + ex);

            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return ventas;

    }

//    public Venta consultarTipo(Venta venta) {
//
//        AdmonConexion conn = new AdmonConexion();
//        Connection miconec = conn.getConnection();
//
//        if (miconec != null) {
//
//            PreparedStatement ps;
//            try {
//                ps = miconec.prepareStatement("SELECT fecha_compra, id_producto, nombre_producto, tipo_producto, cantidad, precio\n"
//                        + "	FROM public.ventas WHERE tipo_producto = ? ");
//
//                ps.setString(1, venta.getTipoproducto());
//                ResultSet results = ps.executeQuery();
//                String fechacompra = results.getString("fecha_compra");
//                int idproducto = results.getInt("id_producto");
//                String nombreproducto = results.getString("nombre_producto");
//                int cantidad = results.getInt("cantidad");
//                long precio = results.getLong("precio");
//
//                venta.setFechacompra(fechacompra);
//                venta.setIdproducto(idproducto);
//                venta.setNombreproducto(nombreproducto);
//                venta.setCantidad(cantidad);
//                venta.setPrecio(precio);
//
//            } catch (SQLException ex) {
//                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
//                LOG.error("Error al listar producto venta" + ex);
//
//            } finally {
//                conn.cerrarConnexion(miconec);
//            }
//        }
//        return venta;
//
//    }
//    public List<Venta> consultarTipo(String tipoProduc) {
//
//        AdmonConexion conn = new AdmonConexion();
//        Connection miconec = conn.getConnection();
//        List<Venta> ventas = new ArrayList<>();
//        if (miconec != null) {
//
//            PreparedStatement ps;
//            try {
//                ps = miconec.prepareStatement("SELECT fecha_compra, id_producto, nombre_producto, tipo_producto, cantidad, precio\n"
//                        + "	FROM public.ventas WHERE tipo_producto = tipo_producto ");
//                ResultSet results = ps.executeQuery();
//                while (results.next()) {
//                    ps.setString(1, tipoProduc);
//                    Venta ventaa = new Venta();
//                    String  tipoproducto = results.getString(tipoProduc);
//                    String fechacompra = results.getString("fecha_compra");
//                    int idproducto = results.getInt("id_producto");
//                    String nombreproducto = results.getString("nombre_producto");
//                    int cantidad = results.getInt("cantidad");
//                    long precio = results.getLong("precio");
//                    
//                    ventaa.setTipoproducto(tipoproducto);
//                    ventaa.setFechacompra(fechacompra);
//                    ventaa.setIdproducto(idproducto);
//                    ventaa.setNombreproducto(nombreproducto);
//                    ventaa.setCantidad(cantidad);
//                    ventaa.setPrecio(precio);
//                    
//                  
//                    Venta venta1 = new Venta(fechacompra, idproducto, nombreproducto, tipoProduc, cantidad, precio);
//                     ventas.add(venta1);
//                }
//
//            } catch (SQLException ex) {
//                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
//                LOG.error("Error al listar producto venta" + ex);
//
//            } finally {
//                conn.cerrarConnexion(miconec);
//            }
//        }
//        return ventas;
//
//    }
}
