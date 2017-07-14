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
public class TechProcessStepCommon {
    HVV_Admin4 theApp;
    
    //START
    private Date m_dtStart;
    public Date GetStartDate() { return m_dtStart;}
    public void SetStartDate( Date dt) { m_dtStart = dt;}
    public void SetStartDateAsCurrent() { m_dtStart = theApp.GetLocalDate();}
    
    private String m_strStartReportTitle;
    public String GetStartReportTitle() { return m_strStartReportTitle;}
    public void SetStartReportTitle( String strStartReportTitle) { m_strStartReportTitle = strStartReportTitle;}
    
    
    // STOP
    private Date m_dtStop;
    public Date GetStopDate() { return m_dtStop;}
    public void SetStopDate( Date dt) { m_dtStop = dt;}
    public void SetStopDateAsCurrent() { m_dtStop = theApp.GetLocalDate();}
    
    private String m_strStopReportTitle;
    public String GetStopReportTitle() { return m_strStopReportTitle;}
    public void SetStopReportTitle( String strStopReportTitle) { m_strStopReportTitle = strStopReportTitle;}
    
    
    
    public TechProcessStepCommon( HVV_Admin4 app) {
        theApp = app;
        
        m_strStartReportTitle = null;
        m_strStopReportTitle = null;
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
        
        
        return strResult;
    }
}
