/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Province;

/**
 *
 * @author cetecom
 */
public class ProvinceDTO {
    
    private static final long serialVersionUID = 1L;
    private Province province;

    public ProvinceDTO() {
    }

    public ProvinceDTO(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    
}
