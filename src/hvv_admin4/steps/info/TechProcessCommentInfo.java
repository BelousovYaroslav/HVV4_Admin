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

/**
 *
 * @author yaroslav
 */
public class TechProcessCommentInfo extends TechProcessStepCommon {
    public String m_strComment;
    
    public TechProcessCommentInfo() {
        super();
    }
    
    public TechProcessCommentInfo( ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( is);
        m_strComment = is.readUTF();
    }
    
    @Override
    public String toString() {
        String strResult = "\n";
        
        if( GetStartDate() == null)
            strResult += "dtStart: NULL" + "\n";
        else
            strResult += "dtStart: " + ReportGenerator.Gen_NiceTime(GetStartDate()) +
                         " " + ReportGenerator.Gen_NiceTime(GetStartDate()) + "\n";
        
        if( GetStartReportTitle() == null)
            strResult += "strStart: NULL" + "\n";
        else
            strResult += "strStart: " + GetStartReportTitle() + "\n";
        
        
        if( GetStopDate() == null)
            strResult += "dtStop: NULL" + "\n";
        else
            strResult += "dtStart: " + ReportGenerator.Gen_NiceTime(GetStopDate()) +
                         " " + ReportGenerator.Gen_NiceTime(GetStopDate()) + "\n";
        
        if( GetStopReportTitle() == null)
            strResult += "strStop: NULL" + "\n";
        else
            strResult += "strStop: " + GetStopReportTitle() + "\n";
        
        if( m_strComment == null)
            strResult += "m_strComment: NULL" + "\n";
        else
            strResult += "m_strComment: " + m_strComment + "\n";
        
        return strResult;
    }
    
    @Override
    public void SaveItem( java.io.ObjectOutputStream out) throws IOException {
        super.SaveItem( out);
        out.writeUTF( m_strComment);
    }
}
