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
import java.util.Iterator;
import java.util.LinkedList;
import org.dom4j.Element;

/**
 *
 * @author yaroslav
 */
public class TechProcessHFInfo extends TechProcessStepCommon {
    public LinkedList m_lstProgram;
    
    private int m_nCurrentStep;
    public int GetCurrentStep() { return m_nCurrentStep; }
    public void SetCurrentStep( int nStep) { m_nCurrentStep = nStep; }
    
    private int m_nGetter;
    public int GetGetter() { return m_nGetter; }
    public void SetGetter( int nGetter) { m_nGetter = nGetter; }
    
    public int m_nInductor;
    public int GetInductor() { return m_nInductor; }
    public void SetInductor( int nInductor) { m_nInductor = nInductor; }
    
    public TechProcessHFInfo() {
        super();
        
        m_nCurrentStep = -1;
        m_nGetter = -1;
        m_nInductor = -1;
    }
    
    public TechProcessHFInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_nGetter = is.readInt();
        m_nInductor = is.readInt();
        m_nCurrentStep = is.readInt();
        
        m_lstProgram = new LinkedList();
        int len = is.readInt();
        for( int i=0; i<len; i++) {
            TechProcessDegasationStepInfo step = new TechProcessDegasationStepInfo();
            step.SetDuration( is.readInt());
            step.SetPower( is.readInt());
            step.SetMaxPressure( is.readDouble());
            m_lstProgram.addLast( step);
        }
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
        
        strResult += "m_nGetter: " + m_nGetter + "\n";
        
        strResult += "m_nInductor: " + m_nInductor + "\n";
        
        Iterator it = m_lstProgram.iterator();
        while( it.hasNext()) {
            TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
            strResult += "D:" + step.GetDuration() + "  P:" + step.GetPower() + "%  ";
            if( !Double.isNaN( step.GetMaxPressure()))
                strResult += String.format( ("%.2e"), step.GetMaxPressure());               
        }
        strResult += "\n";
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeInt( m_nGetter);
        out.writeInt( m_nInductor);
        out.writeInt( m_nCurrentStep);
        out.writeInt( m_lstProgram.size());
        Iterator it = m_lstProgram.iterator();
        while( it.hasNext()) {
            TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
            out.writeInt( step.GetDuration());
            out.writeInt( step.GetPower());
            out.writeDouble( step.GetMaxPressure());               
        }
    }
    
    @Override
    public void SaveItemXML( Element root, String strTitle) throws IOException {
        super.SaveItemXML( root, strTitle);
        
        root.addElement( "nGetter").addText( "" + m_nGetter);
        root.addElement( "nInductor").addText( "" + m_nInductor);
        root.addElement( "nCurrentStep").addText( "" + m_nCurrentStep);
        root.addElement( "nProgramSize").addText( "" + m_lstProgram.size());
        Iterator it = m_lstProgram.iterator();
        Element innerRoot = root.addElement( "Program");
        int cnt = 0;
        while( it.hasNext()) {
            Element innerRoot2 = innerRoot.addElement( "Step" + cnt++);
            TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
            innerRoot2.addElement( "nDuration").addText( "" + step.GetDuration());
            innerRoot2.addElement( "nPower").addText( "" + step.GetPower());
            innerRoot2.addElement( "dblMaxP").addText( String.format( "%.0f", step.GetMaxPressure()));
        }
    }
}
