/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.state;

import hvv_admin4.steps.info.TechProcessCommentInfo;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import hvv_admin4.steps.info.TechProcessIgenIextProcessInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;
import hvv_admin4.steps.info.TechProcessUacProcessInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 *
 * @author yaroslav
 */
public class PrintRestoreFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String m_strStateKeepFileName = "/home/yaroslav/HVV_HOME/etc/stateKeeper.admin4.0";
        if( args.length > 0)
            m_strStateKeepFileName = args[0];
        
        FileInputStream fis = new FileInputStream(  m_strStateKeepFileName);
        ObjectInputStream ois = new ObjectInputStream( fis);
            
            
        int nLastWrittenStep = ois.readInt();           //текущее состояние (этап)
        System.out.println( "nLastWrittenStep=" + nLastWrittenStep);
        
        String strSerial = ois.readUTF();               //серийный номер прибора
        System.out.println( "Serial=" + strSerial);
        
        int nDeviceType = ois.readInt();                //тип прибора (размер: МЛГ-СЛГ-БЛГ)
        System.out.println( "nDeviceType=" + nDeviceType);

        //дата завершения ТО
        Date dt = ( Date) ois.readObject();
        if( dt.getYear() != 1900)
            System.out.println( "DtmTOEnd=" + dt);
        else
            System.out.println( "DtmTOEnd=NULL");

        boolean bContinue;
        String strStep;
        do {
            strStep = ois.readUTF();
            System.out.print( "[" + strStep + "]");
            
            switch( strStep) {
                case "001":
                case "061":
                case "062":
                case "064":
                    System.out.println( new TechProcessStepCommon( ois)); break;

                case "021":
                case "022":
                case "041":
                case "042":
                case "043":
                case "044":
                    System.out.println( new TechProcessHvProcessInfo( ois)); break;

                case "063":
                    System.out.println( new TechProcessGetterInfo( ois)); break;

                case "081":
                    System.out.println( new TechProcessIgenIextProcessInfo( ois)); break;

                case "082":
                    System.out.println( new TechProcessUacProcessInfo( ois)); break;

                case "083":
                    System.out.println( new TechProcessCommentInfo( ois)); break;

            }
            
            
            
            int nAvailable = fis.available();
            bContinue = nAvailable != 0;

        } while( bContinue);

        ois.close();
        fis.close();
    }
}
