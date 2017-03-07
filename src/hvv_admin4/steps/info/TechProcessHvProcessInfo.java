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
public class TechProcessHvProcessInfo extends TechProcessStepCommon {
    private Double m_dblVoltageAnStart;
    private Double m_dblVoltageAnStop;
    private Double m_dblVoltageTuStart;
    private Double m_dblVoltageTuStop;
    
    public Double GetAnStart() { return m_dblVoltageAnStart; }
    public void SetAnStart( Double dbl) { m_dblVoltageAnStart = dbl;}
    public Double GetAnStop()  { return m_dblVoltageAnStop; }
    public void SetAnStop( Double dbl)  { m_dblVoltageAnStop = dbl;}
    public Double GetTuStart() { return m_dblVoltageTuStart; }
    public void SetTuStart( Double dbl) { m_dblVoltageTuStart = dbl;}
    public Double GetTuStop()  { return m_dblVoltageTuStop; }
    public void SetTuStop( Double dbl) { m_dblVoltageTuStop = dbl;}
    
    public TechProcessHvProcessInfo( HVV_Admin4 app) {
        super( app);
        m_dblVoltageAnStart = 0.;
        m_dblVoltageAnStop  = 0.;
        m_dblVoltageTuStart = 0.;
        m_dblVoltageTuStop  = 0.;
    }
}
