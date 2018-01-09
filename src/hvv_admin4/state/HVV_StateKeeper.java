/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.state;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessCommentInfo;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import hvv_admin4.steps.info.TechProcessIgenIextProcessInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;
import hvv_admin4.steps.info.TechProcessUacProcessInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class HVV_StateKeeper {
    
    static Logger logger = Logger.getLogger(HVV_StateKeeper.class);
    
    HVV_Admin4 theApp;
    String m_strStateKeepFileName;
    
    public boolean m_bDropReadState;
    
    public HVV_StateKeeper( HVV_Admin4 app) {
        theApp = app;
        m_strStateKeepFileName = app.GetAMSRoot() + "/etc/stateKeeper.admin4." + app.GetSelectedArm();
        m_bDropReadState = false;
    }
    
    private void SaveCommonPoint( ObjectOutputStream oos, String strStep1) throws IOException {
        
        TechProcessStepCommon info = theApp.GetCommonStep( strStep1);
        if( info != null) {
            oos.writeObject( info.GetStartDate());
            oos.writeObject( info.GetStartReportTitle());
            
            oos.writeObject( info.GetStopDate());
            oos.writeObject( info.GetStopReportTitle());
        }
        else {
            oos.writeObject( null);
            oos.writeObject( null);
            
            oos.writeObject( null);
            oos.writeObject( null);
        }
    }
    
    private TechProcessStepCommon ReadCommonPoint( ObjectInputStream ois) throws IOException {
        
        TechProcessStepCommon info = new TechProcessStepCommon( theApp);
        try {            
            info.SetStartDate( ( Date) ois.readObject());
            info.SetStartReportTitle( ( String) ois.readObject());
            
            info.SetStopDate( ( Date) ois.readObject());
            info.SetStopReportTitle( ( String) ois.readObject());
            
        } catch (ClassNotFoundException ex) {
            logger.error( "ClassNotFoundException caught, при чтении state-файла", ex);
        }
        
        return info;
    }
    
    
    private void SaveHvPoint( ObjectOutputStream oos, String strStep1) throws IOException {
        
        TechProcessHvProcessInfo info = ( TechProcessHvProcessInfo) theApp.GetHvStep( strStep1);
        if( info != null) {
            oos.writeObject( info.GetStartDate());
            oos.writeObject( info.GetStartReportTitle());
            oos.writeDouble( info.GetAnStart());
            oos.writeDouble( info.GetTuStart());
            
            oos.writeObject( info.GetStopDate());
            oos.writeObject( info.GetStopReportTitle());
            oos.writeDouble( info.GetAnStop());
            oos.writeDouble( info.GetTuStop());
        }
        else {
            for( int i=0; i<8; i++)
                oos.writeObject( null);
        }
    }
    
    private TechProcessHvProcessInfo ReadHvPoint( ObjectInputStream ois) throws IOException {
        
        TechProcessHvProcessInfo info = new TechProcessHvProcessInfo( theApp);
        try {
            info.SetStartDate( ( Date)          ois.readObject());
            info.SetStartReportTitle( ( String) ois.readObject());
            info.SetAnStart(                    ois.readDouble());
            info.SetTuStart(                    ois.readDouble());
            
            info.SetStopDate( ( Date)           ois.readObject());
            info.SetStopReportTitle( ( String)  ois.readObject());
            info.SetAnStop(                     ois.readDouble());
            info.SetTuStop(                     ois.readDouble());
            
        } catch (ClassNotFoundException ex) {
            logger.error( "ClassNotFoundException caught, при чтении state-файла", ex);
        }
        
        return info;
    }
    
    private void SaveGetterInfoPoint( ObjectOutputStream oos, String strStep1) throws IOException {
        
        TechProcessGetterInfo info = ( TechProcessGetterInfo) theApp.GetGetterInfoStep( strStep1);
        if( info != null) {
            oos.writeObject( info.GetStartDate());
            oos.writeObject( info.GetStartReportTitle());
            oos.writeObject( info.GetStopDate());
            oos.writeObject( info.GetStopReportTitle());
            
            oos.writeObject( info.GetDtEffusion4v());
            oos.writeDouble( info.GetDblEffusion4v());
            oos.writeObject( info.GetDtEffusion9v());
            oos.writeDouble( info.GetDblEffusion9v());
            oos.writeObject( info.GetDtTurnOff9v());
        }
        else {
            for( int i=0; i<8; i++)
                oos.writeObject( null);
        }
    }
    
    private TechProcessGetterInfo ReadGetterInfoPoint( ObjectInputStream ois) throws IOException {
        
        TechProcessGetterInfo info = new TechProcessGetterInfo( theApp);
        try {
            info.SetStartDate( ( Date)          ois.readObject());
            info.SetStartReportTitle( ( String) ois.readObject());
            info.SetStopDate( ( Date)           ois.readObject());
            info.SetStopReportTitle( ( String)  ois.readObject());
            
            info.SetDtEffusion4v( ( Date)       ois.readObject());
            info.SetDblEffusion4v(              ois.readDouble());
            info.SetDtEffusion9v( ( Date)       ois.readObject());
            info.SetDblEffusion9v(              ois.readDouble());
            info.SetDtTurnOff9v(( Date)         ois.readObject());
            
        } catch (ClassNotFoundException ex) {
            logger.error( "ClassNotFoundException caught, при чтении state-файла", ex);
        }
        
        return info;
    }
    
    private void SaveIgenIextPoint( ObjectOutputStream oos, String strStep1) throws IOException {
        
        TechProcessGetterInfo info = ( TechProcessGetterInfo) theApp.GetGetterInfoStep( strStep1);
        if( info != null) {
            oos.writeObject( info.GetStartDate());
            oos.writeObject( info.GetStartReportTitle());
            oos.writeObject( info.GetStopDate());
            oos.writeObject( info.GetStopReportTitle());
            
            oos.writeObject( info.GetDtEffusion4v());
            oos.writeDouble( info.GetDblEffusion4v());
            oos.writeObject( info.GetDtEffusion9v());
            oos.writeDouble( info.GetDblEffusion9v());
            oos.writeObject( info.GetDtTurnOff9v());
        }
        else {
            for( int i=0; i<8; i++)
                oos.writeObject( null);
        }
    }
    
    private TechProcessGetterInfo ReadIgenIextPoint( ObjectInputStream ois) throws IOException {
        
        TechProcessGetterInfo info = new TechProcessGetterInfo( theApp);
        try {
            info.SetStartDate( ( Date)          ois.readObject());
            info.SetStartReportTitle( ( String) ois.readObject());
            info.SetStopDate( ( Date)           ois.readObject());
            info.SetStopReportTitle( ( String)  ois.readObject());
            
            info.SetDtEffusion4v( ( Date)       ois.readObject());
            info.SetDblEffusion4v(              ois.readDouble());
            info.SetDtEffusion9v( ( Date)       ois.readObject());
            info.SetDblEffusion9v(              ois.readDouble());
            info.SetDtTurnOff9v(( Date)         ois.readObject());
            
        } catch (ClassNotFoundException ex) {
            logger.error( "ClassNotFoundException caught, при чтении state-файла", ex);
        }
        
        return info;
    }
    
    public void SaveState() {
        try {
            if( theApp.GetCurrentStep() < 20) return;
            
            FileOutputStream fos = new FileOutputStream(  m_strStateKeepFileName);
            ObjectOutputStream oos = new ObjectOutputStream( fos);
            
            oos.writeInt( theApp.GetCurrentStep());         //текущий шаг
            oos.writeUTF( theApp.GetSerial());              //серийный номер прибора
            oos.writeInt( theApp.GetProcessedDeviceType()); //тип прибора (размер: МЛГ-СЛГ-БЛГ)
            
            Set set = theApp.SecretSteps().entrySet();
            Iterator it = set.iterator();
            while( it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                
                String strKey = ( String) entry.getKey();
                Object objValue = entry.getValue();

                oos.writeUTF( strKey);
                switch( strKey) {
                    case "001":
                    case "061":
                    case "062":
                    case "064":
                        (( TechProcessStepCommon) objValue).SaveItem(oos); break;
                    
                    case "021":
                    case "022":
                    case "041":
                    case "042":
                    case "043":
                    case "044":
                        (( TechProcessHvProcessInfo) objValue).SaveItem(oos); break;
                        
                    case "063":
                        (( TechProcessGetterInfo) objValue).SaveItem(oos); break;
                        
                    case "081":
                        (( TechProcessIgenIextProcessInfo) objValue).SaveItem(oos); break;
                        
                    case "082":
                        (( TechProcessUacProcessInfo) objValue).SaveItem(oos); break;
                        
                    case "083":
                        (( TechProcessCommentInfo) objValue).SaveItem(oos); break;
                }
            }
            
            oos.close();
            fos.close();
        } catch( Exception ex) {
            logger.error( "Во время сохранения состояния произошла Exception!", ex);
        }
        
        
    }
    
    public void RestoreState() {
        try {
            FileInputStream fis = new FileInputStream(  m_strStateKeepFileName);
            ObjectInputStream ois = new ObjectInputStream( fis);
            
            
            int nLastWrittenStep = ois.readInt();   //текущее состояние (этап)
            String strSerial = ois.readUTF();       //серийный номер прибора
            int nDeviceType = ois.readInt();        //тип прибора (размер: МЛГ-СЛГ-БЛГ)
            
            
            String strStepNumber = String.format( "%03d", nLastWrittenStep);
            boolean bContinue;
            do {
                String strStep = ois.readUTF();
                switch( strStep) {
                    case "001":
                    case "061":
                    case "062":
                    case "064":
                        theApp.SecretSteps().put( strStep, new TechProcessStepCommon( theApp, ois)); break;
                    
                    case "021":
                    case "022":
                    case "041":
                    case "042":
                    case "043":
                    case "044":
                        theApp.SecretSteps().put( strStep, new TechProcessHvProcessInfo(theApp, ois)); break;
                        
                    case "063":
                        theApp.SecretSteps().put( strStep, new TechProcessGetterInfo(theApp, ois)); break;
                        
                    case "081":
                        theApp.SecretSteps().put( strStep, new TechProcessIgenIextProcessInfo(theApp, ois)); break;
                        
                    case "082":
                        theApp.SecretSteps().put( strStep, new TechProcessUacProcessInfo(theApp, ois)); break;
                        
                    case "083":
                        theApp.SecretSteps().put( strStep, new TechProcessCommentInfo(theApp, ois)); break;
                    
                }
                int nAvailable = fis.available();
                bContinue = nAvailable != 0;
                
            } while( bContinue);
            
            ois.close();
            fis.close();
            
            //Последний этап = strStepNumber
            //Закончен ли он?
            boolean bEnded = !( theApp.GetCommonStep( strStepNumber).GetStopDate() == null);
            
            String strMessage =
                    "<html>Согласно файлу состояния, в предыдущем запуске,последним был этап " + strStepNumber +
                    ", и он " + ( bEnded ? "был закончен" : "не был закончен");
            strMessage += ".<br><br>Какой выставить текущий этап?</html>";
            
            
            //обычное сбитие, предлагаем текущий или следущий этапы
            PrevStateRestoreDlgCommon dlg = new PrevStateRestoreDlgCommon( null, true);

            theApp.SetCurrentStep( nLastWrittenStep);
            theApp.NextCurrentStep();
            int nPotentialNextStep = theApp.GetCurrentStep();

            dlg.m_strLabel.setText( strMessage);
            dlg.m_rad1.setText( String.format("%03d", nLastWrittenStep));
            dlg.m_rad2.setText( String.format("%03d", nPotentialNextStep));

            dlg.setVisible( true);
            if( dlg.m_bDrop == false) {
                theApp.SetSerial( strSerial);
                theApp.SetProcessedDeviceType( nDeviceType);
                
                if( dlg.m_rad1.isSelected()) {                    
                    theApp.SetCurrentStep( nLastWrittenStep);
                    theApp.SecretSteps().remove( String.format("%03d", nLastWrittenStep));
                }
                else {
                    /*
                    TechProcessStepCommon info = theApp.GetCommonStep( String.format("%03d", nLastWrittenStep));
                    info.SetStopDateAsCurrent();
                    info.SetStopReportTitle( "Этап отмечен как завершенный вручную, после перезапуска адм. модуля");
                    */
                    
                    theApp.SetCurrentStep( nPotentialNextStep);
                    
                    /*
                    TechProcessStepCommon info = new TechProcessStepCommon(theApp);
                    info.SetStartDateAsCurrent();
                    */
                }

                /*
                switch( theApp.GetCurrentStep()) {
                    case 42:    theApp.ShowDlg2_1();    break;
                    case 23:    theApp.ShowDlg2_3();    break;
                    case 81:    theApp.ShowDlg5_1();    break;
                    case 82:    theApp.ShowDlg5_2();    break;
                    case 83:    theApp.ShowDlg5_3();    break;
                    case 101:   theApp.ShowDlg6_1A();   break;
                    case 102:   theApp.ShowDlg6_2();    break;
                    case 103:   theApp.ShowDlg6_3();    break;
                    case 141:   theApp.ShowDlg8( 2000);     break;
                    case 181:   theApp.ShowDlg10( 2000);    break;
                    case 203:   theApp.ShowDlg11_3A();  break;
                    case 204:   theApp.ShowDlg11_4();   break;
                    case 205:   theApp.ShowDlg11_5();   break;
                    case 206:   theApp.ShowDlg11_6();   break;
                    case 223:   theApp.ShowDlg12_3();   break;
                    case 242:   theApp.ShowDlg13_2();    break;    
                }
                */
            }
            else {
                m_bDropReadState = true;
            }
            
        
            
            
        } catch( Exception ex) {
            logger.error( "Во время восстановления состояния произошла Exception!", ex);
        }
        
        
        
    }
    
    public void DropState() {
        File file = new File( m_strStateKeepFileName);
        file.deleteOnExit();
    }

    public boolean CheckStateKeeperFileExistance() {
        
        return ( new File( m_strStateKeepFileName).exists());
    }
}
