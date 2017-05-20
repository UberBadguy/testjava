/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Province;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class ProvincesDTO {
    
    private static final long serialVersionUID = 1L;
    private List<Province> province;

    public ProvincesDTO() {
    }

    public ProvincesDTO(List<Province> province) {
        this.province = province;
    }

    public List<Province> getProvince() {
        return province;
    }

    public void setProvince(List<Province> province) {
        this.province = province;
    }
    
}
