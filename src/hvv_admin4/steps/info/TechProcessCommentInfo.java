/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.steps.info;

import hvv_admin4.HVV_Admin4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

/**
 *
 * @author yaroslav
 */
public class TechProcessCommentInfo extends TechProcessStepCommon {
    public String m_strComment;
    
    public TechProcessCommentInfo( HVV_Admin4 app) {
        super( app);
    }
    
    public TechProcessCommentInfo( HVV_Admin4 app, ObjectInputStream is) throws IOException, ClassNotFoundException {
        super( app, is);
        m_strComment = is.readUTF();
    }
    
    @Override
    public String toString() {
        String strResult = "\n";
        
        if( GetStartDate() == null)
            strResult += "dtStart: NULL" + "\n";
        else
            strResult += "dtStart: " + theApp.m_ReportGenerator.Gen_NiceTime(GetStartDate()) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime(GetStartDate()) + "\n";
        
        if( GetStartReportTitle() == null)
            strResult += "strStart: NULL" + "\n";
        else
            strResult += "strStart: " + GetStartReportTitle() + "\n";
        
        
        if( GetStopDate() == null)
            strResult += "dtStop: NULL" + "\n";
        else
            strResult += "dtStart: " + theApp.m_ReportGenerator.Gen_NiceTime(GetStopDate()) +
                         " " + theApp.m_ReportGenerator.Gen_NiceTime(GetStopDate()) + "\n";
        
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
