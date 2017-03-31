/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.unidad1.persistencia;

import java.util.List;

/**
 *
 * @author amontess
 */
public interface ICrud {
    
    public boolean addElemento(Object objetoInsert);

    public List readElementos();

    public boolean updateElemento(Object objetoUpdate);

    public boolean deleteElemento(int codigo);
}
