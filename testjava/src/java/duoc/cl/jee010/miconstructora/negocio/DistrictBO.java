/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.entidades.District;
import duoc.cl.jee010.miconstructora.persistencia.DistrictDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class DistrictBO {
    private DistrictDAO objDistrictDAO;

    public DistrictBO() {
        this.objDistrictDAO= new DistrictDAO();
    }
    
    public List<District>listadoComunas(int provinceId){
        return this.objDistrictDAO.listByProvince(provinceId);
    }
    
}
