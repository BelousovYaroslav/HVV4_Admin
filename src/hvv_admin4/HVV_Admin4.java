/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4;

import hvv_admin4.planner.HVV_AdminPlanner;
import hvv_admin4.report.ReportGenerator;
import hvv_admin4.state.HVV_StateKeeper;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
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
    public HVV_StateKeeper m_pStateKeeper;
    
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
    
    private final HVV_AdminStepNames m_pStepNames;
    public String GetStepName( int nId) {
        String result = null;
        if( m_pStepNames.m_mapSteps.containsKey( String.format( "%03d", nId))) {
            ItemStepNames st = ( ItemStepNames) m_pStepNames.m_mapSteps.get( String.format( "%03d", nId));
            result = st.GetName();
        }
        return result;
    }
    public String GetStepNameWithNum( int nId) {
        String result = null;
        if( m_pStepNames.m_mapSteps.containsKey( String.format( "%03d", nId))) {
            ItemStepNames st = ( ItemStepNames) m_pStepNames.m_mapSteps.get( String.format( "%03d", nId));
            result = st.GetNum() + " " + st.GetName();
        }
        return result;
    }
    
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
    
    private TreeMap m_mapSteps;
    
    //SECRET BACKDOOR - used only in ReportGeneration
    public TreeMap SecretSteps() { return m_mapSteps;}
    
    public void ProcessingStepsRemoveStep( String strStepKey) { if( m_mapSteps.containsKey( strStepKey)) m_mapSteps.remove( strStepKey);}
    public boolean IsStepMapContainsKey( String strStepName) { return m_mapSteps.containsKey( strStepName);}
    public void SaveStepInfo( String strStepName, TechProcessStepCommon info, boolean bSaveState) {
        m_mapSteps.put( strStepName, info);
        if( bSaveState)
            m_pStateKeeper.SaveState();
    }
    
    public TechProcessStepCommon GetCommonStep( String strStepName) {
        TechProcessStepCommon ret = null;
        
        if( m_mapSteps.containsKey( strStepName))
            ret = ( TechProcessStepCommon) m_mapSteps.get( strStepName);
        
        return ret;
    }
    
    public TechProcessHvProcessInfo GetHvStep( String strStepName) {
        TechProcessHvProcessInfo ret = null;
        
        if( m_mapSteps.containsKey( strStepName))
            ret = ( TechProcessHvProcessInfo) m_mapSteps.get( strStepName);
        
        return ret;
    }
    
    public TechProcessGetterInfo GetGetterInfoStep( String strStepName) {
        TechProcessGetterInfo ret = null;
        
        if( m_mapSteps.containsKey( strStepName))
            ret = ( TechProcessGetterInfo) m_mapSteps.get( strStepName);
        
        return ret;
    }
    
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
    
            //5. Оценка параметров прибора
            case  81: m_nCurrentProcessStep =  82; break;  //5.1 Замеры параметров.Токи генерации
            case  82: m_nCurrentProcessStep =  83; break;  //5.2 Замеры параметров.ВАХ
            case  83: m_nCurrentProcessStep =  101; break; //5.3 Внесение комментариев
                
            //6. Тренировка катода
            case 101: m_nCurrentProcessStep = 102; break;  //6.1 Выдержка
            case 102: m_nCurrentProcessStep = 103; break;  //6.2 Обработка первый цикл
            case 103: m_nCurrentProcessStep = 104; break;  //6.3 Выдержка
            case 104: m_nCurrentProcessStep = 105; break;  //6.4 Обработка второй цикл
            case 105: m_nCurrentProcessStep = 106; break;  //6.5 Выдержка
            case 106: m_nCurrentProcessStep = 121; break;  //6.6 Обработка третий цикл
                
            //7. Обезгаживание рабочих геттеров
            case 121: m_nCurrentProcessStep = 122; break;  //7.1 Подготовка технолог. геттера
            case 122: m_nCurrentProcessStep = 141; break;  //7.2 Обезгаживание
                
            //8. Тренировка в тренировочной смеси
            case 141: m_nCurrentProcessStep = 142; break;  //8.1 Выдержка
            case 142: m_nCurrentProcessStep = 143; break;  //8.2 Тренировка первый цикл
            case 143: m_nCurrentProcessStep = 144; break;  //8.3 Выдержка
            case 144: m_nCurrentProcessStep = 161; break;  //8.4 Тренировка второй цикл
    
            //9. Активация рабочих геттеров
            case 161: m_nCurrentProcessStep = 162; break;  //9.1 Подготовка к активации
            case 162: m_nCurrentProcessStep = 181; break;  //9.2 Активация

            //10. Выходная оценка параметров
            case 181: m_nCurrentProcessStep = 182; break;  //10.1 Выдержка
            case 182: m_nCurrentProcessStep = 183; break;  //10.2 Замеры параметров. токи генерации
            case 183: m_nCurrentProcessStep = 184; break;  //10.3 Замеры параметров. ВАХ
            case 184: m_nCurrentProcessStep = 185; break;  //10.4 Итоговый комментарий
                
        }
        m_bCurrentStepInProgress = false;
    }
    
    public HVV_Admin4() {
        m_strAMSrootEnvVar = System.getenv( "AMS_ROOT");
        
        //SETTINGS
        m_pSettings = new HVV_Admin4Settings( m_strAMSrootEnvVar);
        
        //STEP NAMES
        m_pStepNames = new HVV_AdminStepNames( m_strAMSrootEnvVar);
        
        //PLANNER
        m_pPlanner = new HVV_AdminPlanner( this);
        
        //RESOURCES
        m_Resources = HVV_Resources.getInstance();
        
        m_fontUsual = new Font( "Cantarell", Font.PLAIN, 15);
        m_fontBold = new Font( "Cantarell", Font.BOLD, 15);
        
        m_nArm = -1;
        m_nProcessedDeviceType = -1;
        m_strSerial = null;
        
        m_bFailInMiddleFlag = false;
                
        m_mapSteps = new TreeMap();        
    }
    
    public void start() {
        
        HVV_Admin4ArmSelect dlgArmSelect = new HVV_Admin4ArmSelect( null, true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        dlgArmSelect.setLocation( ( rect.width - dlgArmSelect.getWidth()) / 2, ( rect.height - dlgArmSelect.getHeight()) / 2);
        dlgArmSelect.setVisible( true);
        
        m_nArm = dlgArmSelect.GetSelectedArm();
        
        m_dtTOend = null;
        
        m_pStateKeeper = new HVV_StateKeeper( this);
        if( m_pStateKeeper.CheckStateKeeperFileExistance()) {
            int nResponce = MessageBoxAskYesNo( "Обнаружен файл хранения состояния.\nВосстановить состояние предыдущего запуска?", "HVV_Admin");
            if( nResponce == JOptionPane.YES_OPTION) {
                m_pStateKeeper.RestoreState();
                if( m_pStateKeeper.m_bDropReadState == true) {
                    //файл восстановления был, мы его попросили восстановить, но, увидев, отказались
                    m_strSerial = null;
                    m_nProcessedDeviceType = -1;
                    m_mapSteps = new TreeMap();
                    m_nCurrentProcessStep = 1;
                }
                else {
                    //файл восстановления был, и мы его восстановили
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
        
        //m_nCurrentProcessStep = 1;
        
        m_bCurrentStepInProgress = false;
        
                
        GregorianCalendar clndr = new GregorianCalendar();
        clndr.setTime( new Date( System.currentTimeMillis() - 1000 * 60 * 60 * m_pSettings.GetTimeZoneShift()));
        
        m_strAdminStartDtm = String.format( "%02d.%02d.%02d.%02d.%02d.%02d",
                clndr.get(Calendar.YEAR),
                clndr.get(Calendar.MONTH) + 1,
                clndr.get(Calendar.DAY_OF_MONTH),
                clndr.get(Calendar.HOUR_OF_DAY),
                clndr.get(Calendar.MINUTE),
                clndr.get(Calendar.SECOND));
        
        m_ReportGenerator = new ReportGenerator( this);
        m_ReportGenerator.Generate();
        
        m_pMainWnd = new HVV_Admin4MainFrame( this);
        
        if( m_nCurrentProcessStep != 1) {
            switch( m_nCurrentProcessStep) {
                case 42:
                case 44:
                    //мы сломались на этапе O2=Ne20 на длинном плече. его доделали. хотим делать короткое
                    m_pMainWnd.m_pnlMain.setVisible( false);
                    m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                    m_pMainWnd.m_pnlEnterHvVoltage.Init();
                    
                    TechProcessHvProcessInfo inf = ( TechProcessHvProcessInfo) GetCommonStep( "041");
                    inf.SetStartReportTitle( "1ый цикл. Обработка по длинному плечу.");
                    SaveStepInfo( "041", inf, false);
                
                    TechProcessHvProcessInfo infhv = new TechProcessHvProcessInfo();
                    infhv.SetStartDateAsCurrent( GetSettings().GetTimeZoneShift());
                    infhv.SetStartReportTitle( "1ый цикл. Обработка по коротким плечам.");
                    SaveStepInfo( "042", infhv, false);
                
                    m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( GetSettings().GetProcessingTime_3());
                    
                break;
                    
                case 62:
                    //мы сломались на этапе ввода даты завершения ТО (rare)
                    //включаем таймер
                    m_pMainWnd.m_pnlMain.setVisible( false);
                    m_pMainWnd.m_pnlStopWatch.Init();
                    m_pMainWnd.m_pnlStopWatch.setVisible( true);

                    if( GetSettings().GetDebugShortenThermoProcessing()) {
                        //DEBUG
                        m_pMainWnd.m_pnlStopWatch.StartTimer( ( long) 5410, 0);
                    }
                    else {
                        //GOOD
                        Date dtNow = GetLocalDate();
                        long nSpan = ( long) ( Math.ceil( ( GetDtmTOEnd().getTime() - dtNow.getTime()) / 1000. / 60. / 10.)) * 10;
                        m_pMainWnd.m_pnlStopWatch.StartTimer( nSpan * 60, 0);
                    }
                break;
                    
                case 63:
                    //мы сломались на этапе ТО
                    //подразумевается что выждали нужное время и теперь готовы вводить информацию GetterInfo
                    m_pMainWnd.m_pnlEnterGetterInfo.InitOnStart( GetCommonStep( "062").GetStopDate(), 1);
                    m_pMainWnd.m_pnlEnterGetterInfo.setVisible( true);
                    SetCurrentStepInProgress( true);
                break;
            }
        }
        
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
        File file = new File( strAMSrootEnvVar, "etc" + File.separator + "log4j.admin4.properties");
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
