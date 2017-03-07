/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

/**
 *
 * @author yaroslav
 */
public class TechProcessDegasationStepInfo {
    private int m_nDuration;
    public void SetDuration( int nNewVal) { m_nDuration = nNewVal;}
    public int GetDuration() { return m_nDuration;}
    
    private int m_nPower;
    public void SetPower( int nNewVal) { m_nPower = nNewVal;}
    public int GetPower() { return m_nPower;}
    
    private double m_dblMaxPressure;
    public void SetMaxPressure( double dblNewVal) { m_dblMaxPressure = dblNewVal;}
    public double GetMaxPressure() { return m_dblMaxPressure;}
    
    public TechProcessDegasationStepInfo() {
        m_nDuration = 0;
        m_nPower = 0;
        m_dblMaxPressure = Double.NaN;
    }
    
    public TechProcessDegasationStepInfo( int nDuration, int nPower) {
        m_nDuration = nDuration;
        m_nPower = nPower;
        m_dblMaxPressure = Double.NaN;
    }
    
}
