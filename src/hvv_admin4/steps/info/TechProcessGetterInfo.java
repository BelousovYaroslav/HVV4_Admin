/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 *
 * @author yaroslav
 */
public class TechProcessGetterInfo extends TechProcessStepCommon {
    
    public TechProcessGetterInfo(HVV_Admin4 app) {
        super(app);
    }
    
    public TechProcessGetterInfo( HVV_Admin4 app, ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( app, is);
        m_dtEffusion4v = ( Date) is.readObject();
        m_dblEffusion4v = is.readDouble();
        m_dtEffusion9v = ( Date) is.readObject();
        m_dblEffusion9v = is.readDouble();
        m_dtTurnOff9v = ( Date) is.readObject();
    }
    
    private Date m_dtEffusion4v;
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

        //4v
        if( m_dtEffusion4v == null)
            strResult += "m_dtEffusion4v: NULL" + "\n";
        else
            strResult += "m_dtEffusion4v: " + theApp.m_ReportGenerator.Gen_NiceDate( m_dtEffusion4v) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime( m_dtEffusion4v) + "\n";
        
        strResult += "m_dblEffusion4v: " + String.format( "%.03f", m_dblEffusion4v);
        
        //9v
        if( m_dtEffusion9v == null)
            strResult += "m_dtEffusion9v: NULL" + "\n";
        else
            strResult += "m_dtEffusion9v: " + theApp.m_ReportGenerator.Gen_NiceDate( m_dtEffusion9v) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime( m_dtEffusion9v) + "\n";
        
        strResult += "m_dblEffusion9v: " + String.format( "%.03f", m_dblEffusion9v);
        
        //dt9off
        if( m_dtTurnOff9v == null)
            strResult += "m_dtTurnOff9v: NULL" + "\n";
        else
            strResult += "m_dtTurnOff9v: " + theApp.m_ReportGenerator.Gen_NiceDate( m_dtTurnOff9v) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime( m_dtTurnOff9v) + "\n";
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeObject( m_dtEffusion4v);
        out.writeDouble( m_dblEffusion4v);
        out.writeObject( m_dtEffusion9v);
        out.writeDouble( m_dblEffusion9v);
        out.writeObject( m_dtTurnOff9v);
    }
}
