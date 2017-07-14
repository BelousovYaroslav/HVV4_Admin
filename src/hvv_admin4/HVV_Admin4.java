/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4;

import hvv_admin4.planner.HVV_AdminPlanner;
import hvv_admin4.report.ReportGenerator;
import hvv_admin4.steps.info.TechProcessStepCommon;
import hvv_resources.HVV_Resources;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author yaroslav
 */
public class HVV_Admin4 {
    static Logger logger = Logger.getLogger( HVV_Admin4.class);
    
    private final String m_strAMSrootEnvVar;
    public String GetAMSRoot() { return m_strAMSrootEnvVar; }
    
    public HVV_Admin4MainFrame m_pMainWnd;
    
    final private HVV_Admin4Settings m_pSettings;
    public HVV_Admin4Settings GetSettings() { return m_pSettings; }
    
    private final HVV_Resources m_Resources;
    public HVV_Resources GetResources() { return m_Resources;}

    private final HVV_AdminPlanner m_pPlanner;
    public HVV_AdminPlanner GetPlanner() { return m_pPlanner; }
    
    public String m_strAdminStartDtm;
    public ReportGenerator m_ReportGenerator;
    
    private String m_strSerial;
    public String GetSerial() { return m_strSerial; }
    public void SetSerial( String strSerial) { m_strSerial = strSerial; }
    
    private int m_nProcessedDeviceType;
    public int GetProcessedDeviceType() { return m_nProcessedDeviceType; }
    public void SetProcessedDeviceType( int nProcessedDeviceType) { m_nProcessedDeviceType = nProcessedDeviceType; }
            
    private int m_nArm;
    public int GetSelectedArm() { return m_nArm; }
    
    private final Font m_fontUsual;
    public Font GetUsualFont() { return m_fontUsual; }
    
    private final Font m_fontBold;
    public Font GetBoldFont() { return m_fontBold; }
    
    
    private boolean m_bCurrentStepInProgress;
    public boolean IsCurrentStepInProgress() { return m_bCurrentStepInProgress; }
    public void SetCurrentStepInProgress( boolean bStatus) { m_bCurrentStepInProgress = bStatus; }
    
    private int m_nCurrentProcessStep;
    public int GetCurrentStep() { return m_nCurrentProcessStep; }
    public void SetCurrentStep( int nNewStep) {
        m_nCurrentProcessStep = nNewStep;
    }
    
    private boolean m_bFailInMiddleFlag;
    public boolean GetFailInMiddleFlag() { return m_bFailInMiddleFlag;}
    public void SetFailInMiddleFlag( boolean bVal) { m_bFailInMiddleFlag = bVal;}
    
    private Date m_dtTOend;
    public Date GetDtmTOEnd() { return m_dtTOend;}
    public void SetDtmTOEnd( Date dtVal) { m_dtTOend = dtVal;}
    
    private final TreeMap m_mapSteps;
    
    //SECRET BACKDOOR - used only in ReportGeneration
    public TreeMap SecretSteps() { return m_mapSteps;}
    
    public void ProcessingStepsRemoveStep( String strStepKey) { if( m_mapSteps.containsKey( strStepKey)) m_mapSteps.remove( strStepKey);}
    public boolean IsStepMapContainsKey( String strStepName) { return m_mapSteps.containsKey( strStepName);}
    public void SaveStepInfo( String strStepName, TechProcessStepCommon info, boolean bSaveState) {
        m_mapSteps.put( strStepName, info);
        //if( bSaveState)
        //    m_pStateKeeper.SaveState();
    }
    
    public TechProcessStepCommon GetStepInfo( String strStepName) {
        TechProcessStepCommon ret = null;
        
        if( m_mapSteps.containsKey( strStepName))
            ret = ( TechProcessStepCommon) m_mapSteps.get( strStepName);
        
        return ret;
    }
    
    /*
    private TreeMap m_mapVoltages;
    public boolean IsVolatagesMapContainsKey( String strStepName) { return m_mapVoltages.containsKey( strStepName);}
    public void SaveVoltageInfo( String strStepName, TechProcessHvProcessInfo info, boolean bSaveState) {
        m_mapVoltages.put( strStepName, info);
        //if( bSaveState)
        //    m_pStateKeeper.SaveState();
    }
    
    public TechProcessHvProcessInfo GetVoltageInfo( String strStepName) {
        TechProcessHvProcessInfo ret = null;
        
        if( m_mapVoltages.containsKey( strStepName))
            ret = ( TechProcessHvProcessInfo) m_mapVoltages.get( strStepName);
        
        return ret;
    }
    */
    
    
    
    public void NextCurrentStep() {
        switch( m_nCurrentProcessStep) {
            //1. Установка и откачка приборов
            case   1: m_nCurrentProcessStep =  21; break;  //1.1 Установка и откачка приборов

            //2. Обработка в среде кислорода
            case  21: m_nCurrentProcessStep =  22; break;  //2.1 Обработка. 1ый цикл.
            case  22: m_nCurrentProcessStep =  41; break;  //2.3 Обработка. 2ой цикл.
            
            //3. Обработка в среде кислород-неона
            case  41: m_nCurrentProcessStep =  42; break;  //3.1 Обработка. 1ый цикл.
            case  42: m_nCurrentProcessStep =  43; break;  //3.2 Ввод напряжений 1-го цикла процесса обработки O2-Ne
            case  43: m_nCurrentProcessStep =  44; break;  //3.3 Обработка. 2ой цикл.
            case  44: m_nCurrentProcessStep =  61; break;  //3.4 Ввод напряжений 2-го цикла процесса обработки O2-Ne

            //4. Термообезгаживание
            case  61: m_nCurrentProcessStep =  62; break;  //4.1 Задание времени окончания термообезгаживания
            case  62: m_nCurrentProcessStep =  63; break;  //4.2 Термообезгаживание
            case  63: m_nCurrentProcessStep =  64; break;  //4.3 Занесение данных о проведении процесса
            case  64: m_nCurrentProcessStep =  81; break;  //4.4 Заполнение рабочей смесью.Выдержка
    
            //5. Термообезгаживание
            case  81: m_nCurrentProcessStep =  82; break;  //5.1 Замеры параметров.ВАХ
            case  82: m_nCurrentProcessStep =  83; break;  //5.2 Замеры параметров.Токи генерации
            case  83: m_nCurrentProcessStep =  101; break; //5.3 Внесение комментариев
                
            /*
            //6. Предварительная оценка параметров приборов
            case 101: m_nCurrentProcessStep = 102; break;  //6.1 Внесение комментариев
            case 102: m_nCurrentProcessStep = 103; break;  //6.2 Внесение пороговых токов
            case 103: m_nCurrentProcessStep = 104; break;  //6.3 Измерение ВАХ
            case 104: m_nCurrentProcessStep = 121; break;  //6.4 Откачка рабочей смеси

            //7. Тренировка катода
            case 121: m_nCurrentProcessStep = 122; break;  //7.1 Напуск тренировочной смеси в приборы
            case 122: m_nCurrentProcessStep = 123; break;  //7.2 Выдержка
            case 123: m_nCurrentProcessStep = 124; break;  //7.3 Обработка. 1ый цикл
            case 124: m_nCurrentProcessStep = 125; break;  //7.4 Откачка тренировочной смеси
            case 125: m_nCurrentProcessStep = 126; break;  //7.5 Напуск тренировочной смеси в приборы
            case 126: m_nCurrentProcessStep = 127; break;  //7.6 Выдержка
            case 127: m_nCurrentProcessStep = 128; break;  //7.7 Обработка. 2ой цикл
            case 128: m_nCurrentProcessStep = 129; break;  //7.8 Откачка тренировочной смеси
            case 129: m_nCurrentProcessStep = 130; break;  //7.9 Напуск тренировочной смеси
            case 130: m_nCurrentProcessStep = 131; break;  //7.10 Выдержка
            case 131: m_nCurrentProcessStep = 132; break;  //7.11 Обработка. 3ий цикл
            case 132: m_nCurrentProcessStep = 133; break;  //7.12 Откачка тренировочной смеси
            case 133: m_nCurrentProcessStep = 141; break;  //7.13 Переход на основную откачку
                
            //8. Обезгаживание рабочих геттеров
            case 141: m_nCurrentProcessStep = 142; break;  //8.1 Обезгаживание
            case 142: m_nCurrentProcessStep = 161; break;  //8.2 Открытие геттера
    
            //9. Тренировка в тренировочной смеси
            case 161: m_nCurrentProcessStep = 162; break;  //9.1 Напуск тренировочной смеси в приборы
            case 162: m_nCurrentProcessStep = 163; break;  //9.2 Выдержка
            case 163: m_nCurrentProcessStep = 164; break;  //9.3 Обработка. 1ый цикл.
            case 164: m_nCurrentProcessStep = 165; break;  //9.4 Откачка тренировочной смеси
            case 165: m_nCurrentProcessStep = 166; break;  //9.5 Напуск тренировочной смеси в приборы
            case 166: m_nCurrentProcessStep = 167; break;  //9.6 Выдержка
            case 167: m_nCurrentProcessStep = 168; break;  //9.7 Обработка. 2ой цикл.
            case 168: m_nCurrentProcessStep = 169; break;  //9.8 Откачка тренировочной смеси
            case 169: m_nCurrentProcessStep = 181; break;  //9.9 Переход на основную откачку

            //10. Активация рабочих геттеров
            case 181: m_nCurrentProcessStep = 182; break;  //10.1 Активация
            case 182: m_nCurrentProcessStep = 201; break;  //10.2 Открытие геттера
    
            //11. Выходная оценка параметров приборов
            case 201: m_nCurrentProcessStep = 202; break;  //11.1 Заполнение рабочей смесью
            case 202: m_nCurrentProcessStep = 203; break;  //11.2 Выдержка
            case 203: m_nCurrentProcessStep = 204; break;  //11.3 Внесение пороговых токов
            case 204: m_nCurrentProcessStep = 205; break;  //11.4 Измерение ВАХ
            case 205: m_nCurrentProcessStep = 206; break;  //11.5 Оценка параметров приборов
            case 206: m_nCurrentProcessStep = 221; break;  //11.6 Герметизация годных приборов
    
            //12. Снятие непрошедших приборов (опционально)
            case 221: m_nCurrentProcessStep = 222; break;  //12.1 Закрытие геттера
            case 222: m_nCurrentProcessStep = 223; break;  //12.2 Напуск азота в приборы
            case 223: m_nCurrentProcessStep = 241; break;  //12.3 Снятие непрошедших приборов

            //13. Завершение технологического процесса
            case 241: m_nCurrentProcessStep = 242; break;  //13.1 Bypass-откачка
            case 242: m_nCurrentProcessStep = 243; break;  //13.2 Проверка герметичности (?? да  ?? нет)
            case 243: m_nCurrentProcessStep = 244; break;  //13.3 Основная откачка
            case 244: m_nCurrentProcessStep = 245; break;  //13.4 Откачка смеси с геттера
                */
        }
        m_bCurrentStepInProgress = false;
    }
    
    public HVV_Admin4() {
        m_strAMSrootEnvVar = System.getenv( "AMS_ROOT");
        
        //SETTINGS
        m_pSettings = new HVV_Admin4Settings( m_strAMSrootEnvVar);
        
        //PLANNER
        m_pPlanner = new HVV_AdminPlanner( this);
        
        //RESOURCES
        m_Resources = HVV_Resources.getInstance();
        
        m_fontUsual = new Font( "Cantarell", Font.PLAIN, 15);
        m_fontBold = new Font( "Cantarell", Font.BOLD, 15);
        
        m_nArm = -1;
        m_nProcessedDeviceType = -1;
        
        m_bFailInMiddleFlag = false;
                
        m_mapSteps = new TreeMap();
        
        /*
        m_pStateKeeper = new HVV_StateKeeper( this);
        if( m_pStateKeeper.CheckStateKeeperFileExistance()) {
            int nResponce = MessageBoxAskYesNo( "Обнаружен файл хранения состояния.\nВосстановить состояние предыдущего запуска?", "HVV_Admin");
            if( nResponce == YES_OPTION) {
                m_pStateKeeper.RestoreState();
                if( m_pStateKeeper.m_bDropReadState == true) {
                    //2.1
                    m_mapSerials        = new HashMap( 8);
                    m_mapDevicePresence = new HashMap( 8);
                    m_mapDeviceGetter   = new HashMap( 8);

                    //6.1
                    m_mapStep6_1_1000mcA  = new HashMap( 8);
                    m_mapStep6_1_1100mcA  = new HashMap( 8);
                    m_mapStep6_1_1200mcA  = new HashMap( 8);

                    //6.2
                    m_mapStep6_2_LasThreshold = new HashMap( 8);
                    m_mapStep6_2_ExtAn    = new HashMap( 8);
                    m_mapStep6_2_ExtTu    = new HashMap( 8);

                    //6.3
                    m_mapStep6_3_Comments = new HashMap( 8);
                    m_mapStep6_3_Continue = new HashMap( 8);

                    //8.1
                    m_mapDegassing      = new HashMap( 8);

                    //10.1
                    m_mapActivation     = new HashMap( 8);

                    //11.3
                    m_mapStep11_3_1000mcA = new HashMap( 8);
                    m_mapStep11_3_1100mcA = new HashMap( 8);
                    m_mapStep11_3_1200mcA = new HashMap( 8);

                    //11.4
                    m_mapStep11_4_LasThreshold = new HashMap( 8);
                    m_mapStep11_4_ExtAn   = new HashMap( 8);
                    m_mapStep11_4_ExtTu   = new HashMap( 8);

                    //11.5
                    m_mapStep11_5_Comments = new HashMap( 8);
                    m_mapStep11_5_Continue = new HashMap( 8);
        
                    m_mapSteps = new TreeMap();
        
                    m_nCurrentProcessStep = 1;
                }
                else {
                    //m_nCurrentProcessStep = 1;        //выставка этапа должна быть сделана раньше
                }
            }
            else {
                //файл состояния был, но мы отказываемся от него
                m_nCurrentProcessStep = 1;
            }
        }
        else {
            //"чистый" запуск
            m_nCurrentProcessStep = 1;    
        }
        */
        m_nCurrentProcessStep = 1;
        
        m_bCurrentStepInProgress = false;
        m_dtTOend = null;
                
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( new Date( System.currentTimeMillis() - 1000 * 60 * 60 * GetSettings().GetTimeZoneShift()));
        
        m_strAdminStartDtm = String.format( "%02d.%02d.%02d.%02d.%02d.%02d",
                clndr.get(Calendar.YEAR),
                clndr.get(Calendar.MONTH) + 1,
                clndr.get(Calendar.DAY_OF_MONTH),
                clndr.get(Calendar.HOUR_OF_DAY),
                clndr.get(Calendar.MINUTE),
                clndr.get(Calendar.SECOND));
        
        m_ReportGenerator = new ReportGenerator( this);
        m_ReportGenerator.Generate();
    }
    
    public void start() {
        
        HVV_Admin4ArmSelect dlgArmSelect = new HVV_Admin4ArmSelect( null, true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        dlgArmSelect.setLocation( ( rect.width - dlgArmSelect.getWidth()) / 2, ( rect.height - dlgArmSelect.getHeight()) / 2);
        dlgArmSelect.setVisible( true);
        
        m_nArm = dlgArmSelect.GetSelectedArm();
        
        m_pMainWnd = new HVV_Admin4MainFrame( this);
        
        
        
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
                Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
                
                m_pMainWnd.setVisible( true);
                
                switch( m_nArm) {
                    case HVV_Admin4Constants.ARM1:
                        m_pMainWnd.setLocation( 0, 0);
                    break;
                    case HVV_Admin4Constants.ARM2:
                        m_pMainWnd.setLocation( 0, m_pMainWnd.getHeight() + m_pSettings.GetMainWndVerGap());
                    break;
                    case HVV_Admin4Constants.ARM3:
                        m_pMainWnd.setLocation( m_pMainWnd.getWidth() + m_pSettings.GetMainWndHorGap(), 0);
                    break;
                    case HVV_Admin4Constants.ARM4:
                        m_pMainWnd.setLocation( m_pMainWnd.getWidth() + m_pSettings.GetMainWndHorGap(),
                                                        m_pMainWnd.getHeight() + m_pSettings.GetMainWndVerGap());
                    break;
                    default:
                        m_pMainWnd.setLocation( ( rect.width - m_pMainWnd.getWidth()) / 2, ( rect.height - m_pMainWnd.getHeight()) / 2);
                }
                
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strAMSrootEnvVar = System.getenv( "AMS_ROOT");
        if( strAMSrootEnvVar == null) {
            MessageBoxError( "Не задана переменная окружения AMS_ROOT!", "HVV_Admin");
            return;
        }
        
        /*
        String strlog4jPropertiesFile = strAMSrootEnvVar + "/etc/log4j.admin.properties";
        File file = new File( "", strlog4jPropertiesFile);
        */
        File file = new File( strAMSrootEnvVar, "etc" + File.separator + "log4j.admin.properties");
        if(!file.exists()) {
            System.out.println("It is not possible to load the given log4j properties file :" + file.getAbsolutePath());
            BasicConfigurator.configure();
        }
        else
            PropertyConfigurator.configure( file.getAbsolutePath());
        
        logger.info( "HVV_Admin::main(): in. Start point!");
        
        
        new HVV_Admin4().start();
    }
    
    /**
     * Функция для сообщения пользователю информационного сообщения
     * @param strMessage сообщение
     * @param strTitleBar заголовок
     */
    public static void MessageBoxInfo( String strMessage, String strTitleBar)
    {
        JOptionPane.showMessageDialog( null, strMessage, strTitleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Функция для сообщения пользователю сообщения об ошибке
     * @param strMessage сообщение
     * @param strTitleBar заголовок
     */
    public static void MessageBoxError( String strMessage, String strTitleBar)
    {
        JOptionPane.showMessageDialog( null, strMessage, strTitleBar, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Функция для запроса у пользователя простого ответа Да/Нет
     * @param strMessage сообщение
     * @param strTitleBar заголовок
     */
    public static int MessageBoxAskYesNo( String strMessage, String strTitleBar)
    {
        //UIManager.put( "YES", "Да");
        //UIManager.put( "No", "Нет");
        
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.okButtonText", "Согласен");
        UIManager.put("OptionPane.yesButtonText", "Да");
    
        int nDialogResult = JOptionPane.showConfirmDialog( null, strMessage, strTitleBar, JOptionPane.YES_NO_OPTION);
        return nDialogResult;
    }
    
    public String strFormatDate( Date dt) {
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( dt);

        String strResult;
        switch( clndr.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:       strResult = "вс "; break;
            case Calendar.MONDAY:       strResult = "пн "; break;
            case Calendar.TUESDAY:      strResult = "вт "; break;
            case Calendar.WEDNESDAY:    strResult = "ср "; break;
            case Calendar.THURSDAY:     strResult = "чт "; break;
            case Calendar.FRIDAY:       strResult = "пт "; break;
            case Calendar.SATURDAY:     strResult = "сб "; break;
            default: strResult = "";
        }
        
        
        strResult += String.format( "%02d.%02d.%02d",
                clndr.get(Calendar.DAY_OF_MONTH),
                clndr.get(Calendar.MONTH) + 1,
                clndr.get(Calendar.YEAR));
        
        return strResult;
    }
    
    public String strFormatTime( Date dt) {
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( dt);

        String strResult = String.format( "%02d:%02d:%02d",
                clndr.get(Calendar.HOUR_OF_DAY),
                clndr.get(Calendar.MINUTE),
                clndr.get(Calendar.SECOND));
        
        return strResult;
    }
    
    public String strGetCurrentDate() {
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( new Date( System.currentTimeMillis() - 1000 * 60 * 60 * GetSettings().GetTimeZoneShift()));

        String strResult="";
        /*switch( clndr.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:       strResult = "вс "; break;
            case Calendar.MONDAY:       strResult = "пн "; break;
            case Calendar.TUESDAY:      strResult = "вт "; break;
            case Calendar.WEDNESDAY:    strResult = "ср "; break;
            case Calendar.THURSDAY:     strResult = "чт "; break;
            case Calendar.FRIDAY:       strResult = "пт "; break;
            case Calendar.SATURDAY:     strResult = "сб "; break;
            default: strResult = "";
        }*/
        
        strResult += String.format( "%02d.%02d.%02d",
                clndr.get(Calendar.YEAR),
                clndr.get(Calendar.MONTH) + 1,
                clndr.get(Calendar.DAY_OF_MONTH));
        
        return strResult;
    }
    
    public String strGetCurrentTime() {
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( new Date( System.currentTimeMillis() - 1000 * 60 * 60 * GetSettings().GetTimeZoneShift()));

        String strResult = String.format( "%02d:%02d:%02d",
                clndr.get(Calendar.HOUR_OF_DAY),
                clndr.get(Calendar.MINUTE),
                clndr.get(Calendar.SECOND));
        
        return strResult;
    }
    
    public Date GetLocalDate() {
        Date dt = new Date( System.currentTimeMillis() - 1000 * 60 * 60 * GetSettings().GetTimeZoneShift());
        return dt;
    }
}
