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
public class TechProcessIgenIextProcessInfo extends TechProcessStepCommon {
    private Double m_dblA_Igen;
    private Double m_dblA_Iext;
    
    public Double Get_Igen_A() { return m_dblA_Igen; }
    public void Set_Igen_A( Double dbl) { m_dblA_Igen = dbl;}
    public Double Get_Iext_A()  { return m_dblA_Iext; }
    public void Set_Iext_A( Double dbl)  { m_dblA_Iext = dbl;}

    private Double m_dblT_Igen;
    private Double m_dblT_Iext;

    public Double Get_Igen_T() { return m_dblT_Igen; }
    public void Set_Igen_T( Double dbl) { m_dblT_Igen = dbl;}
    public Double Get_Iext_T()  { return m_dblT_Iext; }
    public void Set_Iext_T( Double dbl)  { m_dblT_Iext = dbl;}
        
    public TechProcessIgenIextProcessInfo() {
        super();
        
        m_dblA_Igen = 0.;
        m_dblA_Iext = 0.;
        
        m_dblT_Igen = 0.;
        m_dblT_Iext = 0.;
    }
    
    public TechProcessIgenIextProcessInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_dblA_Iext = is.readDouble();
        m_dblA_Igen = is.readDouble();
        m_dblT_Iext = is.readDouble();
        m_dblT_Igen = is.readDouble();
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
            strResult += "dtStart: " + ReportGenerator.Gen_NiceDate(GetStopDate()) +
                         " " + ReportGenerator.Gen_NiceTime(GetStopDate()) + "\n";

        if( GetStopReportTitle() == null)
            strResult += "strStop: NULL" + "\n";
        else
            strResult += "strStop: " + GetStopReportTitle() + "\n";
        
        
        
        strResult += "m_dblA_Igen: " + String.format( "%.03f", m_dblA_Igen);
        
        strResult += "m_dblA_Iext: " + String.format(  "%.03f", m_dblA_Iext);
        
        strResult += "m_dblT_Igen: " + String.format( "%.03f", m_dblT_Igen);
        
        strResult += "m_dblT_Iext: " + String.format(  "%.03f", m_dblT_Iext);
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeDouble( m_dblA_Iext);
        out.writeDouble( m_dblA_Igen);
        out.writeDouble( m_dblT_Iext);
        out.writeDouble( m_dblT_Igen);
    }
    
    @Override
    public void SaveItemXML( Element root, String strTitle) throws IOException {
        super.SaveItemXML( root, strTitle);
        
        root.addElement( "dblA_Iext").addText( String.format( "%.0f", m_dblA_Iext));
        root.addElement( "dblA_Igen").addText( String.format( "%.0f", m_dblA_Igen));
        root.addElement( "dblT_Iext").addText( String.format( "%.0f", m_dblT_Iext));
        root.addElement( "dblT_Igen").addText( String.format( "%.0f", m_dblT_Igen));        
    }
}
