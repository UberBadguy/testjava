/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.District;

/**
 *
 * @author cetecom
 */
public class DistrictDTO {
    
    private static final long serialVersionUID = 1L;
    private District district;

    public DistrictDTO() {
    }

    public DistrictDTO(District district) {
        this.district = district;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
}
