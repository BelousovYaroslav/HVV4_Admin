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
public class TechProcessIgenIextProcessInfo extends TechProcessStepCommon {
    private Double m_dblA_Igen;
    private Double m_dblA_Iext;
    
    public Double Get_Igen_A() { return m_dblA_Igen; }
    public void Set_Igen_A( Double dbl) { m_dblA_Igen = dbl;}
    public Double Get_Iext_A()  { return m_dblA_Iext; }
    public void Set_Iext_A( Double dbl)  { m_dblA_Iext = dbl;}

    private Double m_dblT_Igen;
    private Double m_dblT_Iext;

    public Double Get_Igen_T() { return m_dblT_Igen; }
    public void Set_Igen_T( Double dbl) { m_dblT_Igen = dbl;}
    public Double Get_Iext_T()  { return m_dblT_Iext; }
    public void Set_Iext_T( Double dbl)  { m_dblT_Iext = dbl;}
        
    public TechProcessIgenIextProcessInfo( HVV_Admin4 app) {
        super( app);
        
        m_dblA_Igen = 0.;
        m_dblA_Iext = 0.;
        
        m_dblT_Igen = 0.;
        m_dblT_Iext = 0.;
    }
}
