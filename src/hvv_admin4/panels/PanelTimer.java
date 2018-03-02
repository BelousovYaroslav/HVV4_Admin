/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessGetterInfo;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import hvv_admin4.steps.info.TechProcessIgenIextProcessInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelTimer extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelTimer.class);
    
    public int m_nFlasher;
    
    public long m_lDownTickTimer;
    Timer m_pDownTickTimer;
    
    public long m_lUpTickTimer;
    Timer m_pUpTickTimer;
    
    final Color m_clrRed;
    
    private final int TIMER_UPTICK = 1;
    private final int TIMER_DOWNTICK = 2;
    private int m_nTimerToShow;
    /**
     * Creates new form PanelProcess
     */
    public PanelTimer( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        
        m_clrRed =  new Color( 220, 150, 150);
        
        m_pUpTickTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_lUpTickTimer++;
                if( m_nTimerToShow == TIMER_UPTICK) {
                    int nHou = ( int) ( m_lUpTickTimer / 3600);
                    int nMin = ( int) ( ( m_lUpTickTimer % 3600) / 60);
                    int nSec = ( int) ( m_lUpTickTimer % 60);
                    lblTimer.setText( String.format( "%02d:%02d:%02d", nHou, nMin, nSec));
                }
            }
        });
        
        m_nTimerToShow = TIMER_DOWNTICK;
    }

    public void Init() {
        chkLongShoulder.setVisible( false);
        btnNext.setBackground( null);
        
        switch( theApp.GetCurrentStep()) {
            case 21:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>2.1 Обработка O<sub>2</sub>. Первый цикл.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 23:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>2.3 Обработка O<sub>2</sub>. Второй цикл.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
                
            case 41:
                m_nTimerToShow = TIMER_DOWNTICK;
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM)
                    lblTitle.setText( "<html><u>3.1 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 1. Длинное плечо</u></thml>");
                else
                    lblTitle.setText( "<html><u>3.1 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 1.</u></thml>");
                
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) {
                    chkLongShoulder.setVisible( true);
                    chkLongShoulder.setSelected( false);
                }
                else {
                    chkLongShoulder.setVisible( false);
                    chkLongShoulder.setSelected( true);
                }
            break;
            case 43:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>3.3 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 1. Короткие плечи</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 45:
                m_nTimerToShow = TIMER_DOWNTICK;
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM)
                    lblTitle.setText( "<html><u>3.5 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 2. Длинное плечо</u></thml>");
                else
                    lblTitle.setText( "<html><u>3.5 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 2.</u></thml>");
                
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) {
                    chkLongShoulder.setVisible( true);
                    chkLongShoulder.setSelected( false);
                }
                else {
                    chkLongShoulder.setVisible( false);
                    chkLongShoulder.setSelected( true);
                }
            break;
            case 47:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>3.7 Обработка O<sub>2</sub> - Ne<sub>20</sub>. Цикл 2. Короткие плечи</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
                
            case 62:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>4.2 Термообезгаживание.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                
                btnNext.setEnabled(  false);
                if( theApp.GetSettings().GetDebugShortenThermoProcessing()) {
                    new Timer( 1000 * 5, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            (( Timer) e.getSource()).stop();
                            btnNext.setEnabled( true);
                        }
                    }).start();
                }
                else {
                    new Timer( 1000 * 60 * 60 * 24, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            (( Timer) e.getSource()).stop();
                            btnNext.setEnabled( true);
                        }
                    }).start();
                }
            break;
            case 64:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>4.4 Заполнение рабочей смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
                new Timer( 2000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        (( Timer) e.getSource()).stop();
                        btnNext.setEnabled( true);
                    }
                }).start();
            break;
                
                
            case 101:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>6.1 Заполнение тренировочной смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 103:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>6.3 Заполнение тренировочной смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 105:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>6.5 Заполнение тренировочной смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            
                
            case 141:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>8.1 Заполнение тренировочной смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 142:
                m_nTimerToShow = TIMER_UPTICK;
                lblTitle.setText( "<html><u>8.2 Тренировка в тренировочной смеси. 1-ый цикл.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 143:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>8.3 Заполнение тренировочной смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 144:
                m_nTimerToShow = TIMER_UPTICK;
                lblTitle.setText( "<html><u>8.4 Тренировка в тренировочной смеси. 2-ой цикл.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
            break;
            case 181:
                m_nTimerToShow = TIMER_DOWNTICK;
                lblTitle.setText( "<html><u>10.1 Заполнение рабочей смесью. Выдержка.</u></thml>");
                btnStart.setVisible( false);
                lblStart.setVisible( false);
                btnNext.setEnabled(  false);
                new Timer( 2000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        (( Timer) e.getSource()).stop();
                        btnNext.setEnabled( true);
                    }
                }).start();
            break;    
                
            default: lblTitle.setText( "ЭТАП НЕ ДЛЯ ТАЙМЕРА!"); break;
        }
    }
    
    
    
    public void StartTimer( long nSeconds, long lUpTickTimerInitialValue) {
        //мы начинаем процесс
        TechProcessStepCommon info = new TechProcessStepCommon();
        
        switch( theApp.GetCurrentStep()) {
            case 21: break;
            case 23: break;
                
            case 41: break;
            case 43: break;
            case 45: break;
            case 47: break;
                
            case 62:
                info.SetStartReportTitle( "Старт термообезгаживания");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 64:
                info.SetStartReportTitle( "Старт выдержки рабочей смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
                
            case 101:
                info.SetStartReportTitle( "Старт выдержки тренировочной смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 102: break;
            case 104:
                info.SetStartReportTitle( "Старт выдержки тренировочной смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 105: break;
            case 107:
                info.SetStartReportTitle( "Старт выдержки тренировочной смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 108: break;
            
            case 141:
                info.SetStartReportTitle( "Старт выдержки тренировочной смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 142: break;
            case 144:
                info.SetStartReportTitle( "Старт выдержки тренировочной смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
            case 145: break;
                
            case 181:
                info.SetStartReportTitle( "Старт выдержки рабочей смеси");
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
            break;
        }
        
        
        
        
        theApp.m_ReportGenerator.Generate();
        
        theApp.SetCurrentStepInProgress( true);
        
        //btnNext.setEnabled( bEnableNext);
        
        m_lUpTickTimer = lUpTickTimerInitialValue;
        m_pUpTickTimer.start();
        if( m_nTimerToShow == TIMER_UPTICK) {
            lblTimer.setText(String.format("%02d:%02d:%02d",
                    m_lUpTickTimer / 3600,
                    ( m_lUpTickTimer % 3600) / 60,
                    m_lUpTickTimer % 60));
            
            btnNext.setEnabled( nSeconds <= 0);
        }
        
        m_lDownTickTimer = nSeconds;
        if( m_nTimerToShow == TIMER_DOWNTICK) {
            lblTimer.setText(String.format("%02d:%02d:%02d",
                    m_lDownTickTimer / 3600,
                    (m_lDownTickTimer % 3600) / 60,
                    m_lDownTickTimer % 60));
        }
        
        
        m_pDownTickTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_lDownTickTimer--;
                
                if( m_nTimerToShow == TIMER_DOWNTICK) {
                    int nHou = ( int) ( m_lDownTickTimer / 3600);
                    int nMin = ( int) ( (m_lDownTickTimer % 3600) / 60);
                    int nSec = ( int) ( m_lDownTickTimer % 60);
                    lblTimer.setText( String.format( "%02d:%02d:%02d", nHou, nMin, nSec));
                }
                
                if( theApp.GetCurrentStep() == 62 && m_lDownTickTimer == 60 * 90) {
                    //для этапа термообезгаживания за полтора часа переходим на экран ввода геттер инфо
                    TechProcessGetterInfo info = new TechProcessGetterInfo();
                    info.SetStartReportTitle( "");
                    info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                    theApp.SetCurrentStep( 63);
                    theApp.SaveStepInfo( "063", info, true);
        
                    theApp.m_ReportGenerator.Generate();
        
                    theApp.m_pMainWnd.m_pnlEnterGetterInfo.InitOnStart( theApp.GetDtmTOEnd(), 60 * 90);
                
                    theApp.m_pMainWnd.m_pnlEnterGetterInfo.setVisible( true);
                    theApp.SetCurrentStepInProgress( true);

        
                    if( m_pDownTickTimer != null) {
                        if( m_pDownTickTimer.isRunning())
                            m_pDownTickTimer.stop();
                    }
        
                    theApp.m_pMainWnd.m_pnlStopWatch.setVisible( false);
                    return;
                }
                
                if( m_lDownTickTimer == 0) {
                    theApp.SetCurrentStepInProgress( false);
                    
                    btnNext.setEnabled( true);
                    btnNext.setBackground( m_clrRed);
                    
                    ( ( Timer) e.getSource()).stop();
                    
                    m_nFlasher = 6;
                    new Timer( 500, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            m_nFlasher--;
                            if( ( m_nFlasher % 2) == 1)
                                lblTimer.setForeground( new Color( 220, 220, 220));
                            else
                                lblTimer.setForeground( new Color( 0, 0, 0));
                            
                            if( m_nFlasher == 0) {
                                ( ( Timer) e.getSource()).stop();
                                
                                //theApp.SetCurrentStepInProgress( false);
                                
                                /*
                                TechProcessStepCommon info = theApp.GetStepInfo( String.format( "%03d", theApp.GetCurrentStep()));
                                info.SetStopDateAsCurrent();
                                switch( theApp.GetCurrentStep()) {
                                    case 21: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 23: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 41: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 43: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 62: info.SetStopReportTitle( "Окончание термообезгаживания"); break;
                                    case 101: info.SetStopReportTitle( "Окончание выдержки"); break;
                                    case 102: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 104: info.SetStopReportTitle( "Окончание выдержки"); break;
                                    case 105: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 107: info.SetStopReportTitle( "Окончание выдержки"); break;
                                    case 108: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 141: info.SetStopReportTitle( "Окончание выдержки"); break;
                                    case 142: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 144: info.SetStopReportTitle( "Окончание выдержки"); break;
                                    case 145: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 181: info.SetStopReportTitle( "Окончание выдержки"); break;
                                }
                                */
                                
                                //btnNext.setEnabled( true);
                                
                                theApp.m_ReportGenerator.Generate();
                            }
                        }
                    }).start();
                }
            }
        });
        
        m_pDownTickTimer.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        chkLongShoulder = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>2.1 Обработка O<sub>2</sub>. Первый цикл.</u></thml>");
        add(lblTitle);
        lblTitle.setBounds(10, 10, 500, 40);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 500, 50);

        btnStart.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        btnStart.setText("С Т А Р Т");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        add(btnStart);
        btnStart.setBounds(20, 170, 480, 120);

        lblTimer.setFont(new java.awt.Font("Cantarell", 0, 100)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00:00:00");
        add(lblTimer);
        lblTimer.setBounds(10, 60, 500, 280);

        lblStart.setText("<html>Заполните приборы рабочей смесью, и нажмите \"СТАРТ\" для начала отсчёта времени выдержки.</html>");
        add(lblStart);
        lblStart.setBounds(20, 70, 480, 90);

        chkLongShoulder.setText("Прибор не удалось зажечь по длинному плечу");
        chkLongShoulder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLongShoulderActionPerformed(evt);
            }
        });
        add(chkLongShoulder);
        chkLongShoulder.setBounds(10, 350, 500, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        m_pUpTickTimer.stop();
        
        TechProcessStepCommon info = theApp.GetCommonStep( String.format( "%03d", theApp.GetCurrentStep()));
        if( info.GetStopDate() == null) {
            info.SetStopDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
            switch( theApp.GetCurrentStep()) {
                case 21: info.SetStopReportTitle( "Завершение обработки"); break;
                case 23: info.SetStopReportTitle( "Завершение обработки"); break;
                    
                case 41:
                    if( chkLongShoulder.isSelected())
                        info.SetStartReportTitle( "1 цикл. Обработка по коротким плечам");
                    info.SetStopReportTitle( "Завершение обработки");
                break;
                case 42: info.SetStopReportTitle( "Завершение обработки"); break;
                case 43:
                    if( chkLongShoulder.isSelected())
                        info.SetStartReportTitle( "2 цикл. Обработка по коротким плечам");
                    info.SetStopReportTitle( "Завершение обработки");
                break;
                case 44: info.SetStopReportTitle( "Завершение обработки"); break;
                            
                case 62: info.SetStopReportTitle( "Завершение термообезгаживания"); break;
                case 64: info.SetStopReportTitle( "Завершение выдержки"); break;
                    
                case 101: info.SetStopReportTitle( "Завершение выдержки"); break;
                case 102: info.SetStopReportTitle( "Завершение обработки"); break;
                case 103: info.SetStopReportTitle( "Завершение выдержки"); break;
                case 104: info.SetStopReportTitle( "Завершение обработки"); break;
                case 105: info.SetStopReportTitle( "Завершение выдержки"); break;
                case 106: info.SetStopReportTitle( "Завершение обработки"); break;
                    
                case 141: info.SetStopReportTitle( "Завершение выдержки"); break;
                case 142: info.SetStopReportTitle( "Завершение обработки"); break;
                case 144: info.SetStopReportTitle( "Завершение выдержки"); break;
                case 145: info.SetStopReportTitle( "Завершение обработки"); break;
                    
                case 181: info.SetStopReportTitle( "Завершение выдержки"); break;
            }
        }
        
        info = new TechProcessHvProcessInfo();
        int nNextStep = 0;
        switch( theApp.GetCurrentStep()) {
            case 21: /*2.1*/
                info.SetStartReportTitle( ""); nNextStep = 22;
                break;
            case 23: /*2.3*/ info.SetStartReportTitle( ""); nNextStep = 24; break;
                
            case 41: /*3.1*/ info.SetStartReportTitle( ""); nNextStep = 42; break;
            case 43: /*3.3*/ info.SetStartReportTitle( ""); nNextStep = 44; break;
            case 45: /*3.5*/ info.SetStartReportTitle( ""); nNextStep = 46; break;
            case 47: /*3.7*/ info.SetStartReportTitle( ""); nNextStep = 48; break;
                
            case 62: /*4.2 Термообезгаживание - переход к вводу информации о геттере*/
                info = new TechProcessGetterInfo();
                info.SetStartReportTitle( "");
                nNextStep = 63;
            break;
            case 64: /*4.4 Выдержка - переход к промежуточной оценке параметров*/
                info = new TechProcessIgenIextProcessInfo();
                info.SetStartReportTitle( "Определение пороговых токов генерации и погасания");
                nNextStep = 81;
            break;
                
                
            case 101: /*6.1*/
            case 103: /*6.3*/
            case 105: /*6.5*/
                info.SetStartReportTitle( null);
                nNextStep = theApp.GetCurrentStep() + 1;
            break;
                
            case 141: /*8.1*/
                info = new TechProcessStepCommon();
                info.SetStartReportTitle( null);
                nNextStep = 142;
            break;
            case 142: /*8.2*/ info.SetStartReportTitle( ""); nNextStep = 143; break;
            case 143: /*8.3*/
                info = new TechProcessStepCommon();
                info.SetStartReportTitle( null);
                nNextStep = 144; break;
            case 144: /*8.4*/ info.SetStartReportTitle( ""); nNextStep = 161; break;
                
            case 181: /*10.1 Выдержка - переход к финишному замеру параметров*/
                info = new TechProcessIgenIextProcessInfo();
                info.SetStartReportTitle( "Определение пороговых токов генерации и погасания");
                nNextStep = 182;
            break;
            
            /*    info = new TechProcessUacProcessInfo( theApp);
                info.SetStartReportTitle( "Снятие вольт-амперной характеристики");
                nNextStep = 182;
            break;*/
        }
        info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());

        theApp.SetCurrentStep( nNextStep);
        theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
        theApp.m_ReportGenerator.Generate();
        
        
        
        switch( nNextStep) {
            case 63: //4.3 (то есть сейчас мы закончили 4.2 и готовы перейти к 4.3)
                if( theApp.GetDtmTOEnd() == null)
                    theApp.m_pMainWnd.m_pnlEnterGetterInfo.InitOnStart( theApp.GetCommonStep( "062").GetStopDate(), m_lDownTickTimer + 1);
                else
                    theApp.m_pMainWnd.m_pnlEnterGetterInfo.InitOnStart( theApp.GetDtmTOEnd(), m_lDownTickTimer + 1);
                
                theApp.m_pMainWnd.m_pnlEnterGetterInfo.setVisible( true);
                theApp.SetCurrentStepInProgress( true);
            break;
                
            case 81: //5.1 (то есть сейчас мы закончили 4.4, и готовы перейти к 5.1)
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep04.m_bCollapsed = true;
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
                
                theApp.m_pMainWnd.m_pnlEnterIgenIext.InitComponentsOnStart();
                theApp.m_pMainWnd.m_pnlEnterIgenIext.setVisible( true);
                theApp.SetCurrentStepInProgress( true);
            break;
                
            case 102: //6.2 (то есть сейчас мы закончили 6.1, и готовы перейти к 6.2)
            case 104: //6.4 (то есть сейчас мы закончили 6.3, и готовы перейти к 6.4)
            case 106: //6.6 (то есть сейчас мы закончили 6.5, и готовы перейти к 6.6)
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
                theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
                theApp.m_pMainWnd.m_pnlMain.setVisible( true);
                theApp.SetCurrentStepInProgress( false);
            break;
                
            case 142: //8.2 (то есть сейчас мы закончили 8.1, и готовы перейти к 8.2)
            case 144: //8.4 (то есть сейчас мы закончили 8.3, и готовы перейти к 8.4)
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
                theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
                theApp.m_pMainWnd.m_pnlMain.setVisible( true);
                theApp.SetCurrentStepInProgress( false);
            break;
            
            case 143: //8.3 (то есть сейчас мы закончили 8.2, и готовы перейти к 8.3)
            case 161: //9.1 (то есть сейчас мы закончили 8.4, и готовы перейти к 9.1)
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_6());
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                theApp.SetCurrentStepInProgress( true);
            break;
            
            case 182: //10.2 (то есть сейчас мы закончили 10.1, и готовы перейти к 10.2)
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
                
                theApp.m_pMainWnd.m_pnlEnterIgenIext.InitComponentsOnStart();
                theApp.m_pMainWnd.m_pnlEnterIgenIext.setVisible( true);
                theApp.SetCurrentStepInProgress( true);
                
                //theApp.m_pMainWnd.m_pnlEnterCVC.InitComponentsOnStart();
                //theApp.m_pMainWnd.m_pnlEnterCVC.setVisible( true);
                //theApp.SetCurrentStepInProgress( true);
            break;
                    
            default:
                //нам надо ввести зафиксированные напряжения для прошедшего этапа обработки
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                //theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                theApp.SetCurrentStepInProgress( true);
        }
        
        if( m_pDownTickTimer != null) {
            if( m_pDownTickTimer.isRunning())
                m_pDownTickTimer.stop();
        }
        
        theApp.m_pMainWnd.m_pnlStopWatch.setVisible( false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        lblStart.setVisible( false);
        btnStart.setVisible( false);
        switch( theApp.GetCurrentStep()) {
            case 21: StartTimer( theApp.GetSettings().GetProcessingTime_2(), 0); break;
            case 23: StartTimer( theApp.GetSettings().GetProcessingTime_2(), 0); break;
            case 41: StartTimer( theApp.GetSettings().GetProcessingTime_3(), 0); break;
            case 43: StartTimer( theApp.GetSettings().GetProcessingTime_3(), 0); break;
            case 62: StartTimer( 10, 0); break;
            case 64: StartTimer( theApp.GetSettings().GetExcerptTime(), 0); break;
        }    
    }//GEN-LAST:event_btnStartActionPerformed

    private void chkLongShoulderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLongShoulderActionPerformed
        if( chkLongShoulder.isSelected())
            m_lDownTickTimer += theApp.GetSettings().GetProcessingTime_3();
        else
            m_lDownTickTimer -= theApp.GetSettings().GetProcessingTime_3();
    }//GEN-LAST:event_chkLongShoulderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnStart;
    public javax.swing.JCheckBox chkLongShoulder;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
