/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.District;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class DistrictsDTO {
    
    private static final long serialVersionUID = 1L;
    private List<District> districts;

    public DistrictsDTO() {
    }

    public DistrictsDTO(List<District> districts) {
        this.districts = districts;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
    
}
