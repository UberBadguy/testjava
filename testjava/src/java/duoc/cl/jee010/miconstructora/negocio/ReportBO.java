/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.negocio;

import duoc.cl.jee010.miconstructora.dto.ReportEmployeeDTO;
import duoc.cl.jee010.miconstructora.persistencia.ReportDAO;
import java.util.List;

/**
 *
 * @author amontess
 */
public class ReportBO {
    
    private final ReportDAO objReportDAO;
    
    public ReportBO() {
        this.objReportDAO=new ReportDAO();
    }
    
    public List<ReportEmployeeDTO> reportBuildingSitebyEmployee(int building_site_id){
        return objReportDAO.buildingSiteXEmployee(building_site_id);
    }
    
    public List<ReportEmployeeDTO> reportBuildingSitebyWorker(int building_site_id){
        return objReportDAO.buildingSiteXWorker(building_site_id);
    }
    
}
