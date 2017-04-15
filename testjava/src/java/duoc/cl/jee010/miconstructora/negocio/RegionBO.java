/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.Region;
import duoc.cl.jee010.miconstructora.persistencia.RegionDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class RegionBO {
    private RegionDAO objRegionDAO;

    public RegionBO() {
        this.objRegionDAO= new RegionDAO();
    }
    
    public List<Region> listadoRegiones(){
        return this.objRegionDAO.listAll();
    }
    
}
