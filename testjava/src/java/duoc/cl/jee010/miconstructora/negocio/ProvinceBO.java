/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Page;
import duoc.cl.jee010.miconstructora.persistencia.ProvinceDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ProvinceBO {
    private ProvinceDAO objProvinceDAO;

    public ProvinceBO() {
        this.objProvinceDAO= new ProvinceDAO();
    }
    
    public List<Page>listadoRegiones(int regionId){
        return this.objProvinceDAO.listByRegion(regionId);
    }
    
}
