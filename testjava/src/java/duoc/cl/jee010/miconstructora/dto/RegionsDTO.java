/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.Region;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class RegionsDTO {
    
    private static final long serialVersionUID = 1L;
    private List<Region> regions;

    public RegionsDTO() {
    }

    public RegionsDTO(List<Region> regions) {
        this.regions = regions;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
    
    
}
