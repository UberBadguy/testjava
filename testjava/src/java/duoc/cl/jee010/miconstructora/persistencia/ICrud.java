/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import java.util.List;

/**
 *
 * @author amontess
 */
public interface ICrud {
    
    public boolean addElement(Object insertObject);

    public List readElements();

    public boolean updateElement(Object updateObject);

    public boolean deleteElement(int codigo);
    
    public Object getElement(int codigo);
}
