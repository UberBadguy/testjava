/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.persistencia;

import duoc.cl.jee010.unidad1.entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ProductoDAO implements ICrud {

    public ProductoDAO() {
    }

    @Override
    public boolean addElemento(Object objetoInsert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List readElementos() {
        List<Producto> listadoProducto = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM PRODUCTO";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int x = rs.getRow();
            while (rs.next()) {
                Producto objProducto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listadoProducto.add(objProducto);
            }
        } catch (Exception e) {
            System.out.println("problemas al acceder a la bd "+e.getMessage());
        }
        return listadoProducto;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Producto buscaProducto(int codigo){
        Producto objProducto = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            int x = rs.getRow();
            while (rs.next()) {
                objProducto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));                
            }
        } catch (Exception e) {
            System.out.println("problemas al acceder a la bd "+e.getMessage());
        }
        return objProducto;
    }

}
