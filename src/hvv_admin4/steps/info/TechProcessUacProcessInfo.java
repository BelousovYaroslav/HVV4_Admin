/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;

/**
 *
 * @author yaroslav
 */
public class TechProcessUacProcessInfo extends TechProcessStepCommon {
    private Double m_dblA_1000mcA;
    private Double m_dblA_1100mcA;
    private Double m_dblA_1200mcA;
    
    public Double Get_1000_A() { return m_dblA_1000mcA; }
    public void Set_1000_A( Double dbl) { m_dblA_1000mcA = dbl;}
    public Double Get_1100_A()  { return m_dblA_1100mcA; }
    public void Set_1100_A( Double dbl)  { m_dblA_1100mcA = dbl;}
    public Double Get_1200_A() { return m_dblA_1200mcA; }
    public void Set_1200_A( Double dbl) { m_dblA_1200mcA = dbl;}
    
    private Double m_dblT_1000mcA;
    private Double m_dblT_1100mcA;
    private Double m_dblT_1200mcA;
    
    public Double Get_1000_T() { return m_dblT_1000mcA; }
    public void Set_1000_T( Double dbl) { m_dblT_1000mcA = dbl;}
    public Double Get_1100_T()  { return m_dblT_1100mcA; }
    public void Set_1100_T( Double dbl)  { m_dblT_1100mcA = dbl;}
    public Double Get_1200_T() { return m_dblT_1200mcA; }
    public void Set_1200_T( Double dbl) { m_dblT_1200mcA = dbl;}
    
    public TechProcessUacProcessInfo( HVV_Admin4 app) {
        super( app);
        
        m_dblA_1000mcA = 0.;
        m_dblA_1100mcA = 0.;
        m_dblA_1200mcA = 0.;
        
        m_dblT_1000mcA = 0.;
        m_dblT_1100mcA = 0.;
        m_dblT_1200mcA = 0.;
    }
}
