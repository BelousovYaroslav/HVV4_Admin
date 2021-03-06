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
public class TechProcessUacProcessInfo extends TechProcessStepCommon {
    private Double m_dblA_1000mcA;
    private Double m_dblA_1100mcA;
    private Double m_dblA_1200mcA;
    
    public Double Get_1000_A() { return m_dblA_1000mcA; }
    public void Set_1000_A( Double dbl) { m_dblA_1000mcA = dbl;}
    public Double Get_1100_A()  { return m_dblA_1100mcA; }
    public void Set_1100_A( Double dbl)  { m_dblA_1100mcA = dbl;}
    public Double Get_1200_A() { return m_dblA_1200mcA; }
    public void Set_1200_A( Double dbl) { m_dblA_1200mcA = dbl;}
    
    private Double m_dblT_1000mcA;
    private Double m_dblT_1100mcA;
    private Double m_dblT_1200mcA;
    
    public Double Get_1000_T() { return m_dblT_1000mcA; }
    public void Set_1000_T( Double dbl) { m_dblT_1000mcA = dbl;}
    public Double Get_1100_T()  { return m_dblT_1100mcA; }
    public void Set_1100_T( Double dbl)  { m_dblT_1100mcA = dbl;}
    public Double Get_1200_T() { return m_dblT_1200mcA; }
    public void Set_1200_T( Double dbl) { m_dblT_1200mcA = dbl;}
    
    public TechProcessUacProcessInfo() {
        super();
        
        m_dblA_1000mcA = 0.;
        m_dblA_1100mcA = 0.;
        m_dblA_1200mcA = 0.;
        
        m_dblT_1000mcA = 0.;
        m_dblT_1100mcA = 0.;
        m_dblT_1200mcA = 0.;
    }
    
    public TechProcessUacProcessInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_dblA_1000mcA = is.readDouble();
        m_dblA_1100mcA = is.readDouble();
        m_dblA_1200mcA = is.readDouble();
        m_dblT_1000mcA = is.readDouble();
        m_dblT_1100mcA = is.readDouble();
        m_dblT_1200mcA = is.readDouble();
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
        
        
        
        strResult += "m_dblA_1000mcA: " + String.format( "%.03f", m_dblA_1000mcA);
        strResult += "m_dblA_1100mcA: " + String.format( "%.03f", m_dblA_1100mcA);
        strResult += "m_dblA_1200mcA: " + String.format( "%.03f", m_dblA_1200mcA);
        
        strResult += "m_dblT_1000mcA: " + String.format( "%.03f", m_dblT_1000mcA);
        strResult += "m_dblT_1100mcA: " + String.format( "%.03f", m_dblT_1100mcA);
        strResult += "m_dblT_1200mcA: " + String.format( "%.03f", m_dblT_1200mcA);
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeDouble( m_dblA_1000mcA);
        out.writeDouble( m_dblA_1100mcA);
        out.writeDouble( m_dblA_1200mcA);
        out.writeDouble( m_dblT_1000mcA);
        out.writeDouble( m_dblT_1100mcA);
        out.writeDouble( m_dblT_1200mcA);
    }
    
    @Override
    public void SaveItemXML( Element root, String strTitle) throws IOException {
        super.SaveItemXML( root, strTitle);
        
        root.addElement( "dblA_1000mcA").addText( String.format( "%.0f", m_dblA_1000mcA));
        root.addElement( "dblA_1100mcA").addText( String.format( "%.0f", m_dblA_1100mcA));
        root.addElement( "dblA_1200mcA").addText( String.format( "%.0f", m_dblA_1200mcA));
        root.addElement( "dblT_1000mcA").addText( String.format( "%.0f", m_dblT_1000mcA));
        root.addElement( "dblT_1100mcA").addText( String.format( "%.0f", m_dblT_1100mcA));
        root.addElement( "dblT_1200mcA").addText( String.format( "%.0f", m_dblT_1200mcA));        
    }
    
    
}
