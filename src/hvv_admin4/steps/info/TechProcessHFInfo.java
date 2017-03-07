/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;
import java.util.LinkedList;

/**
 *
 * @author yaroslav
 */
public class TechProcessHFInfo extends TechProcessStepCommon {
    public LinkedList m_lstProgram;
    
    private int m_nGetter;
    public int GetGetter() { return m_nGetter; }
    public void SetGetter( int nGetter) { m_nGetter = nGetter; }
    
    public int m_nInductor;
    public int GetInductor() { return m_nInductor; }
    public void SetInductor( int nInductor) { m_nInductor = nInductor; }
    
    public TechProcessHFInfo( HVV_Admin4 app) {
        super( app);
        
        m_nGetter = -1;
        m_nInductor = -1;
    }
}
