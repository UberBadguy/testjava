/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Region;

/**
 *
 * @author cetecom
 */
public class RegionDTO {
    
    private static final long serialVersionUID = 1L;
    private Region region;

    public RegionDTO() {
    }

    public RegionDTO(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
}
