/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.report;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessCommentInfo;
import hvv_admin4.steps.info.TechProcessDegasationStepInfo;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessHFInfo;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import hvv_admin4.steps.info.TechProcessIgenIextProcessInfo;
//import hvv_admin4.steps.info.GettersActivationProgram;
//import hvv_admin4.steps.info.GettersActivationProgramStep;
import hvv_admin4.steps.info.TechProcessStepCommon;
import hvv_admin4.steps.info.TechProcessUacProcessInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class ReportGenerator {
    
    HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger( ReportGenerator.class);
    
    public ReportGenerator( HVV_Admin4 app) {
        theApp = app;
    }
    
    public String Gen_NiceDate( Date dt) {
        String strResult;
                
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( dt);

        strResult = String.format( "%02d.%02d.%02d",
                clndr.get(Calendar.DAY_OF_MONTH),
                clndr.get(Calendar.MONTH) + 1,
                clndr.get(Calendar.YEAR));
        
        return strResult;
    }
    
    public String Gen_NiceTime( Date tm) {
        String strResult;
                
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( tm);

        strResult = String.format( "%02d:%02d:%02d",
                clndr.get(Calendar.HOUR_OF_DAY),
                clndr.get(Calendar.MINUTE),
                clndr.get(Calendar.SECOND));
        
        return strResult;
    }
    
    public String Gen_NiceDoubleGen( Double dbl, boolean bPoint) {
        String strResult;
    
        if( dbl.isNaN()) {
            return "NaN";
        }
        
        int nExp = ( int) Math.log10( dbl);
        float dblMant = ( float) ( dbl / Math.pow( 10, nExp));
        if( nExp > -2 && nExp < 2)
            strResult = String.format( "%.02f", dbl);
        else
            if( bPoint)
                strResult = String.format( "%.02f×10<sup>%d</sup>", dblMant, nExp);
            else
                strResult = String.format( "%.02f 10<sup>%d</sup>", dblMant, nExp);
        
        strResult = strResult.replace( ",", ".");
        return strResult;
    }
    
    public String Gen_NiceDoubleP5( Double dbl, boolean bPoint) {
        String strResult;
    
        if( dbl == null) {
            return "NULL";
        }
        
        if( dbl.isNaN()) {
            return "NaN";
        }
        
        int nExp = ( int) Math.log10( dbl);
        if( nExp < 0) nExp--;
        
        double dblMant = ( double) ( dbl / Math.pow( 10, nExp));
        if( Math.round( dblMant) == 10.) {
            dblMant = 1.;
            nExp++;
        }
        
        if( nExp > -2 && nExp < 2)
            strResult = String.format( "%.02f", dbl);
        else {
            if( bPoint)
                if( dblMant != 10.)
                    strResult = String.format( "%.02f×10<sup>%d</sup>", dblMant, nExp);
                else
                    strResult = String.format( "%.01f×10<sup>%d</sup>", dblMant, nExp);
            else
                if( dblMant != 10.)
                    strResult = String.format( "%.02f 10<sup>%d</sup>", dblMant, nExp);
                else
                    strResult = String.format( "%.01f 10<sup>%d</sup>", dblMant, nExp);
        }
        
        strResult = strResult.replace( ",", ".");
        
        return strResult;
    }
    
    public String Gen_NiceDoubleP6P7( Double dbl, boolean bPoint) {
        String strResult;
    
        if( dbl == null) {
            return "NULL";
        }
        
        if( dbl.isNaN()) {
            return "NaN";
        }
        
        strResult = String.format( "%.01f", dbl);
        strResult = strResult.replace( ",", ".");
        return strResult;
    }
    
    public void Gen_Header( OutputStreamWriter writer) throws IOException {
        writer.write( "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
        if( !( theApp.GetCurrentStep() == 186 || theApp.GetFailInMiddleFlag())) {
            writer.write( "<meta http-equiv=\"Refresh\" content=\"10\"/>\n");
        }
        writer.write( "<html>\n");
        writer.write( "<title>Отчёт о процессе технологической обработки</title>\n");
        if( !( theApp.GetCurrentStep() == 186 || theApp.GetFailInMiddleFlag())) {
            writer.write( "<head>\n <script src=\"scrollToBottom.js\" language=\"javascript\" type=\"text/javascript\"></script>\n</head>");
        }
        writer.write( "<body>\n");
        
        Date dtStart = theApp.GetLocalDate();
        if( theApp.IsStepMapContainsKey( "001")) {
            TechProcessStepCommon info = theApp.GetStepInfo( "001");
            if( info.GetStartDate() != null)
                dtStart = info.GetStartDate();
        }
        
        Date dtFinish = null;
        if( theApp.IsStepMapContainsKey( "185")) {
            TechProcessStepCommon info = theApp.GetStepInfo( "185");
            if( info.GetStartDate() != null)
                dtFinish = info.GetStartDate();
        }
        
        writer.write( "<H1>Отчёт о процессе технологической обработки<br>\n" + 
                "Прибор: " + theApp.GetSerial());
        switch( theApp.GetProcessedDeviceType()) {
            case HVV_Admin4Constants.DEVICE_BIG:
                if( !theApp.GetSerial().contains("(Б)")) writer.write( " (Б)");
            break;
            case HVV_Admin4Constants.DEVICE_MEDIUM: writer.write( ""); break;
            case HVV_Admin4Constants.DEVICE_SMALL:
                if( !theApp.GetSerial().contains("(м)")) writer.write( " (м)");
            break;
            default:  writer.write( " (???)");
        }
        writer.write( "<br>\n");
        
        
        writer.write( Gen_NiceDate( dtStart) + " - ");
        if( dtFinish != null)
            writer.write( Gen_NiceDate( dtFinish));
        else {
            if( theApp.GetFailInMiddleFlag())
                writer.write( Gen_NiceDate( theApp.GetLocalDate()) + "\n");
            else
                writer.write( "(обработка ещё не закончена)\n");
        }
        
        writer.write( "<br>\n");
        
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1: writer.write( "РМ1"); break;
            case HVV_Admin4Constants.ARM2: writer.write( "РМ2"); break;
            case HVV_Admin4Constants.ARM3: writer.write( "РМ3"); break;
            case HVV_Admin4Constants.ARM4: writer.write( "РМ4"); break;
            default:  writer.write( " (???) ");
        }
        
        writer.write( "\n</H1>\n");
    }
    
    public void Gen_TableHeader( OutputStreamWriter writer) throws IOException {
        writer.write( "<table>\n");
        writer.write( " <tr>\n");
        writer.write( "  <th width=\"120\" align=\"left\">Дата</th>\n");
        writer.write( "  <th width=\"100\" align=\"left\">Время</th>\n");
        writer.write( "  <th width=\"500\" align=\"left\">Операция</th>\n");
        writer.write( " </tr>\n");
    }
    
    public void Gen_TableVoltageHeader( OutputStreamWriter writer) throws IOException {
        writer.write( "<table>\n");
        writer.write( " <tr>\n");
        writer.write( "  <th width=\"120\" align=\"left\"></th>\n");
        writer.write( "  <th width=\"120\" align=\"left\"></th>\n");
        writer.write( "  <th width=\"80\" align=\"left\">Начало</th>\n");
        writer.write( "  <th width=\"80\" align=\"left\">Конец</th>\n");
        writer.write( "  <th width=\"80\" align=\"left\"><font color=\"blue\">Разница</font></th>\n");
        writer.write( " </tr>\n");
        
        
 
    }
    
    public void Gen_TableLine( OutputStreamWriter writer, String strItemId) throws IOException {
        if( theApp.IsStepMapContainsKey( strItemId)) {
            TechProcessStepCommon info = theApp.GetStepInfo( strItemId);
        
            if( info.GetStartReportTitle() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
                writer.write( "  <td>" + info.GetStartReportTitle() + "</td>\n");
                writer.write( " </tr>\n");
                
                if( info.GetStopReportTitle() != null) {
                    writer.write( " <tr height=\"30\">\n");
                    writer.write( "  <td>" + Gen_NiceDate( info.GetStopDate()) + "</td>\n");
                    writer.write( "  <td>" + Gen_NiceTime( info.GetStopDate()) + "</td>\n");
                    writer.write( "  <td>" + info.GetStopReportTitle() + "</td>\n");
                    writer.write( " </tr>\n");
                }
                else
                    logger.warn( "Нет финишного заголовка по этапу " + strItemId);
            }
            else
                logger.warn( "Нет стартового заголовка по этапу " + strItemId);
        }
        else {
            logger.warn( "Нет информации по этапу " + strItemId);
            /*
            writer.write( " <tr height=\"30\">\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td>нет информации об этапе " + strItemId + "</td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( " </tr>\n");
            */
        }
    }
    
    
    public void Gen_TableVoltageLine( OutputStreamWriter writer, String strItemId) throws IOException {
        if( theApp.IsStepMapContainsKey(strItemId)) {
            TechProcessHvProcessInfo info = ( TechProcessHvProcessInfo) theApp.GetStepInfo( strItemId);
        
            writer.write( " <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\"></td>\n");
            writer.write( "  <td width=\"120\" align=\"left\">U<sub>на аноде</sub></td>\n");
            writer.write( "  <td width=\"80\">" + String.format( "%.0f", info.GetAnStart()) + " В</td>\n");
            writer.write( "  <td width=\"80\">" + String.format( "%.0f", info.GetAnStop()) + " В</td>\n");
            writer.write( "  <td width=\"80\"><font color=\"blue\">" +
                    String.format( "%.0f", info.GetAnStart() - info.GetAnStop()) + " В</font></td>\n");
            writer.write( " </tr>\n");
            
            writer.write( " <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\"></td>\n");
            writer.write( "  <td width=\"120\" align=\"left\">U<sub>на штенгеле</sub></td>\n");
            writer.write( "  <td width=\"80\">" + String.format( "%.0f", info.GetTuStart()) + " В</td>\n");
            writer.write( "  <td width=\"80\">" + String.format( "%.0f", info.GetTuStop()) + " В</td>\n");
            writer.write( "  <td width=\"80\"><font color=\"blue\">" +
                    String.format( "%.0f", info.GetTuStart() - info.GetTuStop()) + " В</font></td>\n");
            writer.write( " </tr>\n");           
        }
        else {
            logger.warn( "Нет информации по этапу " + strItemId);
            /*
            writer.write( " <tr height=\"30\">\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td>нет информации об этапе " + strItemId + "</td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( "  <td></td>\n");
            writer.write( " </tr>\n");
            */
        }
    }
    
    public void Gen_Ch01( OutputStreamWriter writer) throws IOException {
        writer.write( "<H3>1. Установка и откачка приборов</H3>\n");

        //<table>
        Gen_TableHeader( writer);
        Gen_TableLine( writer, "001");

        writer.write( "</table>\n<br>\n\n<!-- ** STEP2 ** -->\n");
    }
    
    public void Gen_Ch02( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        writer.write( "<H3>2. Обработка в среде кислорода</H3>\n");
        
        //2.1 Первый цикл обработки
        //<table>
        Gen_TableHeader( writer);
        Gen_TableLine( writer, "021");
        
        bContinue &= ( theApp.GetCurrentStep() > 22);
        if( bContinue) {
            //2.2 напряжения начало - конец
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "022");
        }
        
        
        //2.3 Второй цил обработки
        bContinue &= ( theApp.GetCurrentStep() >= 23);
        if( bContinue) {
            writer.write( "<table>\n");
            writer.write( " <tr>\n");
            writer.write( "  <th width=\"120\" align=\"left\"></th>\n");
            writer.write( "  <th width=\"100\" align=\"left\"></th>\n");
            writer.write( "  <th width=\"500\" align=\"left\"></th>\n");
            writer.write( " </tr>\n");
            Gen_TableLine( writer, "023");
        }
        
        bContinue &= ( theApp.GetCurrentStep() > 24);
        if( bContinue) {
            //2.4 напряжения начало - конец
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "024");
        }
        
        if( bContinue)
            writer.write( "</table>\n<br>\n\n<!-- ** STEP3 ** -->\n");
    }
    
    public void Gen_Ch03( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        
        //writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>3. Обработка в среде кислород-неона</H3>\n");
        
        //3.1 Первый цикл обработки. Длинное плечо
        //<table>
        Gen_TableHeader( writer);
        Gen_TableLine( writer, "041");
        writer.write( "</table>\n");
        Gen_TableVoltageHeader(writer);
        Gen_TableVoltageLine( writer, "041");
        writer.write( "<br>\n</table>\n");
            
        //3.2 Первый цикл обработки. Короткие плечи
        bContinue &= ( theApp.GetCurrentStep() > 42);
        if( bContinue) {
            if( theApp.IsStepMapContainsKey( "042")) {
                Gen_TableHeader( writer);
                Gen_TableLine( writer, "042");
                writer.write( "</table>\n");
                Gen_TableVoltageHeader(writer);
                Gen_TableVoltageLine( writer, "042");
                writer.write( "<br>\n</table>\n");
            }
        }

        //3.3 Второй цикл обработки. Длинное плечо
        bContinue &= ( theApp.GetCurrentStep() > 43);
        if( bContinue) {
            Gen_TableHeader( writer);
            Gen_TableLine( writer, "043");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "043");
            writer.write( "<br>\n</table>\n");
        }
        
        //3.4 Второй цикл обработки. Короткие плечи
        bContinue &= ( theApp.GetCurrentStep() > 44);
        if( bContinue) {
            if( theApp.IsStepMapContainsKey( "044")) {
                Gen_TableHeader( writer);
                Gen_TableLine( writer, "044");
                writer.write( "</table>\n");
                Gen_TableVoltageHeader(writer);
                Gen_TableVoltageLine( writer, "044");
                writer.write( "<br>\n</table>\n");
            }
        }
        
        if( bContinue)
            writer.write( "\n<br>\n<!-- ** STEP4 ** -->\n");
    }
    
    public void Gen_Ch04( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        
        writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>4. Термообезгаживание</H3>\n");
        
        //4.1 Задание времени окончания термообезгаживания
        //Это не нужно
        
        
        
        bContinue &= ( theApp.GetCurrentStep() >= 62);
        if( bContinue) {
            //4.2 Термообезгаживание
            //<table>
            Gen_TableHeader( writer);
            
            //старт термообезгаживания
            TechProcessStepCommon info = ( TechProcessStepCommon) theApp.GetStepInfo( "062");
            TechProcessGetterInfo info2 = ( TechProcessGetterInfo) theApp.GetStepInfo( "063");
            
            if( info.GetStartReportTitle() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
                writer.write( "  <td>" + info.GetStartReportTitle() + "</td>\n");
                writer.write( " </tr>\n");
            }
            
            //выброс 4в
            if( info2 != null && info2.GetDtEffusion4v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 4 В. P<sub>max</sub>=" + Gen_NiceDoubleP5(info2.GetDblEffusion4v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }
            
            //выброс 9в
            if( info2 != null && info2.GetDtEffusion9v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 9 В. P<sub>max</sub>=" + Gen_NiceDoubleP5( info2.GetDblEffusion9v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }
            
            //отключение 9в
            if( info2 != null && info2.GetDtTurnOff9v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtTurnOff9v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtTurnOff9v()) + "</td>\n");
                writer.write( "  <td>" + "Отключение 9 В.</td>\n");
                writer.write( " </tr>\n");
            }
            
            //время отключения печек
            if( theApp.GetDtmTOEnd() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( theApp.GetDtmTOEnd()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( theApp.GetDtmTOEnd()) + "</td>\n");
                writer.write( "  <td>" + "Время отключения печек</td>\n");
                writer.write( " </tr>\n");
            }
            
            //окончание термообезгаживания
            if( info.GetStopReportTitle() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info.GetStopDate()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info.GetStopDate()) + "</td>\n");
                writer.write( "  <td>" + info.GetStopReportTitle() + "</td>\n");
                writer.write( " </tr>\n");
            }
        }
        
        //4.3 Занесение данных о проведении процесса
        
        //4.4 Заполнение рабочей смесью. Выдержка.
        bContinue &= ( theApp.GetCurrentStep() > 64);
        if( bContinue) {
            Gen_TableLine( writer, "064");
        }
        
        if( bContinue)
            writer.write( "</table>\n\n<br>\n<!-- ** STEP5 ** -->\n");
    }
    
    public void Gen_Ch05( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        writer.write( "<H3>5. Предварительная оценка параметров резонаторов</H3>\n");
        Gen_TableHeader( writer);

        bContinue &= ( theApp.GetCurrentStep() > 81);
        if( bContinue) {
            //5.1 Определение пороговых токов генерации и погасания 
            TechProcessIgenIextProcessInfo info = ( TechProcessIgenIextProcessInfo) theApp.GetStepInfo( "081");
            writer.write( "</table>\n<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
                
            writer.write( "</table>\n<table>\n <tr>\n");
            
            //1. строка - заголовок
            writer.write( "  <th width=\"220\" align=\"right\"></th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">Анод</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">Штенгель</th>\n");
            
            //2 строка - токи генерации
            writer.write( " </tr>\n <tr height=\"30\">\n");
            writer.write( "  <td align=\"right\">I<sub>генерации</sub></td>\n");
            if( Double.isNaN( info.Get_Igen_A()))
                writer.write( "  <td align=\"center\"> &lt; I<sub>погас.</sub></td>\n");
            else {
                String strResult = String.format( "%.2f мА", info.Get_Igen_A());
                strResult = strResult.replace( ",", ".");
                writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            }
            if( Double.isNaN( info.Get_Igen_T()))
                writer.write( "  <td align=\"center\"> &lt; I<sub>погас.</sub></td>\n");
            else {
                String strResult = String.format( "%.2f мА", info.Get_Igen_T());
                strResult = strResult.replace( ",", ".");
                writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            }
            
            //3 строка - токи погасания
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">I<sub>погасания</sub></td>\n");
            
            String strResult = String.format( "%.2f мА", info.Get_Iext_A());
            strResult = strResult.replace( ',', '.');
            writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            strResult = String.format( "%.2f мА", info.Get_Iext_T());
            strResult = strResult.replace( ',', '.');
            writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            
            writer.write( " </tr>\n</table>\n<br>\n");
            
            
                
        }

        bContinue &= ( theApp.GetCurrentStep() > 82);
        if( bContinue) {
            //5.2 Снятие вольт-амперной характеристики
            TechProcessUacProcessInfo info = ( TechProcessUacProcessInfo) theApp.GetStepInfo( "082");
            
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
            
            writer.write( "</table>\n<br>\n<table>\n <tr>\n");
            
            writer.write( "  <th width=\"220\" align=\"right\"></th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.0 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.1 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.2 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\"><font color=\"blue\">Разница</font></th>\n");
            
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">U<sub>на аноде</sub>  </td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1000_A()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1100_A()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1200_A()) + "</td>\n");
            writer.write( "  <td align=\"center\"><font color=\"blue\">" + String.format( "%.0f В", info.Get_1000_A() - info.Get_1200_A()) + "</font></td>\n");
            
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">U<sub>на штенгеле</sub></td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1000_T()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1100_T()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1200_T()) + "</td>\n");
            writer.write( "  <td align=\"center\"><font color=\"blue\">" + String.format( "%.0f В", info.Get_1000_T() - info.Get_1200_T()) + "</font></td>\n");
            
            writer.write( " </tr>\n</table>\n<br>\n");
                
        }
        
        bContinue &= ( theApp.GetCurrentStep() > 83);
        if( bContinue) {
            //5.2 Внесение промежуточного комментария
            TechProcessCommentInfo info = ( TechProcessCommentInfo) theApp.GetStepInfo( "083");
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
            
            writer.write( " <tr height=\"30\">\n  <td width=\"120\" align=\"left\"></td>\n  <td width=\"100\" align=\"left\"></td>\n");
            writer.write( "  <td width=\"900\" align=\"left\"><i><pre><font size=\"5\">" + info.m_strComment + "</font></pre></i></td>\n");
                        
            writer.write( " </tr>\n</table>\n\n<br>\n");
                
        }
        
        if( theApp.GetFailInMiddleFlag()) {
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( theApp.GetLocalDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( theApp.GetLocalDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">Процесс э/в обработки прерван</td>\n");
            writer.write( " </tr>\n");
                
            writer.write( "</table>\n\n<br>\n");
        }
        
        if( bContinue)
            writer.write( "<!-- ** STEP6 ** -->\n");
    }
    
    public void Gen_Ch06( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        boolean bOpenTable = false;
        
        writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>6. Тренировка катода</H3>\n");

        //6.1  1-ый цикл   выдержка
        Gen_TableHeader( writer);
        Gen_TableLine( writer, "101");
        bOpenTable = true;
        
        //6.2  1-ый цикл  тренировка
        bContinue &= ( theApp.GetCurrentStep() > 102);
        if( bContinue) {
            Gen_TableLine( writer, "102");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "102");
            writer.write( "<br>\n</table>\n");
            bOpenTable = false;
        }
        
        //6.3  2-ой цикл  выдержка
        bContinue &= ( theApp.GetCurrentStep() > 103);
        if( bContinue) {
            Gen_TableHeader( writer);
            Gen_TableLine( writer, "103");
            bOpenTable = true;
        }
        
        //6.4  2-ой цикл  тренировка
        bContinue &= ( theApp.GetCurrentStep() > 104);
        if( bContinue) {
            Gen_TableLine( writer, "104");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "104");
            writer.write( "<br>\n</table>\n");
            bOpenTable = false;
        }
        
        //6.5  3-ий цикл  выдержка
        bContinue &= ( theApp.GetCurrentStep() > 105);
        if( bContinue) {
            Gen_TableHeader( writer);
            Gen_TableLine( writer, "105");
            bOpenTable = true;
        }
        
        //6.6  3-ий цикл  тренировка
        bContinue &= ( theApp.GetCurrentStep() > 106);
        if( bContinue) {
            Gen_TableLine( writer, "106");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "106");
            writer.write( "<br>\n</table>\n");
            bOpenTable = false;
        }
        
        
        if( bContinue)
            if( bOpenTable)
                writer.write( "</table>\n<br>\n\n<!-- ** STEP7 ** -->\n");
            else
                writer.write( "<br>\n\n<!-- ** STEP7 ** -->\n");
        
    }
    
    public void Gen_Ch07( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        
        writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>7. Обезгаживание рабочих геттеров</H3>\n");
        
        
        bContinue &= ( theApp.GetCurrentStep() > 121);
        if( bContinue) {
            //<table>
            Gen_TableHeader( writer);
        
            //7.1 начало обезгаживания
            //Gen_TableLine( writer, "121");

            TechProcessGetterInfo info2 = (TechProcessGetterInfo ) theApp.GetStepInfo( "121");
            //выброс 4в
            if( info2 != null && info2.GetDtEffusion4v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 4 В. P<sub>max</sub>=" + Gen_NiceDoubleP5(info2.GetDblEffusion4v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }

            //выброс 9в
            if( info2 != null && info2.GetDtEffusion9v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 9 В. P<sub>max</sub>=" + Gen_NiceDoubleP5( info2.GetDblEffusion9v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }
        }
        
        
        bContinue &= ( theApp.GetCurrentStep() > 122);
        if( bContinue) {
            TechProcessHFInfo info = ( TechProcessHFInfo) theApp.GetStepInfo( "122");
                    
            writer.write( "</table>\n");
            writer.write( "<br>\n");
            writer.write( "<table border=\"0\" cellspacing=\"1\">\n");
            writer.write( "  <tr><th width=\"394\">" + Gen_NiceTime( info.GetStartDate()) +" - "
                            + Gen_NiceTime( info.GetStopDate()) + "</th></tr>\n");
            writer.write( "  <tr><td align=\"center\">(геттер ");
            switch( info.GetGetter()) {
                case HVV_Admin4Constants.GETTER1: writer.write( "1"); break;
                case HVV_Admin4Constants.GETTER2: writer.write( "2"); break;
                default:                          writer.write( "?"); break;
            }
            writer.write( ", индуктор ");
            switch( info.GetGetter()) {
                case HVV_Admin4Constants.INDUCTOR_TYPE1: writer.write( "1"); break;
                case HVV_Admin4Constants.INDUCTOR_TYPE2: writer.write( "2"); break;
                default:                                 writer.write( "?"); break;
            }
            writer.write( ")</td></tr>\n");
            writer.write( "</table>\n");

            writer.write( "<table border=\"0\" cellspacing=\"1\">\n");
            writer.write( "  <tr>\n");
            writer.write( "    <th width=\"80\"></th>\n");
            writer.write( "    <th width=\"50\">t</th>\n");
            writer.write( "    <th width=\"50\">W</th>\n");
            writer.write( "    <th width=\"90\">P<sub>max</sub></th>\n");
            writer.write( "  </tr>\n");
            writer.write( "  <tr height=\"5\"></tr>\n");
                
            int nCounter = 0;
            Iterator it = info.m_lstProgram.iterator();
            while( it.hasNext()) {
                TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
                
                String strBoldO = "", strBoldC = "";
                if( !Double.isNaN( step.GetMaxPressure())) {
                    strBoldO = "<b>";
                    strBoldC = "</b>";
                }
                writer.write( "  <tr align=\"center\" height=\"25\">\n");
                writer.write( "    <td></td>\n");
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO + step.GetDuration() + "'" + strBoldC + "</td>\n");
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO + step.GetPower()+ "%" + strBoldC + "</td>\n");
                
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO);
                if( Double.isNaN( step.GetMaxPressure()))
                    writer.write( strBoldC + "</td>\n");
                else
                    writer.write( Gen_NiceDoubleP5( step.GetMaxPressure(), true) + strBoldC + "</td>" + "\n");
                writer.write( "  </tr>");
                
                nCounter++;
            }
            
            writer.write( "</table>\n");
            writer.write( "<br>\n");
        }
        
        if( bContinue)
            writer.write( "<!-- ** STEP8 ** -->\n");
    }
    
    public void Gen_Ch08( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        boolean bOpenTable = false;
        
        writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>8. Тренировка в тренировочной смеси</H3>\n");

        //8.1  1-ый цикл   выдержка
        Gen_TableHeader( writer);
        Gen_TableLine( writer, "141");
        bOpenTable = true;
        
        //8.2  1-ый цикл  тренировка
        bContinue &= ( theApp.GetCurrentStep() > 142);
        if( bContinue) {
            Gen_TableLine( writer, "142");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "142");
            writer.write( "<br>\n</table>\n");
            bOpenTable = false;
        }
        
        //8.3  2-ой цикл   выдержка
        bContinue &= ( theApp.GetCurrentStep() > 143);
        if( bContinue) {
            Gen_TableHeader( writer);
            Gen_TableLine( writer, "143");
            bOpenTable = true;
        }
                
        //8.4  2-ой цикл  тренировка
        bContinue &= ( theApp.GetCurrentStep() > 144);
        if( bContinue) {
            Gen_TableLine( writer, "144");
            writer.write( "</table>\n");
            Gen_TableVoltageHeader(writer);
            Gen_TableVoltageLine( writer, "144");
            writer.write( "<br>\n</table>\n");
            bOpenTable = false;
        }
        
        if( bContinue)
            if( bOpenTable)
                writer.write( "</table>\n<br>\n\n<!-- ** STEP9 ** -->\n");
            else
                writer.write( "<br>\n\n<!-- ** STEP9 ** -->\n");
    }
    
    public void Gen_Ch09( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        
        writer.write( "<P style=\"page-break-before: always\">\n");
        writer.write( "<H3>9. Активация геттеров</H3>\n");
        
        bContinue &= ( theApp.GetCurrentStep() > 161);
        if( bContinue) {
            //<table>
            Gen_TableHeader( writer);
        
            //9.1 начало активации
            //Gen_TableLine( writer, "161");

            TechProcessGetterInfo info2 = (TechProcessGetterInfo ) theApp.GetStepInfo( "161");
            //выброс 4в
            if( info2 != null && info2.GetDtEffusion4v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion4v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 4 В. P<sub>max</sub>=" + Gen_NiceDoubleP5(info2.GetDblEffusion4v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }

            //выброс 9в
            if( info2 != null && info2.GetDtEffusion9v() != null) {
                writer.write( " <tr height=\"30\">\n");
                writer.write( "  <td>" + Gen_NiceDate( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + Gen_NiceTime( info2.GetDtEffusion9v()) + "</td>\n");
                writer.write( "  <td>" + "Выброс 9 В. P<sub>max</sub>=" + Gen_NiceDoubleP5( info2.GetDblEffusion9v(), true) + " Па</td>\n");
                writer.write( " </tr>\n");
            }
        }
        
        
        bContinue &= ( theApp.GetCurrentStep() > 162);
        if( bContinue) {
            TechProcessHFInfo info = ( TechProcessHFInfo) theApp.GetStepInfo( "162");

            writer.write( "</table>\n");
            writer.write( "<br>\n");
            writer.write( "<table border=\"0\" cellspacing=\"1\">\n");
            writer.write( "  <tr><th width=\"394\">" + Gen_NiceTime( info.GetStartDate()) +" - "
                            + Gen_NiceTime( info.GetStopDate()) + "</th></tr>\n");
            writer.write( "  <tr><td align=\"center\">(геттер ");
            switch( info.GetGetter()) {
                case HVV_Admin4Constants.GETTER1: writer.write( "1"); break;
                case HVV_Admin4Constants.GETTER2: writer.write( "2"); break;
                default:                          writer.write( "?"); break;
            }
            writer.write( ", индуктор ");
            switch( info.GetGetter()) {
                case HVV_Admin4Constants.INDUCTOR_TYPE1: writer.write( "1"); break;
                case HVV_Admin4Constants.INDUCTOR_TYPE2: writer.write( "2"); break;
                default:                                 writer.write( "?"); break;
            }
            writer.write( ")</td></tr>\n");
            writer.write( "</table>\n");

            writer.write( "<table border=\"0\" cellspacing=\"1\">\n");
            writer.write( "  <tr>\n");
            writer.write( "    <th width=\"80\"></th>\n");
            writer.write( "    <th width=\"50\">t</th>\n");
            writer.write( "    <th width=\"50\">W</th>\n");
            writer.write( "    <th width=\"90\">P<sub>max</sub></th>\n");
            writer.write( "  </tr>\n");
            writer.write( "  <tr height=\"5\"></tr>\n");
                
            int nCounter = 0;
            Iterator it = info.m_lstProgram.iterator();
            while( it.hasNext()) {
                TechProcessDegasationStepInfo step = ( TechProcessDegasationStepInfo) it.next();
                
                String strBoldO = "", strBoldC = "";
                if( !Double.isNaN( step.GetMaxPressure())) {
                    strBoldO = "<b>";
                    strBoldC = "</b>";
                }
            
                writer.write( "  <tr align=\"center\" height=\"25\">\n");
                writer.write( "    <td></td>\n");
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO + step.GetDuration() + "'" + strBoldC + "</td>\n");
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO + step.GetPower()+ "%" + strBoldC + "</td>\n");
                
                writer.write( "    <td" + ( ( 0 == (nCounter % 2))? " bgcolor=\"#E0E0E0\"" : "") + ">" + strBoldO);
                if( Double.isNaN( step.GetMaxPressure()))
                    writer.write( strBoldC + "</td>\n");
                else
                    writer.write( Gen_NiceDoubleP5( step.GetMaxPressure(), true) + strBoldC + "</td>\n");
                writer.write( "  </tr>");
                
                nCounter++;
            }
            
            writer.write( "</table>\n");
            writer.write( "<br>\n");
        }
        
        if( bContinue)
            writer.write( "\n<!-- ** STEP10 ** -->\n");
    }
    
    public void Gen_Ch10( OutputStreamWriter writer) throws IOException {
        boolean bContinue = true;
        
        writer.write( "<H3>10. Финишная оценка параметров резонаторов</H3>\n");
        
        //10.1 выдержка
        bContinue &= ( theApp.GetCurrentStep() >= 181);
        if( bContinue) {
            Gen_TableHeader( writer);
            Gen_TableLine( writer, "181");
        }
        
        

        
        //10.2 Определение пороговых токов генерации и погасания 
        bContinue &= ( theApp.GetCurrentStep() > 182);
        if( bContinue) {
            TechProcessIgenIextProcessInfo info = ( TechProcessIgenIextProcessInfo) theApp.GetStepInfo( "182");
            
            Gen_TableLine( writer, "182");
            writer.write( "</table>\n<br>\n<table>\n <tr>\n");
            
            
            
            //1. строка - заголовок
            writer.write( "  <th width=\"220\" align=\"right\"></th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">Анод</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">Штенгель</th>\n");
            
            //2 строка - токи генерации
            writer.write( " </tr>\n <tr height=\"30\">\n");
            writer.write( "  <td align=\"right\">I<sub>генерации</sub></td>\n");
            if( Double.isNaN( info.Get_Igen_A()))
                writer.write( "  <td align=\"center\"> &lt; I<sub>погас.</sub></td>\n");
            else {
                String strResult = String.format( "%.2f мА", info.Get_Igen_A());
                strResult = strResult.replace( ",", ".");
                writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            }
            if( Double.isNaN( info.Get_Igen_T()))
                writer.write( "  <td align=\"center\"> &lt; I<sub>погас.</sub></td>\n");
            else {
                String strResult = String.format( "%.2f мА", info.Get_Igen_T());
                strResult = strResult.replace( ",", ".");
                writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            }
            
            //3 строка - токи погасания
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">I<sub>погасания</sub></td>\n");
            
            String strResult = String.format( "%.2f мА", info.Get_Iext_A());
            strResult = strResult.replace( ',', '.');
            writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            strResult = String.format( "%.2f мА", info.Get_Iext_T());
            strResult = strResult.replace( ',', '.');
            writer.write( "  <td align=\"center\">" + strResult + "</td>\n");
            
            writer.write( " </tr>\n</table>\n<br>\n");
                
        }
        
        //10.3 Снятие вольт-амперной характеристик
        bContinue &= ( theApp.GetCurrentStep() > 183);
        if( bContinue) {    
            TechProcessUacProcessInfo info = ( TechProcessUacProcessInfo) theApp.GetStepInfo( "183");
            
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
                
            writer.write( "</table>\n<table>\n <tr>\n");
            
            writer.write( "  <th width=\"220\" align=\"right\"></th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.0 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.1 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\">1.2 мА</th>\n");
            writer.write( "  <th width=\"150\" align=\"center\"><font color=\"blue\">Разница</font></th>\n");
            
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">U<sub>на аноде</sub>  </td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1000_A()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1100_A()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1200_A()) + "</td>\n");
            writer.write( "  <td align=\"center\"><font color=\"blue\">" + String.format( "%.0f В", info.Get_1000_A() - info.Get_1200_A()) + "</font></td>\n");
            
            writer.write( " </tr>\n <tr height=\"30\">\n");
            
            writer.write( "  <td align=\"right\">U<sub>на штенгеле  </td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1000_T()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1100_T()) + "</td>\n");
            writer.write( "  <td align=\"center\">" + String.format( "%.0f В", info.Get_1200_T()) + "</td>\n");
            writer.write( "  <td align=\"center\"><font color=\"blue\">" + String.format( "%.0f В", info.Get_1000_T() - info.Get_1200_T()) + "</font></td>\n");
            
            writer.write( " </tr>\n</table>\n<br>\n");
                
        }
        
        bContinue &= ( theApp.GetCurrentStep() > 184);
        if( bContinue) {
            //10.4 Внесение итогового комментария
            TechProcessCommentInfo info = ( TechProcessCommentInfo) theApp.GetStepInfo( "184");
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
            
            writer.write( " <tr height=\"30\">\n  <td width=\"120\" align=\"left\"></td>\n  <td width=\"100\" align=\"left\"></td>\n");
            writer.write( "  <td width=\"900\" align=\"left\"><i><pre><font size=\"5\">" + info.m_strComment + "</font></pre></i></td>\n");
                        
            writer.write( " </tr>\n</table>\n\n<br>\n");
                
        }
        
        bContinue &= ( theApp.GetCurrentStep() > 185);
        if( bContinue) {
            //10.5 Завершение э/в обработки
            TechProcessStepCommon info = ( TechProcessStepCommon) theApp.GetStepInfo( "185");
            writer.write( "<table>\n <tr height=\"30\">\n");
            writer.write( "  <td width=\"120\" align=\"left\">" + Gen_NiceDate( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"100\" align=\"left\">" + Gen_NiceTime( info.GetStartDate()) + "</td>\n");
            writer.write( "  <td width=\"500\" align=\"left\">" + info.GetStartReportTitle() + "</td>\n </tr>\n");
            
            writer.write( "</table>\n");
        }
    }
    
    public void Gen_Footer( OutputStreamWriter writer) throws IOException {
        writer.write( "</body>\n</html>");
    }
    
    public void Generate() {
        String strArm = "00";
        switch( theApp.GetSelectedArm()) {
            case HVV_Admin4Constants.ARM1: strArm = "01"; break;
            case HVV_Admin4Constants.ARM2: strArm = "02"; break;
            case HVV_Admin4Constants.ARM3: strArm = "03"; break;
            case HVV_Admin4Constants.ARM4: strArm = "04"; break;
            default: return;
        }
        
        String strReportFileNameLoc = theApp.m_strAdminStartDtm + "." + strArm + ".current.html";
        if( theApp.GetCurrentStep() == 186 || theApp.GetFailInMiddleFlag()) {
            File fl = new File( theApp.GetAMSRoot(), "reports" + File.separator + strReportFileNameLoc);
            fl.delete();
            
            if( theApp.GetFailInMiddleFlag()) {
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) {
                    if( theApp.GetSerial().contains("(м)"))
                        strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + " на переюстировку.html";
                    else
                        strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + "(м) на переюстировку.html";
                }
                else
                    strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + " на переюстировку.html";
            }
            else {
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_SMALL) {
                    if( theApp.GetSerial().contains("(м)"))
                        strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + ".html";
                    else
                        strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + "(м).html";
                }
                else
                    strReportFileNameLoc = "Прибор №" + theApp.GetSerial() + ".html";
            }
        }
        
        try {
            FileOutputStream streamOutput = new FileOutputStream(
                                new File( theApp.GetAMSRoot(), "reports" + File.separator + strReportFileNameLoc));
            
            OutputStreamWriter streamWriter = new OutputStreamWriter( streamOutput,"UTF-8");
            
            //FileWriter writer = new FileWriter(  
            //                            new File( theApp.GetAMSRoot(), "reports" + File.separator + strReportFileNameLoc));
            
            
            if( theApp.GetSettings().GetDebugReport()) {
                Gen_Header( streamWriter);
                
                TreeMap stps = theApp.SecretSteps();
                Set set = stps.entrySet();
                Iterator it = set.iterator();
                while( it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    
                    String strKey = ( String) entry.getKey();
                    Object objVal = entry.getValue();
                    
                    streamWriter.write( strKey);
                    streamWriter.write( objVal + "\n");
                }
                

                Gen_Footer( streamWriter);
            }
            else {
                Gen_Header( streamWriter);
                Gen_Ch01( streamWriter);

                if( theApp.IsStepMapContainsKey( "021")) Gen_Ch02( streamWriter);
                if( theApp.IsStepMapContainsKey( "041")) Gen_Ch03( streamWriter);
                if( theApp.IsStepMapContainsKey( "062")) Gen_Ch04( streamWriter);
                if( theApp.IsStepMapContainsKey( "082")) Gen_Ch05( streamWriter);
                if( theApp.IsStepMapContainsKey( "101")) Gen_Ch06( streamWriter);
                if( theApp.IsStepMapContainsKey( "121")) Gen_Ch07( streamWriter);
                if( theApp.IsStepMapContainsKey( "141")) Gen_Ch08( streamWriter);
                if( theApp.IsStepMapContainsKey( "161")) Gen_Ch09( streamWriter);
                if( theApp.IsStepMapContainsKey( "181")) Gen_Ch10( streamWriter);

                Gen_Footer( streamWriter);
            }
            
        
            streamWriter.close();
            streamOutput.close();
            
            //writer.close();
        } catch (IOException ex) {
            logger.error( "В процессе генерации отчёта произошла Exception", ex);
            //Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
