/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
import java.util.List;

/**
 *
 * @author cetecom
 */
public class BuildingSitesDTO {
    
    private static final long serialVersionUID = 1L;
    private List<BuildingSite> buildingSites;

    public BuildingSitesDTO() {
    }

    public BuildingSitesDTO(List<BuildingSite> buildingSites) {
        this.buildingSites = buildingSites;
    }

    public List<BuildingSite> getBuildingSites() {
        return buildingSites;
    }

    public void setBuildingSites(List<BuildingSite> buildingSites) {
        this.buildingSites = buildingSites;
    }
    
    
}
