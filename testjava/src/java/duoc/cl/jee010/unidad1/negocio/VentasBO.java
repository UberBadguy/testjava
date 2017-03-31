/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.negocio;

import duoc.cl.jee010.unidad1.entidades.Ventas;
import duoc.cl.jee010.unidad1.persistencia.VentasDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class VentasBO {
    private VentasDAO objVentasDAO;

    public VentasBO() {
        this.objVentasDAO= new VentasDAO();
    }
    
    public boolean guardalistadoVentas(List<Ventas> listadoVentas){
        return this.objVentasDAO.addElemento(listadoVentas);
    }
    
}
