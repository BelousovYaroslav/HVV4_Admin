/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author yaroslav
 */
public class HVV_Admin4Settings {
    static Logger logger = Logger.getLogger(HVV_Admin4Settings.class);
    
    private int m_nTimeZoneShift;
    public int GetTimeZoneShift() { return m_nTimeZoneShift;}
    
    private boolean m_bDebugShortenProgTimes;
    public boolean GetDebugShortenProgTimes() { return m_bDebugShortenProgTimes; }
    
    private boolean m_bDebugShortenProgItems;
    public boolean GetDebugShortenProgItems() { return m_bDebugShortenProgItems; }
    
    private boolean m_bDebugShortenThermoProcessing;
    public boolean GetDebugShortenThermoProcessing() { return m_bDebugShortenThermoProcessing; }
    
    private boolean m_bUsePlanner;
    public boolean GetUsePlanner() { return m_bUsePlanner; }
    
    private int m_nProcessingTime_2;
    public int GetProcessingTime_2() { return m_nProcessingTime_2;}
    
    private int m_nProcessingTime_3;
    public int GetProcessingTime_3() { return m_nProcessingTime_3;}
    
    private int m_nProcessingTime_6;
    public int GetProcessingTime_6() { return m_nProcessingTime_6;}
    
    private int m_nProcessingTime_8;
    public int GetProcessingTime_8() { return m_nProcessingTime_8;}
    
    private int m_nExcerptTime;
    public int GetExcerptTime() { return m_nExcerptTime;}
    
    
    private int m_nMainWndHorGap;
    public int GetMainWndHorGap() { return m_nMainWndHorGap;}
    
    private int m_nMainWndVerGap;
    public int GetMainWndVerGap() { return m_nMainWndVerGap;}
    
    private String m_strRemoteReportsPath;
    public String GetRemoteReportsPath() { return m_strRemoteReportsPath;}

    //коэффициент пересчёта напряжений для РМ1
    private double m_dblCoeffU_ARM1;
    public double GetCoeffU_ARM1() { return m_dblCoeffU_ARM1;}
    
    //коэффициент пересчёта напряжений для РМ2
    private double m_dblCoeffU_ARM2;
    public double GetCoeffU_ARM2() { return m_dblCoeffU_ARM2;}
    
    //коэффициент пересчёта напряжений для РМ3
    private double m_dblCoeffU_ARM3;
    public double GetCoeffU_ARM3() { return m_dblCoeffU_ARM3;}
    
    //коэффициент пересчёта напряжений для РМ4
    private double m_dblCoeffU_ARM4;
    public double GetCoeffU_ARM4() { return m_dblCoeffU_ARM4;}
    
    //коэффициент пересчёта напряжений для UNIVERSAL
    public double GetCoeffU( int nArm) {
        double dblResult = 1.;
        switch( nArm) {
            case HVV_Admin4Constants.ARM1: dblResult = m_dblCoeffU_ARM1; break;
            case HVV_Admin4Constants.ARM2: dblResult = m_dblCoeffU_ARM2; break;
            case HVV_Admin4Constants.ARM3: dblResult = m_dblCoeffU_ARM3; break;
            case HVV_Admin4Constants.ARM4: dblResult = m_dblCoeffU_ARM4; break;
        }
        return dblResult;
    }
    
    private String m_strPuff2Message0_small, m_strPuff2Message0_medium, m_strPuff2Message0_big;
    private String m_strPuff2Message1_small, m_strPuff2Message1_medium, m_strPuff2Message1_big;
    private String m_strPuff2Message2_small, m_strPuff2Message2_medium, m_strPuff2Message2_big;
    private String m_strPuff2Message3_small, m_strPuff2Message3_medium, m_strPuff2Message3_big;
    
    private String m_strPuff3Message0_small, m_strPuff3Message0_medium, m_strPuff3Message0_big;
    private String m_strPuff3Message1_small, m_strPuff3Message1_medium, m_strPuff3Message1_big;
    private String m_strPuff3Message2_small, m_strPuff3Message2_medium, m_strPuff3Message2_big;
    private String m_strPuff3Message3_small, m_strPuff3Message3_medium, m_strPuff3Message3_big;
    
    private String m_strPuff4Message0_small, m_strPuff4Message0_medium, m_strPuff4Message0_big;
    private String m_strPuff4Message1_small, m_strPuff4Message1_medium, m_strPuff4Message1_big;
    private String m_strPuff4Message2_small, m_strPuff4Message2_medium, m_strPuff4Message2_big;
    private String m_strPuff4Message3_small, m_strPuff4Message3_medium, m_strPuff4Message3_big;
    
    private String m_strPuff6Message0_small, m_strPuff6Message0_medium, m_strPuff6Message0_big;
    private String m_strPuff6Message1_small, m_strPuff6Message1_medium, m_strPuff6Message1_big;
    private String m_strPuff6Message2_small, m_strPuff6Message2_medium, m_strPuff6Message2_big;
    private String m_strPuff6Message3_small, m_strPuff6Message3_medium, m_strPuff6Message3_big;
    
    private String m_strPuff8Message0_small, m_strPuff8Message0_medium, m_strPuff8Message0_big;
    private String m_strPuff8Message1_small, m_strPuff8Message1_medium, m_strPuff8Message1_big;
    private String m_strPuff8Message2_small, m_strPuff8Message2_medium, m_strPuff8Message2_big;
    private String m_strPuff8Message3_small, m_strPuff8Message3_medium, m_strPuff8Message3_big;
    
    private String m_strPuff10Message0_small, m_strPuff10Message0_medium, m_strPuff10Message0_big;
    private String m_strPuff10Message1_small, m_strPuff10Message1_medium, m_strPuff10Message1_big;
    private String m_strPuff10Message2_small, m_strPuff10Message2_medium, m_strPuff10Message2_big;
    private String m_strPuff10Message3_small, m_strPuff10Message3_medium, m_strPuff10Message3_big;
    
    
    public String GetPuffMessage( int nStep, int nMessage, int nDeviceSize) {
        String strResult = "";
        switch( nDeviceSize) {
            case HVV_Admin4Constants.DEVICE_SMALL:  strResult = GetPuffMessageSmall( nStep, nMessage); break;
            case HVV_Admin4Constants.DEVICE_MEDIUM: strResult = GetPuffMessageMedium( nStep, nMessage); break;
            case HVV_Admin4Constants.DEVICE_BIG:    strResult = GetPuffMessageBig( nStep, nMessage); break;
        }
        return strResult;
    }
    
    public String GetPuffMessageBig( int nStep, int nMessage) {
        String strResult = "";
        switch( nStep) {
            case 2:
                switch( nMessage) {
                    case 0: strResult = m_strPuff2Message0_big; break;
                    case 1: strResult = m_strPuff2Message1_big; break;
                    case 2: strResult = m_strPuff2Message2_big; break;
                    case 3: strResult = m_strPuff2Message3_big; break;
                }
            break;
            
            case 3:
                switch( nMessage) {
                    case 0: strResult = m_strPuff3Message0_big; break;
                    case 1: strResult = m_strPuff3Message1_big; break;
                    case 2: strResult = m_strPuff3Message2_big; break;
                    case 3: strResult = m_strPuff3Message3_big; break;
                }
            break;
                
            case 4:
                switch( nMessage) {
                    case 0: strResult = m_strPuff4Message0_big; break;
                    case 1: strResult = m_strPuff4Message1_big; break;
                    case 2: strResult = m_strPuff4Message2_big; break;
                    case 3: strResult = m_strPuff4Message3_big; break;
                }
            break;
                
            case 6:
                switch( nMessage) {
                    case 0: strResult = m_strPuff6Message0_big; break;
                    case 1: strResult = m_strPuff6Message1_big; break;
                    case 2: strResult = m_strPuff6Message2_big; break;
                    case 3: strResult = m_strPuff6Message3_big; break;
                }
            break;
                
            case 8:
                switch( nMessage) {
                    case 0: strResult = m_strPuff8Message0_big; break;
                    case 1: strResult = m_strPuff8Message1_big; break;
                    case 2: strResult = m_strPuff8Message2_big; break;
                    case 3: strResult = m_strPuff8Message3_big; break;
                }
            break;
                
            case 10:
                switch( nMessage) {
                    case 0: strResult = m_strPuff10Message0_big; break;
                    case 1: strResult = m_strPuff10Message1_big; break;
                    case 2: strResult = m_strPuff10Message2_big; break;
                    case 3: strResult = m_strPuff10Message3_big; break;
                }
            break;
        }
        return strResult;
    }
    
    public String GetPuffMessageMedium( int nStep, int nMessage) {
        String strResult = "";
        switch( nStep) {
            case 2:
                switch( nMessage) {
                    case 0: strResult = m_strPuff2Message0_medium; break;
                    case 1: strResult = m_strPuff2Message1_medium; break;
                    case 2: strResult = m_strPuff2Message2_medium; break;
                    case 3: strResult = m_strPuff2Message3_medium; break;
                }
            break;
            
            case 3:
                switch( nMessage) {
                    case 0: strResult = m_strPuff3Message0_medium; break;
                    case 1: strResult = m_strPuff3Message1_medium; break;
                    case 2: strResult = m_strPuff3Message2_medium; break;
                    case 3: strResult = m_strPuff3Message3_medium; break;
                }
            break;
                
            case 4:
                switch( nMessage) {
                    case 0: strResult = m_strPuff4Message0_medium; break;
                    case 1: strResult = m_strPuff4Message1_medium; break;
                    case 2: strResult = m_strPuff4Message2_medium; break;
                    case 3: strResult = m_strPuff4Message3_medium; break;
                }
            break;
                
            case 6:
                switch( nMessage) {
                    case 0: strResult = m_strPuff6Message0_medium; break;
                    case 1: strResult = m_strPuff6Message1_medium; break;
                    case 2: strResult = m_strPuff6Message2_medium; break;
                    case 3: strResult = m_strPuff6Message3_medium; break;
                }
            break;
                
            case 8:
                switch( nMessage) {
                    case 0: strResult = m_strPuff8Message0_medium; break;
                    case 1: strResult = m_strPuff8Message1_medium; break;
                    case 2: strResult = m_strPuff8Message2_medium; break;
                    case 3: strResult = m_strPuff8Message3_medium; break;
                }
            break;
                
            case 10:
                switch( nMessage) {
                    case 0: strResult = m_strPuff10Message0_medium; break;
                    case 1: strResult = m_strPuff10Message1_medium; break;
                    case 2: strResult = m_strPuff10Message2_medium; break;
                    case 3: strResult = m_strPuff10Message3_medium; break;
                }
            break;
        }
        return strResult;
    }
    
    public String GetPuffMessageSmall( int nStep, int nMessage) {
        String strResult = "";
        switch( nStep) {
            case 2:
                switch( nMessage) {
                    case 0: strResult = m_strPuff2Message0_small; break;
                    case 1: strResult = m_strPuff2Message1_small; break;
                    case 2: strResult = m_strPuff2Message2_small; break;
                    case 3: strResult = m_strPuff2Message3_small; break;
                }
            break;
            
            case 3:
                switch( nMessage) {
                    case 0: strResult = m_strPuff3Message0_small; break;
                    case 1: strResult = m_strPuff3Message1_small; break;
                    case 2: strResult = m_strPuff3Message2_small; break;
                    case 3: strResult = m_strPuff3Message3_small; break;
                }
            break;
                
            case 4:
                switch( nMessage) {
                    case 0: strResult = m_strPuff4Message0_small; break;
                    case 1: strResult = m_strPuff4Message1_small; break;
                    case 2: strResult = m_strPuff4Message2_small; break;
                    case 3: strResult = m_strPuff4Message3_small; break;
                }
            break;
                
            case 6:
                switch( nMessage) {
                    case 0: strResult = m_strPuff6Message0_small; break;
                    case 1: strResult = m_strPuff6Message1_small; break;
                    case 2: strResult = m_strPuff6Message2_small; break;
                    case 3: strResult = m_strPuff6Message3_small; break;
                }
            break;
                
            case 8:
                switch( nMessage) {
                    case 0: strResult = m_strPuff8Message0_small; break;
                    case 1: strResult = m_strPuff8Message1_small; break;
                    case 2: strResult = m_strPuff8Message2_small; break;
                    case 3: strResult = m_strPuff8Message3_small; break;
                }
            break;
                
            case 10:
                switch( nMessage) {
                    case 0: strResult = m_strPuff10Message0_small; break;
                    case 1: strResult = m_strPuff10Message1_small; break;
                    case 2: strResult = m_strPuff10Message2_small; break;
                    case 3: strResult = m_strPuff10Message3_small; break;
                }
            break;
        }
        return strResult;
    }
    
    public HVV_Admin4Settings( String strAMSRoot) {
        //TIME ZONE SHIFT
        m_nTimeZoneShift = 1;
        
        m_bDebugShortenProgItems = false;
        m_bDebugShortenProgTimes = false;
        m_bDebugShortenThermoProcessing = false;
        
        m_bUsePlanner = false;
        
        m_nProcessingTime_2 = 20 * 60;
        m_nProcessingTime_3 = 20 * 60;
        m_nProcessingTime_6 = 20 * 60;
        m_nProcessingTime_8 = 20 * 60;
        
        m_nExcerptTime = 5;

        m_nMainWndHorGap = 5;
        m_nMainWndVerGap = 25;
        
        m_strRemoteReportsPath = "";
        
        ReadSettings();
    }
    
    private boolean ReadSettings() {
        boolean bResOk = true;
        try {
            SAXReader reader = new SAXReader();
            
            String strWorkingDir = System.getenv( "AMS_ROOT");
            String strRelFilePath = "etc" + File.separator + "settings.admin4.xml";
            
            File fileSettings = new java.io.File( strWorkingDir, strRelFilePath);
            Document document = reader.read( fileSettings);
            
            Element root = document.getRootElement();

            // iterate through child elements of root
            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String name = element.getName();
                String value = element.getText();
                
                //logger.debug( "Pairs: [" + name + " : " + value + "]");
                
                if( "timezone".equals( name)) m_nTimeZoneShift = Integer.parseInt( value);
                
                //<!-- длительность обработки кислородом (в секундах) -->
                if( "processing.time.2".equals( name))  m_nProcessingTime_2 = Integer.parseInt( value);

                //<!-- длительность обработки кислород-неоном (в секундах) -->
                if( "processing.time.3".equals( name))  m_nProcessingTime_3 = Integer.parseInt( value);

                //<!-- длительность тренировки катода (в секундах) -->
                if( "processing.time.6".equals( name))  m_nProcessingTime_6 = Integer.parseInt( value);

                //<!-- длительность тренировки втренировочной смеси (в секундах) -->
                if( "processing.time.8".equals( name))  m_nProcessingTime_8 = Integer.parseInt( value);
 

                //<!-- время выдержки (в секундах) -->
                if( "excerpt.time".equals( name))  m_nExcerptTime = Integer.parseInt( value);
  
                
                //<!-- время выдержки (в секундах) -->
                if( "mainwnd.hor.gap".equals( name))  m_nMainWndHorGap = Integer.parseInt( value);
                
                //<!-- время выдержки (в секундах) -->
                if( "mainwnd.ver.gap".equals( name))  m_nMainWndVerGap = Integer.parseInt( value);
          
                //<!-- путь к папке на внешнем хранилище куда складывать готовые отчёты -->
                if( "RemoteReportsPath".equals( name))  m_strRemoteReportsPath = value;
          
                //<!-- ОТЛАДКА: сократить количество пунктов программ обезгаживания и активации -->
                if( "debug.shorten.program.items".equals( name)) {
                    if( "true".equals( value))
                        m_bDebugShortenProgItems = true;
                }
                
                //<!-- ОТЛАДКА: сократить длительность пунктов программ обезгаживания и активации -->
                if( "debug.shorten.program.times".equals( name)) {
                    if( "true".equals( value))
                        m_bDebugShortenProgTimes = true;
                }
                
                //<!-- ОТЛАДКА: использовать короткое термообезгаживание -->
                if( "debug.shorten.thermoprocessing".equals( name)) {
                    if( "true".equals( value))
                        m_bDebugShortenThermoProcessing = true;
                }
                
                //Использование планировщика
                if( "use.planner".equals( name)) {
                    if( "true".equals( value))
                        m_bUsePlanner = true;
                }
                
                //<!-- длительность обработки кислородом (в секундах) -->
                if( "processing.time.2".equals( name))  m_nProcessingTime_2 = Integer.parseInt( value);

                //<!-- длительность обработки кислород-неоном (в секундах) -->
                if( "processing.time.3".equals( name))  m_nProcessingTime_3 = Integer.parseInt( value);

                //<!-- длительность тренировки катода (в секундах) -->
                if( "processing.time.6".equals( name))  m_nProcessingTime_6 = Integer.parseInt( value);

                //<!-- длительность тренировки втренировочной смеси (в секундах) -->
                if( "processing.time.8".equals( name))  m_nProcessingTime_8 = Integer.parseInt( value);
 

                //<!-- время выдержки (в секундах) -->
                if( "excerpt.time".equals( name))  m_nExcerptTime = Integer.parseInt( value);
                
                //<!--коэффициент пересчёта напряжений РМ1 -->
                if( "Coeff.U.ARM1".equals( name)) m_dblCoeffU_ARM1 = Double.parseDouble( value);
                
                //<!--коэффициент пересчёта напряжений РМ2 -->
                if( "Coeff.U.ARM2".equals( name)) m_dblCoeffU_ARM2 = Double.parseDouble( value);
                
                //<!--коэффициент пересчёта напряжений РМ3 -->
                if( "Coeff.U.ARM3".equals( name)) m_dblCoeffU_ARM3 = Double.parseDouble( value);
                
                //<!--коэффициент пересчёта напряжений РМ4 -->
                if( "Coeff.U.ARM4".equals( name)) m_dblCoeffU_ARM4 = Double.parseDouble( value);
                
                //ВСПОМОГАТЕЛЬНЫЕ СООБЩЕНИЯ ДЛЯ НАПУСКОВ И ОБРАБОТКИ
                //Малый прибор
                //для 2 этапа (напуск кислорода)
                if( "Puff.2.Message0.small".equals( name)) m_strPuff2Message0_small = value;
                if( "Puff.2.Message1.small".equals( name)) m_strPuff2Message1_small = value;
                if( "Puff.2.Message2.small".equals( name)) m_strPuff2Message2_small = value;
                if( "Puff.2.Message3.small".equals( name)) m_strPuff2Message3_small = value;
                
                //для 3 этапа (напуск кислород-неона)
                if( "Puff.3.Message0.small".equals( name)) m_strPuff3Message0_small = value;
                if( "Puff.3.Message1.small".equals( name)) m_strPuff3Message1_small = value;
                if( "Puff.3.Message2.small".equals( name)) m_strPuff3Message2_small = value;
                if( "Puff.3.Message3.small".equals( name)) m_strPuff3Message3_small = value;
                
                //для 4 этапа (напуск кислород-неона)
                if( "Puff.4.Message0.small".equals( name)) m_strPuff4Message0_small = value;
                if( "Puff.4.Message1.small".equals( name)) m_strPuff4Message1_small = value;
                if( "Puff.4.Message2.small".equals( name)) m_strPuff4Message2_small = value;
                if( "Puff.4.Message3.small".equals( name)) m_strPuff4Message3_small = value;
                
                //для 6 этапа (тренировка катода)
                if( "Puff.6.Message0.small".equals( name)) m_strPuff6Message0_small = value;
                if( "Puff.6.Message1.small".equals( name)) m_strPuff6Message1_small = value;
                if( "Puff.6.Message2.small".equals( name)) m_strPuff6Message2_small = value;
                if( "Puff.6.Message3.small".equals( name)) m_strPuff6Message3_small = value;
                
                //для 8 этапа (тренировка катода)
                if( "Puff.8.Message0.small".equals( name)) m_strPuff8Message0_small = value;
                if( "Puff.8.Message1.small".equals( name)) m_strPuff8Message1_small = value;
                if( "Puff.8.Message2.small".equals( name)) m_strPuff8Message2_small = value;
                if( "Puff.8.Message3.small".equals( name)) m_strPuff8Message3_small = value;
                
                //для 10 этапа (тренировка катода)
                if( "Puff.10.Message0.small".equals( name)) m_strPuff10Message0_small = value;
                if( "Puff.10.Message1.small".equals( name)) m_strPuff10Message1_small = value;
                if( "Puff.10.Message2.small".equals( name)) m_strPuff10Message2_small = value;
                if( "Puff.10.Message3.small".equals( name)) m_strPuff10Message3_small = value;
                
          
                
                //ВСПОМОГАТЕЛЬНЫЕ СООБЩЕНИЯ ДЛЯ НАПУСКОВ И ОБРАБОТКИ
                //большой прибор (ЛГ)
                //для 2 этапа (напуск кислорода)
                if( "Puff.2.Message0.medium".equals( name)) m_strPuff2Message0_medium = value;
                if( "Puff.2.Message1.medium".equals( name)) m_strPuff2Message1_medium = value;
                if( "Puff.2.Message2.medium".equals( name)) m_strPuff2Message2_medium = value;
                if( "Puff.2.Message3.medium".equals( name)) m_strPuff2Message3_medium = value;
                
                //для 3 этапа (напуск кислород-неона)
                if( "Puff.3.Message0.medium".equals( name)) m_strPuff3Message0_medium = value;
                if( "Puff.3.Message1.medium".equals( name)) m_strPuff3Message1_medium = value;
                if( "Puff.3.Message2.medium".equals( name)) m_strPuff3Message2_medium = value;
                if( "Puff.3.Message3.medium".equals( name)) m_strPuff3Message3_medium = value;
                
                //для 4 этапа (напуск кислород-неона)
                if( "Puff.4.Message0.medium".equals( name)) m_strPuff4Message0_medium = value;
                if( "Puff.4.Message1.medium".equals( name)) m_strPuff4Message1_medium = value;
                if( "Puff.4.Message2.medium".equals( name)) m_strPuff4Message2_medium = value;
                if( "Puff.4.Message3.medium".equals( name)) m_strPuff4Message3_medium = value;
                
                //для 6 этапа (тренировка катода)
                if( "Puff.6.Message0.medium".equals( name)) m_strPuff6Message0_medium = value;
                if( "Puff.6.Message1.medium".equals( name)) m_strPuff6Message1_medium = value;
                if( "Puff.6.Message2.medium".equals( name)) m_strPuff6Message2_medium = value;
                if( "Puff.6.Message3.medium".equals( name)) m_strPuff6Message3_medium = value;
                
                //для 8 этапа (тренировка катода)
                if( "Puff.8.Message0.medium".equals( name)) m_strPuff8Message0_medium = value;
                if( "Puff.8.Message1.medium".equals( name)) m_strPuff8Message1_medium = value;
                if( "Puff.8.Message2.medium".equals( name)) m_strPuff8Message2_medium = value;
                if( "Puff.8.Message3.medium".equals( name)) m_strPuff8Message3_medium = value;
                
                //для 10 этапа (тренировка катода)
                if( "Puff.10.Message0.medium".equals( name)) m_strPuff10Message0_medium = value;
                if( "Puff.10.Message1.medium".equals( name)) m_strPuff10Message1_medium = value;
                if( "Puff.10.Message2.medium".equals( name)) m_strPuff10Message2_medium = value;
                if( "Puff.10.Message3.medium".equals( name)) m_strPuff10Message3_medium = value;
                
                
                
                //ВСПОМОГАТЕЛЬНЫЕ СООБЩЕНИЯ ДЛЯ НАПУСКОВ И ОБРАБОТКИ
                //большой большой прибор (БЛГ)
                //для 2 этапа (напуск кислорода)
                if( "Puff.2.Message0.big".equals( name)) m_strPuff2Message0_big = value;
                if( "Puff.2.Message1.big".equals( name)) m_strPuff2Message1_big = value;
                if( "Puff.2.Message2.big".equals( name)) m_strPuff2Message2_big = value;
                if( "Puff.2.Message3.big".equals( name)) m_strPuff2Message3_big = value;
                
                //для 3 этапа (напуск кислород-неона)
                if( "Puff.3.Message0.big".equals( name)) m_strPuff3Message0_big = value;
                if( "Puff.3.Message1.big".equals( name)) m_strPuff3Message1_big = value;
                if( "Puff.3.Message2.big".equals( name)) m_strPuff3Message2_big = value;
                if( "Puff.3.Message3.big".equals( name)) m_strPuff3Message3_big = value;
                
                //для 4 этапа (напуск кислород-неона)
                if( "Puff.4.Message0.big".equals( name)) m_strPuff4Message0_big = value;
                if( "Puff.4.Message1.big".equals( name)) m_strPuff4Message1_big = value;
                if( "Puff.4.Message2.big".equals( name)) m_strPuff4Message2_big = value;
                if( "Puff.4.Message3.big".equals( name)) m_strPuff4Message3_big = value;
                
                //для 6 этапа (тренировка катода)
                if( "Puff.6.Message0.big".equals( name)) m_strPuff6Message0_big = value;
                if( "Puff.6.Message1.big".equals( name)) m_strPuff6Message1_big = value;
                if( "Puff.6.Message2.big".equals( name)) m_strPuff6Message2_big = value;
                if( "Puff.6.Message3.big".equals( name)) m_strPuff6Message3_big = value;
                
                //для 8 этапа (тренировка катода)
                if( "Puff.8.Message0.big".equals( name)) m_strPuff8Message0_big = value;
                if( "Puff.8.Message1.big".equals( name)) m_strPuff8Message1_big = value;
                if( "Puff.8.Message2.big".equals( name)) m_strPuff8Message2_big = value;
                if( "Puff.8.Message3.big".equals( name)) m_strPuff8Message3_big = value;
                
                //для 10 этапа (тренировка катода)
                if( "Puff.10.Message0.big".equals( name)) m_strPuff10Message0_big = value;
                if( "Puff.10.Message1.big".equals( name)) m_strPuff10Message1_big = value;
                if( "Puff.10.Message2.big".equals( name)) m_strPuff10Message2_big = value;
                if( "Puff.10.Message3.big".equals( name)) m_strPuff10Message3_big = value;
            }
            
        } catch( DocumentException ex) {
            logger.error( "DocumentException caught while loading settings!", ex);
            bResOk = false;
        }
        
        return bResOk;
    }
    
    public boolean ReadSettingsDbg() {
        boolean bResOk = true;
        try {
            SAXReader reader = new SAXReader();
            
            String strSettingsFilePathName = System.getenv( "AMS_ROOT") + "/etc/settings.admin.xml";
            URL url = ( new java.io.File( "", strSettingsFilePathName)).toURI().toURL();
            
            Document document = reader.read( url);
            
            Element root = document.getRootElement();

            // iterate through child elements of root
            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String name = element.getName();
                String value = element.getText();
                
                //logger.debug( "Pairs: [" + name + " : " + value + "]");
                
                if( "debug.shorten.program.items".equals( name)) {
                    m_bDebugShortenProgItems = "true".equals( value);
                        
                }
                
                if( "debug.shorten.program.times".equals( name)) {
                    m_bDebugShortenProgTimes = "true".equals( value);
                }
                
                if( "debug.shorten.thermoprocessing".equals( name)) {
                    m_bDebugShortenThermoProcessing = "true".equals( value);
                }
                
            }
            
        } catch( MalformedURLException ex) {
            logger.error( "MalformedURLException caught while loading settings!", ex);
            bResOk = false;
        } catch( DocumentException ex) {
            logger.error( "DocumentException caught while loading settings!", ex);
            bResOk = false;
        }
        
        return bResOk;
    }
}
