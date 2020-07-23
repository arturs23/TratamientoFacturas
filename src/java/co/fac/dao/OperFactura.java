package co.fac.dao;

import co.fac.dto.Cliente;
import co.fac.dto.Factura;
import co.fac.dto.Producto;
import co.fac.dto.Zona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Sebastian Gordillo
 */
public class OperFactura {

    private static final Logger LOG = LogManager.getLogger(OperFactura.class);

    public void insertarBD(File leer) {

        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();

        if (miconec != null) {

            Cliente cliente;
            Factura factura;
            Producto producto;
            Zona zona;

            try {

                PreparedStatement psTabla1 = miconec.prepareStatement("INSERT INTO public.clientes(\n"
                        + "	nombre, cedula, apellido)\n"
                        + "	VALUES (?, ?, ?)");

                PreparedStatement psTabla2 = miconec.prepareStatement("INSERT INTO public.facturas(\n"
                        + "	idfactura, fecha, hora, valor)\n"
                        + "	VALUES (?, ?, ?, ?)");

                PreparedStatement psTabla3 = miconec.prepareStatement("INSERT INTO public.productos(\n"
                        + "	idproducto, producto, marca, items)\n"
                        + "	VALUES (?, ?, ?, ?)");

                PreparedStatement psTabla4 = miconec.prepareStatement("INSERT INTO public.zonas(\n"
                        + "	idzona, localidad)\n"
                        + "	VALUES (?, ?)");

                int conteo = 0;
                String cadena;
                FileReader f = new FileReader(leer);
                BufferedReader b = new BufferedReader(f);

                while ((cadena = b.readLine()) != null) {
                    conteo++;
                    //Separo en un vector por comas
                    String registro[] = cadena.split(",");
                    System.out.println("Vector: " + Arrays.toString(registro));

                    cliente = new Cliente((registro[0]), (Integer.parseInt(registro[1])), registro[2]);
                    
                    Date fecha = Date.valueOf(registro[4]);
                    factura = new Factura((Integer.parseInt(registro[3])), fecha, (registro[5]), 
                            (Long.parseLong(registro[6])));
                    
                    producto = new Producto((Integer.parseInt(registro[7])), (registro[8]), (registro[9]),
                            (Integer.parseInt(registro[10])));
                    
                    zona = new Zona((Integer.parseInt(registro[11])), (registro[12]));

                    if ((registro.length) == 13) {

                        //Tabla clientes
                        psTabla1.setString(1, cliente.getNombre());
                        psTabla1.setInt(2, cliente.getCedula());
                        psTabla1.setString(3, cliente.getApellido());
                        psTabla1.executeUpdate();

                        //Tabla facturas
                        psTabla2.setInt(1, factura.getIdFactura());
                        //ps2.setDate(2, new java.sql.Date(convertido.getTime()));
                        psTabla2.setDate(2, factura.getFecha());
                        psTabla2.setString(3, factura.getHora());
                        psTabla2.setDouble(4, factura.getValor());
                        psTabla2.executeUpdate();

                        //Tabla productos
                        psTabla3.setInt(1, producto.getIdProducto());
                        psTabla3.setString(2, producto.getNombre());
                        psTabla3.setString(3, producto.getMarca());
                        psTabla3.setInt(4, producto.getItems());
                        psTabla3.executeUpdate();

                        //Tabla zona
                        psTabla4.setInt(1, zona.getIdzona());
                        psTabla4.setString(2, zona.getLocalidad());
                        psTabla4.executeUpdate();

                    } else {
                        System.out.println("El registro de la linea " + conteo + " esta incompleto");
                    }

                }
                b.close();

            } catch (SQLException ex) {
                // Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al insertar empresa", ex);
                LOG.error("Error al insertar en la base de datos" + ex);
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }

    }

}
