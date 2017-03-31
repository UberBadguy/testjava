/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.negocio;

import duoc.cl.jee010.unidad1.entidades.Producto;
import duoc.cl.jee010.unidad1.persistencia.ProductoDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ProductoBO {
    private ProductoDAO objProductoDAO;

    public ProductoBO() {
        this.objProductoDAO= new ProductoDAO();
    }
    
    public List<Producto> getAllProductos(){
        return this.objProductoDAO.readElementos();
    }
    
    public Producto buscaProductoXCodigo(int codigo){
        return this.objProductoDAO.buscaProducto(codigo);
    }
}
