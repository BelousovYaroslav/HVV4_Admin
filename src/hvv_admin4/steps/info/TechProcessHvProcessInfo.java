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
import org.dom4j.Element;

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
    
    public TechProcessHvProcessInfo() {
        super();
        m_dblVoltageAnStart = 0.;
        m_dblVoltageAnStop  = 0.;
        m_dblVoltageTuStart = 0.;
        m_dblVoltageTuStop  = 0.;
    }
    
    public TechProcessHvProcessInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_dblVoltageAnStart = is.readDouble();
        m_dblVoltageTuStart = is.readDouble();
        m_dblVoltageAnStop  = is.readDouble();
        m_dblVoltageTuStop  = is.readDouble();
    }
    
    public TechProcessHvProcessInfo( Element root) throws IOException, ClassNotFoundException {
        super( root);
        /*
        m_dblVoltageAnStart = is.readDouble();
        m_dblVoltageTuStart = is.readDouble();
        m_dblVoltageAnStop  = is.readDouble();
        m_dblVoltageTuStop  = is.readDouble();
        */
    }
    
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
        
        
        
        strResult += "m_dblVoltageAnStart: " + String.format( "%.03f", m_dblVoltageAnStart) + "\n";
        
        strResult += "m_dblVoltageAnStop: " + String.format(  "%.03f", m_dblVoltageAnStop) + "\n";
        
        strResult += "m_dblVoltageTuStart: " + String.format( "%.03f", m_dblVoltageTuStart) + "\n";
        
        strResult += "m_dblVoltageTuStop: " + String.format(  "%.03f", m_dblVoltageTuStop) + "\n";
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeDouble( m_dblVoltageAnStart);
        out.writeDouble( m_dblVoltageTuStart);
        out.writeDouble( m_dblVoltageAnStop);
        out.writeDouble( m_dblVoltageTuStop);
    }
    
    @Override
    public void SaveItemXML( Element root) throws IOException {
        super.SaveItemXML( root);
        root.addElement( "AnStartV").addText( String.format( "%.0f", m_dblVoltageAnStart));
        root.addElement( "TuStartV").addText( String.format( "%.0f", m_dblVoltageTuStart));
        root.addElement( "AnStopV").addText( String.format( "%.0f", m_dblVoltageAnStop));
        root.addElement( "TuStopV").addText( String.format( "%.0f", m_dblVoltageTuStop));
    }
}
