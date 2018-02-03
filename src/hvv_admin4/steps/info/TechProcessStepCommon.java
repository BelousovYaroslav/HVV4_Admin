/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.report.ReportGenerator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dom4j.Element;

/**
 *
 * @author yaroslav
 */
public class TechProcessStepCommon {
    private boolean m_bRestoredAfterFail;
    public void SetRestoredAfterFailFlag( boolean bVal) { m_bRestoredAfterFail = bVal;}
    
    //START
    private Date m_dtStart;
    public Date GetStartDate() { return m_dtStart;}
    public void SetStartDate( Date dt) { m_dtStart = dt;}
    public void SetStartDateAsCurrent( int nHourShift) { m_dtStart = GetLocalDate( nHourShift);}
    
    private String m_strStartReportTitle;
    public String GetStartReportTitle() { return m_strStartReportTitle;}
    public void SetStartReportTitle( String strStartReportTitle) { m_strStartReportTitle = strStartReportTitle;}
    
    
    // STOP
    private Date m_dtStop;
    public Date GetStopDate() { return m_dtStop;}
    public void SetStopDate( Date dt) { m_dtStop = dt;}
    public void SetStopDateAsCurrent( int nHourShift) { m_dtStop = GetLocalDate( nHourShift);}
    
    private String m_strStopReportTitle;
    public String GetStopReportTitle() { return m_strStopReportTitle;}
    public void SetStopReportTitle( String strStopReportTitle) { m_strStopReportTitle = strStopReportTitle;}
    
    
    
    public TechProcessStepCommon() {
        m_strStartReportTitle = null;
        m_strStopReportTitle = null;
        m_bRestoredAfterFail = false;
    }
    
    public TechProcessStepCommon( ObjectInputStream is)  throws IOException, ClassNotFoundException {
        m_dtStart               = ( Date) is.readObject();
        m_strStartReportTitle   = ( String) is.readObject();
        m_dtStop                = ( Date) is.readObject();
        m_strStopReportTitle    = ( String) is.readObject();
        m_bRestoredAfterFail = false;
    }
    
    public TechProcessStepCommon( Element root)  throws IOException, ClassNotFoundException {
        /*
        m_dtStart               = ( Date) is.readObject();
        m_strStartReportTitle   = ( String) is.readObject();
        m_dtStop                = ( Date) is.readObject();
        m_strStopReportTitle    = ( String) is.readObject();
        m_bRestoredAfterFail = false;
        */
    }
    
    @Override
    public String toString() {
        String strResult = "\n";
        
        if( GetStartDate() == null)
            strResult += "dtStart: NULL" + "\n";
        else
            strResult += "dtStart: " + ReportGenerator.Gen_NiceDate( GetStartDate()) +
                                 " " + ReportGenerator.Gen_NiceTime( GetStartDate()) + "\n";
        
        if( GetStartReportTitle() == null)
            strResult += "strStart: NULL" + "\n";
        else
            strResult += "strStart: " + GetStartReportTitle() + "\n";
        
        
        if( GetStopDate() == null)
            strResult += "dtStop: NULL" + "\n";
        else
            strResult += "dtStart: " + ReportGenerator.Gen_NiceDate( GetStopDate()) +
                                 " " + ReportGenerator.Gen_NiceTime( GetStopDate()) + "\n";
        
        if( GetStopReportTitle() == null)
            strResult += "strStop: NULL" + "\n";
        else
            strResult += "strStop: " + GetStopReportTitle() + "\n";
        
        
        return strResult;
    }
    
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        out.writeObject( m_dtStart);
        out.writeObject( m_strStartReportTitle);
        out.writeObject( m_dtStop);
        out.writeObject( m_strStopReportTitle);
    }
    
    public void SaveItemXML( Element root, String strTitle) throws IOException {
        
        if( strTitle != null)
            root.addElement( "Title").addText( strTitle);
        else
            root.addElement( "Title").addText( "NULL");
        
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy.MM.dd HH:mm:ss");
        if( m_dtStart != null)
            root.addElement( "dtStart").addText( formatter.format( m_dtStart));
        else
            root.addElement( "dtStart").addText( "NULL");
        
        if( m_strStartReportTitle != null)
            root.addElement( "strStartReportTitle").addText( m_strStartReportTitle);
        else
            root.addElement( "strStartReportTitle").addText( "NULL");
        
        
        if( m_dtStop != null)
            root.addElement( "dtStop").addText( formatter.format( m_dtStop));
        else
            root.addElement( "dtStop").addText( "NULL");
        
        if( m_strStopReportTitle != null)
            root.addElement( "strStopReportTitle").addText( m_strStopReportTitle);
        else
            root.addElement( "strStopReportTitle").addText( "NULL");
    }
    
    public Date GetLocalDate( int nShiftHour) {
        return new Date( System.currentTimeMillis() - 1000 * 60 * 60 * nShiftHour);
    }
}
