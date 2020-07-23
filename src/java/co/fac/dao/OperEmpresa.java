package co.fac.dao;

import co.fac.dto.Empresa;
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
public class OperEmpresa implements Operaciones {

    private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);
    
    public int insertar(Empresa empresa) {
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("INSERT INTO public.empresas(\n"
                        + "	usuario, contrasena, direccion, telefono, nit, privilegio)\n"
                        + "	VALUES (?, ?, ?, ?, ?, ?)");

                ps.setString(1, empresa.getUsuario());
                ps.setString(2, empresa.getContrasena());
                ps.setString(3, empresa.getDireccion());
                ps.setInt(4, empresa.getTelefono());
                ps.setInt(5, empresa.getNit());
                ps.setString(6, empresa.getPrivilegio());

                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                // Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al insertar empresa", ex);
                LOG.error("Error al insertar el usuario" + ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return 0;
    }

    public int actualizar(Empresa empresa) {
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("UPDATE public.empresas SET contrasena=?, direccion=?, telefono=?, nit=?, privilegio=? WHERE usuario=?");
                ps.setString(6, empresa.getUsuario());
                ps.setString(1, empresa.getContrasena());
                ps.setString(2, empresa.getDireccion());
                ps.setInt(3, empresa.getTelefono());
                ps.setInt(4, empresa.getNit());
                ps.setString(5, empresa.getPrivilegio());

                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al actualizar Empresa", ex);
                 LOG.error("Error al actualizar el usuario" + ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }

        return 0;

    }

    public int borrar(String pk) {
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("DELETE FROM public.empresas WHERE usuario=?");
                ps.setString(1, pk);

                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al borrar ", ex);
                 LOG.error("Error al borrar el usuario" + ex);
                
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }

        return 0;
    }

    public List<Empresa> Listar() {
        List<Empresa> lista = new ArrayList<>();

        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {

            PreparedStatement ps;
            try {
                ps = miconec.prepareStatement("SELECT usuario, contrasena, direccion, telefono, nit, privilegio\n"
                        + "	FROM public.empresas");

                ResultSet results = ps.executeQuery();

                while (results.next()) {

                    lista.add(new Empresa(results.getString(1), results.getString(2), results.getString(3), results.getInt(4), results.getInt(5),results.getString(6)));
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

    public int iniciarSesion(Empresa usuario) {

        Empresa e = null;
        int resultado = 0;
        //Se crea la conexion a la BD
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();

        //Si se conecto exitosamente
        if (miconec != null) {

            try {
                PreparedStatement ps;
                ps = miconec.prepareStatement("SELECT usuario, contrasena, privilegio FROM public.empresas "
                        + "where usuario=? and contrasena=?");

                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getContrasena());

                ResultSet results = ps.executeQuery();

                if (results.next()) {
                    e = new Empresa(results.getString(1), results.getString(2), results.getString(3));

                }

                if (e == null) {

                    resultado = 0;

                } else if (e.getPrivilegio().equals("Administrador")) {

                    resultado = 1;
                    LOG.info("USUARIO ADMINISTRADOR INGRESO CON EL USUARIO: " + e.getUsuario());

                    //Caso de ser cliente
                } else {
                    resultado = 2;
                    LOG.info("USUARIO CLIENTE INGRESO CON EL USUARIO: " + e.getUsuario());
                }

            } catch (SQLException ex) {
                //Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al iniciar sesión", ex);
                LOG.error("Error al iniciar sesión" + ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }

        }

        return resultado;
    }
}
