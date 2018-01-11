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
import java.util.LinkedList;

/**
 *
 * @author yaroslav
 */
public class TechProcessHFInfo extends TechProcessStepCommon {
    public LinkedList m_lstProgram;
    
    private int m_nGetter;
    public int GetGetter() { return m_nGetter; }
    public void SetGetter( int nGetter) { m_nGetter = nGetter; }
    
    public int m_nInductor;
    public int GetInductor() { return m_nInductor; }
    public void SetInductor( int nInductor) { m_nInductor = nInductor; }
    
    public TechProcessHFInfo() {
        super();
        
        m_nGetter = -1;
        m_nInductor = -1;
    }
    
    public TechProcessHFInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_nGetter = is.readInt();
        m_nInductor = is.readInt();
        m_lstProgram = ( LinkedList) is.readObject();
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
        
        strResult += "m_nGetter: " + m_nGetter;
        
        strResult += "m_nInductor: " + m_nInductor;
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeInt( m_nGetter);
        out.writeInt( m_nInductor);
        out.writeObject( m_lstProgram);
    }
}
