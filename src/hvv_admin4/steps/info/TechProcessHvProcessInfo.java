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
    
    @Override
    public String toString() {
        String strResult = "\n";
        
        if( GetStartDate() == null)
            strResult += "dtStart: NULL" + "\n";
        else
            strResult += "dtStart: " + theApp.m_ReportGenerator.Gen_NiceDate(GetStartDate()) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime(GetStartDate()) + "\n";
        
        if( GetStartReportTitle() == null)
            strResult += "strStart: NULL" + "\n";
        else
            strResult += "strStart: " + GetStartReportTitle() + "\n";
        
        
        if( GetStopDate() == null)
            strResult += "dtStop: NULL" + "\n";
        else
            strResult += "dtStart: " + theApp.m_ReportGenerator.Gen_NiceDate(GetStopDate()) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime(GetStopDate()) + "\n";

        if( GetStopReportTitle() == null)
            strResult += "strStop: NULL" + "\n";
        else
            strResult += "strStop: " + GetStopReportTitle() + "\n";
        
        
        
        strResult += "m_dblVoltageAnStart: " + String.format( "%.03f", m_dblVoltageAnStart) + "\n";
        
        strResult += "m_dblVoltageAnStop: " + String.format(  "%.03f", m_dblVoltageAnStop) + "\n";
        
        strResult += "m_dblVoltageTuStart: " + String.format( "%.03f", m_dblVoltageTuStart) + "\n";
        
        strResult += "m_dblVoltageTuStop: " + String.format(  "%.03f", m_dblVoltageTuStop) + "\n";
        
        return strResult;
    }
}
