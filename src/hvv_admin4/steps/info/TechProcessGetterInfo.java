/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.report.ReportGenerator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dom4j.Element;

/**
 *
 * @author yaroslav
 */
public class TechProcessGetterInfo extends TechProcessStepCommon {
    
    public TechProcessGetterInfo() {
        super();
    }
    
    public TechProcessGetterInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
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
            strResult += "dtStart: " + ReportGenerator.Gen_NiceDate(GetStartDate()) +
                         " " + ReportGenerator.Gen_NiceTime(GetStartDate()) + "\n";
        
        if( GetStartReportTitle() == null)
            strResult += "strStart: NULL" + "\n";
        else
            strResult += "strStart: " + GetStartReportTitle() + "\n";
        
        
        if( GetStopDate() == null)
            strResult += "dtStop: NULL" + "\n";
        else
            strResult += "dtStop: " + ReportGenerator.Gen_NiceDate(GetStopDate()) +
                         " " + ReportGenerator.Gen_NiceTime(GetStopDate()) + "\n";
        
        if( GetStopReportTitle() == null)
            strResult += "strStop: NULL" + "\n";
        else
            strResult += "strStop: " + GetStopReportTitle() + "\n";

        //4v
        if( m_dtEffusion4v == null)
            strResult += "m_dtEffusion4v: NULL" + "\n";
        else
            strResult += "m_dtEffusion4v: " + ReportGenerator.Gen_NiceDate( m_dtEffusion4v) +
                         " " + ReportGenerator.Gen_NiceTime( m_dtEffusion4v) + "\n";
        
        strResult += "m_dblEffusion4v: " + String.format( "%.03f\n", m_dblEffusion4v);
        
        //9v
        if( m_dtEffusion9v == null)
            strResult += "m_dtEffusion9v: NULL" + "\n";
        else
            strResult += "m_dtEffusion9v: " + ReportGenerator.Gen_NiceDate( m_dtEffusion9v) +
                         " " + ReportGenerator.Gen_NiceTime( m_dtEffusion9v) + "\n";
        
        strResult += "m_dblEffusion9v: " + String.format( "%.03f\n", m_dblEffusion9v);
        
        //dt9off
        if( m_dtTurnOff9v == null)
            strResult += "m_dtTurnOff9v: NULL" + "\n";
        else
            strResult += "m_dtTurnOff9v: " + ReportGenerator.Gen_NiceDate( m_dtTurnOff9v) +
                         " " + ReportGenerator.Gen_NiceTime( m_dtTurnOff9v) + "\n";
        
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
    
    @Override
    public void SaveItemXML( Element root, String strTitle) throws IOException {
        super.SaveItemXML( root, strTitle);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy.MM.dd HH:mm:ss");
        
        if( m_dtEffusion4v != null)
            root.addElement( "dtEffusion4v").addText( formatter.format( m_dtEffusion4v));
        else
            root.addElement( "dtEffusion4v").addText( "NULL");
        
        root.addElement( "dblEffusuon4v").addText( String.format( "%.0f", m_dblEffusion4v));
        
        if( m_dtEffusion9v != null)
            root.addElement( "dtEffusion9v").addText( formatter.format( m_dtEffusion9v));
        else
            root.addElement( "dtEffusion9v").addText( "NULL");
        
        root.addElement( "dblEffusuon9v").addText( String.format( "%.0f", m_dblEffusion9v));
        
        if( m_dtTurnOff9v != null)
            root.addElement( "dtTurnOff9v").addText( formatter.format( m_dtTurnOff9v));
        else
            root.addElement( "dtTurnOff9v").addText( "NULL");
    }
    
}
