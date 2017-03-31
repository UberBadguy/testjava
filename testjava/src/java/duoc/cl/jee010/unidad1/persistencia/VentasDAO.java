/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.persistencia;

import duoc.cl.jee010.unidad1.entidades.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author amontess
 */
public class VentasDAO implements ICrud {

    public VentasDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addElemento(List<Ventas> listadoVentas) {
        boolean estado = false;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = null;
            for (Ventas objVenta : listadoVentas) {
                String query = "INSERT INTO VENTA VALUES(0,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setString(1, objVenta.getCodigo_venta());
                ps.setInt(2, objVenta.getCantidad_venta());
                ps.setInt(3, objVenta.getId_producto());
                ps.setInt(4, objVenta.getId_usuario());
                try {
                    estado = ps.executeUpdate() == 1;
                } catch (Exception e) {
                    System.out.println("problemas al insertar");
                    return false;
                }
            }

        } catch (Exception e) {
            System.out.println("problemas al insertar");
            return false;
        }
        return estado;
    }

    @Override
    public List readElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
