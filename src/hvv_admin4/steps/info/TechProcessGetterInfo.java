/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;
import java.util.Date;

/**
 *
 * @author yaroslav
 */
public class TechProcessGetterInfo extends TechProcessStepCommon {
    
    private Date m_dtEffusion4v;

    public TechProcessGetterInfo(HVV_Admin4 app) {
        super(app);
    }
    
    public Date GetDtEffusion4v() { return m_dtEffusion4v;}
    public void SetDtEffusion4v( Date dt) { m_dtEffusion4v = dt;}
    
    private double m_dblEffusion4v;
    public double GetDblEffusion4v() { return m_dblEffusion4v;}
    public void SetDblEffusion4v( double dt) { m_dblEffusion4v = dt;}
    
    private Date m_dtEffusion9v;
    public Date GetDtEffusion9v() { return m_dtEffusion9v;}
    public void SetDtEffusion9v( Date dt) { m_dtEffusion9v = dt;}
    
    private double m_dblEffusion9v;
    public double GetDblEffusion9v() { return m_dblEffusion9v;}
    public void SetDblEffusion9v( double dt) { m_dblEffusion9v = dt;}
    
    private Date m_dtTurnOff9v;
    public Date GetDtTurnOff9v() { return m_dtTurnOff9v;}
    public void SetDtTurnOff9v( Date dt) { m_dtTurnOff9v = dt;}
}
