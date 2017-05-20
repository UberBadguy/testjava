/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.dto;

import duoc.cl.jee010.miconstructora.entidades.BuildingSite;

/**
 *
 * @author cetecom
 */
public class BuildingSiteDTO {
    
    private static final long serialVersionUID = 1L;
    private BuildingSite buildingSite;

    public BuildingSiteDTO() {
    }

    public BuildingSiteDTO(BuildingSite buildingSite) {
        this.buildingSite = buildingSite;
    }

    public BuildingSite getBuildingSite() {
        return buildingSite;
    }

    public void setBuildingSite(BuildingSite buildingSite) {
        this.buildingSite = buildingSite;
    }
    
    
}
