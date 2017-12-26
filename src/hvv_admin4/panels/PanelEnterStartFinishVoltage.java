/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelEnterStartFinishVoltage extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger( PanelEnterStartFinishVoltage.class);
    
    private Timer m_pTimer;
    int m_nSecondsPassed;
    int m_nSecondsPlanned;
    
    /**
     * Creates new form PanelProcess
     */
    public PanelEnterStartFinishVoltage( HVV_Admin4 app) {
        theApp = app;    
        initComponents();
    }

    public void StartTimer( int nSecondsPlanned) {
        m_nSecondsPlanned = nSecondsPlanned;
        m_nSecondsPassed = 0;
        m_pTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_nSecondsPassed++;
                String strMsg;
                
                if( theApp.GetCurrentStep() / 20 == 7) {
                    strMsg = String.format( "%02d:%02d:%02d", m_nSecondsPassed / 3600, ( m_nSecondsPassed % 3600) / 60, m_nSecondsPassed % 60);
                    
                    int nEnableNextSeconds = 9 * 3600;
                    if( theApp.GetSettings().GetDebugShortenProgTimes())
                        nEnableNextSeconds = 10;
                        
                    if( m_nSecondsPassed >= nEnableNextSeconds) {
                        btnNext.setEnabled( true);
                    }
                }
                else {
                    if( m_nSecondsPlanned != 0) {
                        if( m_nSecondsPassed > m_nSecondsPlanned) {
                            m_nSecondsPassed = m_nSecondsPlanned;
                            btnNext.setEnabled( true);
                        }

                        strMsg = String.format( "%02d:%02d",
                                ( m_nSecondsPlanned - m_nSecondsPassed) / 60,
                                ( m_nSecondsPlanned - m_nSecondsPassed) % 60);
                    }
                    else {
                        strMsg = String.format( "%02d:%02d", m_nSecondsPassed / 60, m_nSecondsPassed % 60);
                    }
                }
                
                lblTimer.setText( strMsg);
            }
        });
        m_pTimer.start();
    }
    
    public void DropValues() {
        edtAnodeStart.setText( "000");
        edtAnodeStop.setText(  "000");
        edtTubuStart.setText(  "000");
        edtTubuStop.setText(   "000");
    }
    
    public void Init() {
        switch( theApp.GetCurrentStep()) {
            case 21:
                lblTitle.setText( "<html><u>2.1 Обработка O<sub>2</sub>. 1-ый цикл. Ввод напряжений.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            case 22:
                lblTitle.setText( "<html><u>2.2 Обработка O<sub>2</sub>. 2-ой цикл. Ввод напряжений.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
                
            case 41:
                lblTitle.setText( "<html><u>3. Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 1.</u></thml>");
                chkLongDischargeTrackFail.setSelected( false);
                chkLongDischargeTrackFail.setVisible( true);
            break;
            case 42:
                lblTitle.setText( "<html><u>3. Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 1. Кор. плечи.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            case 43:
                lblTitle.setText( "<html><u>3. Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 2.</u></thml>");
                chkLongDischargeTrackFail.setSelected( false);
                chkLongDischargeTrackFail.setVisible( true);
            break;
                
            case 44:
                lblTitle.setText( "<html><u>3. Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 2. Кор. плечи.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            
            case 102:   //6.2   Тренировка катода. 1ый цикл
                lblTitle.setText( "<html><u>6.2 Тренировка катода. 1-ый цикл. Ввод напряжений.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            case 104:   //6.4   Тренировка катода. 2ой цикл
                lblTitle.setText( "<html><u>6.4 Тренировка катода. 2-ой цикл. Ввод напряжений.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            case 106:   //6.6   Тренировка катода. 2ой цикл
                lblTitle.setText( "<html><u>6.6 Тренировка катода. 3-ий цикл. Ввод напряжений.</u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            case 142:
                lblTitle.setText( "<html><u>8.2 Тренировка в тр. смеси. 1-ый цикл. </u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            case 144:
                lblTitle.setText( "<html><u>8.4 Тренировка в тр. смеси. 2-ой цикл. </u></thml>");
                chkLongDischargeTrackFail.setVisible( false);
            break;
            
            
            default: lblTitle.setText( "ЭТАП " + theApp.GetCurrentStep() + "НЕ ДЛЯ ВВОДА НАПРЯЖЕНИЙ!"); chkLongDischargeTrackFail.setVisible( false); break;
        }
        lblTimer.setText( "");
        
        btnNext.setEnabled( false);
        /*
        new  Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (( Timer) e.getSource()).stop();
                btnNext.setEnabled( true);
            }
        }).start();
        */
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edtAnodeStart = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        edtAnodeStop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtTubuStart = new javax.swing.JTextField();
        edtTubuStop = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chkLongDischargeTrackFail = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        edtAnodeStart.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtAnodeStart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtAnodeStart.setText("000");
        edtAnodeStart.setNextFocusableComponent(edtTubuStart);
        edtAnodeStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtAnodeStart);
        edtAnodeStart.setBounds(210, 120, 210, 110);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>2.2 Обработка O<sub>2</sub>. Первый цикл. Ввод напряжений.</u></thml>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        edtAnodeStop.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtAnodeStop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtAnodeStop.setText("000");
        edtAnodeStop.setNextFocusableComponent(edtTubuStop);
        edtAnodeStop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtAnodeStop);
        edtAnodeStop.setBounds(420, 120, 210, 110);

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Конец");
        add(jLabel2);
        jLabel2.setBounds(440, 60, 160, 50);

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html>U<sub>на аноде</sub>  (В)</html>");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel3);
        jLabel3.setBounds(10, 120, 190, 110);

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>U<sub>на штенгеле</sub> (В)</html>");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel4);
        jLabel4.setBounds(10, 240, 190, 110);

        edtTubuStart.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtTubuStart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTubuStart.setText("000");
        edtTubuStart.setNextFocusableComponent(edtAnodeStop);
        edtTubuStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtTubuStart);
        edtTubuStart.setBounds(210, 240, 210, 110);

        edtTubuStop.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtTubuStop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTubuStop.setText("000");
        edtTubuStop.setNextFocusableComponent(edtAnodeStart);
        edtTubuStop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtTubuStop);
        edtTubuStop.setBounds(420, 240, 210, 110);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 620, 50);

        lblTimer.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00:00:00");
        add(lblTimer);
        lblTimer.setBounds(0, 50, 230, 60);

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Начало");
        add(jLabel6);
        jLabel6.setBounds(230, 60, 170, 50);

        chkLongDischargeTrackFail.setText("Прибор не удалось зажечь по длинному плечу");
        chkLongDischargeTrackFail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLongDischargeTrackFailActionPerformed(evt);
            }
        });
        add(chkLongDischargeTrackFail);
        chkLongDischargeTrackFail.setBounds(10, 350, 620, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        
        TechProcessHvProcessInfo info = ( TechProcessHvProcessInfo) theApp.GetCommonStepInfo( String.format( "%03d", theApp.GetCurrentStep()));
        info.SetStopDateAsCurrent();
        
        //начальное напряжение на аноде
        Double dblValue = 0.;
        try {
            String strVal = edtAnodeStart.getText();
            strVal = strVal.replace( ',', '.');
            if( strVal.isEmpty()) strVal = "0";
            dblValue = new Double( strVal);
            if( dblValue < 0 && dblValue > 600) {
                return;
            }
            
        } catch( NumberFormatException ex) {
            logger.warn( "NumberFormatException caught при преобразовании в текст '" + edtAnodeStart.getText() + "'!", ex);
            logger.warn( "На этапе обработки начального напряжения на аноде");
            return;
        }
        info.SetAnStart( dblValue);
        
        //конечное напряжение на аноде
        dblValue = 0.;
        try {
            String strVal = edtAnodeStop.getText();
            strVal = strVal.replace( ',', '.');
            if( strVal.isEmpty()) strVal = "0";
            dblValue = new Double( strVal);
            if( dblValue < 0 && dblValue > 600) {
                return;
            }
        } catch( NumberFormatException ex) {
            logger.warn( "NumberFormatException caught при преобразовании в текст '" + edtAnodeStop.getText() + "'!", ex);
            logger.warn( "На этапе обработки конечного напряжения на аноде");
            return;
        }
        info.SetAnStop( dblValue);
        
        
        //начальное напряжение на штенгеле
        dblValue = 0.;
        try {
            String strVal = edtTubuStart.getText();
            strVal = strVal.replace( ',', '.');
            if( strVal.isEmpty()) strVal = "0";
            dblValue = new Double( strVal);
            if( dblValue < 0 && dblValue > 600) {
                return;
            }
        } catch( NumberFormatException ex) {
            logger.warn( "NumberFormatException caught при преобразовании в текст '" + edtTubuStart.getText() + "'!", ex);
            logger.warn( "На этапе обработки начального напряжения на штенгеле");
            return;
        }
        info.SetTuStart( dblValue);
        
        //конечное напряжение на штенгеле
        dblValue = 0.;
        try {
            String strVal = edtTubuStop.getText();
            strVal = strVal.replace( ',', '.');
            if( strVal.isEmpty()) strVal = "0";
            dblValue = new Double( strVal);
            if( dblValue < 0 && dblValue > 600) {
                return;
            }
        } catch( NumberFormatException ex) {
            logger.warn( "NumberFormatException caught при преобразовании в текст '" + edtTubuStop.getText() + "'!", ex);
            logger.warn( "На этапе обработки конечного напряжения на штенгеле");
            return;
        }
        info.SetTuStop( dblValue);
        
        boolean bMainPanel = false;
        int nNextStep = 0;

        switch( theApp.GetCurrentStep()) {
            case 21:    //Обработка кислородом. Первый цикл.
                info.SetStopReportTitle( "Завершение первого цикла обработки.");
                nNextStep = 22; bMainPanel = true;
            break;
                
            case 22:    //Обработка кислородом. Второй цикл.
                info.SetStopReportTitle( "Завершение второго цикла обработки.");
                nNextStep = 41; bMainPanel = true;
            break;
                
                
            case 41:
                //Обработка кислород-неоном. Первый цикл.
                if( chkLongDischargeTrackFail.isSelected()) {
                    //нам не удалось зажечь по длинному плечу - мы делали длинную обработку по коротким
                    theApp.ProcessingStepsRemoveStep( "041");
                    info.SetStartReportTitle( "1ый цикл. Обработка по коротким плечам.");
                    info.SetStopReportTitle( "1ый цикл. Обработка по коротким плечам. Завершение.");
                    
                    theApp.SetCurrentStep( 42);
                    nNextStep = 43;
                    bMainPanel = true;
                }
                else {
                    //нам удалось зажечь по длинному плечу - мы делали половинную обработку по длиному плечу
                    info.SetStopReportTitle( "1ый цикл. Обработка по длинному плечу. Завершение.");
                    nNextStep = 42; bMainPanel = false;
                }
            break;
            
            case 42:
                //обработка кислород-неоном. Первый цикл. Вторая половина (по коротким плечам)
                info.SetStopReportTitle( "1ый цикл. Обработка по коротким плечам. Завершение.");
                nNextStep = 43; bMainPanel = true;
            break;
                
            case 43:
                //Обработка кислород-неоном. Второй цикл.
                if( chkLongDischargeTrackFail.isSelected()) {
                    //нам не удалось зажечь по длинному плечу - мы делали длинную обработку по коротким
                    theApp.ProcessingStepsRemoveStep( "043");
                    info.SetStartReportTitle( "1ый цикл. Обработка по коротким плечам.");
                    info.SetStopReportTitle( "1ый цикл. Обработка по коротким плечам. Завершение.");
                    
                    theApp.SetCurrentStep( 44);
                    nNextStep = 61;
                    bMainPanel = true;
                }
                else {
                    //нам удалось зажечь по длинному плечу - мы делали половинную обработку по длиному плечу
                    info.SetStopReportTitle( "2ой цикл. Обработка по длинному плечу. Завершение.");
                    nNextStep = 44; bMainPanel = false;
                }
            break;
            
            case 44:
                //обработка кислород-неоном. Второй цикл. Вторая половина (по коротким плечам)
                info.SetStopReportTitle( "2ой цикл. Обработка по коротким плечам. Завершение.");
                nNextStep = 61; bMainPanel = true;
            break;
            
                
                
            case 102:    //Тренировка катода. Первый цикл.
                info.SetStopReportTitle( "Завершение первого цикла тренировки.");
                nNextStep = 103; bMainPanel = true;
            break;
                
            case 104:    //Тренировка катода. Второй цикл.
                info.SetStopReportTitle( "Завершение второго цикла тренировки.");
                nNextStep = 105; bMainPanel = true;
            break;
                
            case 106:    //Тренировка катода. Третий цикл.
                info.SetStopReportTitle( "Завершение третьего цикла тренировки.");
                nNextStep = 121; bMainPanel = true;
            break;
                
                
                
            case 142:    //8.2 Тренировка в тренировочной смеси. Первый цикл.
                info.SetStopReportTitle( "Завершение первого цикла тренировки.");
                nNextStep = 143; bMainPanel = true;
            break;
                
            case 144:    //8.4 Тренировка в тренировочной смеси. Второй цикл.
                info.SetStopReportTitle( "Завершение второго цикла тренировки.");
                nNextStep = 161; bMainPanel = true;
            break;
        }
        
        theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
        if( m_pTimer != null && m_pTimer.isRunning()) {
            m_pTimer.stop();
        }
        
        theApp.SetCurrentStep( nNextStep);
        theApp.SetCurrentStepInProgress( false);
            
        if( bMainPanel) {
        
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
            theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
        
            theApp.m_pMainWnd.m_pnlMain.setVisible( true);
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( false);
        }
        else {
            DropValues();
    
            if( nNextStep == 42) {
                //мы обработали кислород-неоном первый цикл по длинному плечу (этап 3.1 = 041)
                //надо отметить начало обработки кислород-неоном первого цикла по короткому и фактически остаться на этой же панели, перекрасившись
                TechProcessHvProcessInfo inf = ( TechProcessHvProcessInfo) theApp.GetCommonStepInfo( "041");
                inf.SetStartReportTitle( "1ый цикл. Обработка по длинному плечу.");
                theApp.SaveStepInfo( "041", inf, false);
                
                TechProcessHvProcessInfo infhv = new TechProcessHvProcessInfo( theApp);
                infhv.SetStartDateAsCurrent();
                infhv.SetStartReportTitle( "1ый цикл. Обработка по коротким плечам.");
                theApp.SaveStepInfo( "042", infhv, false);
            }
            
            if( nNextStep == 44) {
                //мы обработали кислород-неоном второй цикл по длинному плечу (этап 3.3 = 043)
                //надо отметить начало обработки кислород-неоном второго цикла по короткому и фактически остаться на этой же панели, перекрасившись
                TechProcessHvProcessInfo inf = ( TechProcessHvProcessInfo) theApp.GetCommonStepInfo( "043");
                inf.SetStartReportTitle( "2ой цикл. Обработка по длинному плечу.");
                theApp.SaveStepInfo( "043", inf, false);
                
                TechProcessHvProcessInfo infhv = new TechProcessHvProcessInfo( theApp);
                infhv.SetStartDateAsCurrent();
                infhv.SetStartReportTitle( "2ой цикл. Обработка по коротким плечам.");
                theApp.SaveStepInfo( "044", infhv, false);
            }
            
            StartTimer( theApp.GetSettings().GetProcessingTime_3());
            
            Init();
        }
        
        theApp.m_ReportGenerator.Generate();
    }//GEN-LAST:event_btnNextActionPerformed

    private void edtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtFocusGained
        JTextField edt = ( JTextField) evt.getSource();
        edt.setSelectionStart( 0);
        edt.setSelectionEnd(edt.getText().length());
    }//GEN-LAST:event_edtFocusGained

    private void chkLongDischargeTrackFailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLongDischargeTrackFailActionPerformed
        if( chkLongDischargeTrackFail.isSelected())
            m_nSecondsPlanned += theApp.GetSettings().GetProcessingTime_3();
        else
            m_nSecondsPlanned -= theApp.GetSettings().GetProcessingTime_3();
    }//GEN-LAST:event_chkLongDischargeTrackFailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JCheckBox chkLongDischargeTrackFail;
    public javax.swing.JTextField edtAnodeStart;
    public javax.swing.JTextField edtAnodeStop;
    public javax.swing.JTextField edtTubuStart;
    public javax.swing.JTextField edtTubuStop;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
