/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessHvProcessInfo;
import hvv_admin4.steps.info.TechProcessStepCommon;
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
    int m_nSecondsSpentHere;
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
        m_nSecondsSpentHere = 0;
        m_pTimer = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_nSecondsSpentHere++;
                String strMsg;
                if( m_nSecondsPlanned != 0) {
                    if( m_nSecondsSpentHere > m_nSecondsPlanned)
                        m_nSecondsSpentHere = m_nSecondsPlanned;
                    
                    strMsg = String.format( "%02d:%02d",
                            ( m_nSecondsPlanned - m_nSecondsSpentHere) / 60,
                            ( m_nSecondsPlanned - m_nSecondsSpentHere) % 60);
                }
                else {
                    strMsg = String.format( "%02d:%02d", m_nSecondsSpentHere / 60, m_nSecondsSpentHere % 60);
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
            case 22:
                lblTitle.setText( "<html><u>2.2 Обработка O<sub>2</sub>. 1-ый цикл. Ввод напряжений.</u></thml>"); break;
            
            case 23:
            case 24:
                lblTitle.setText( "<html><u>2.4 Обработка O<sub>2</sub>. 2-ой цикл. Ввод напряжений.</u></thml>"); break;
            
            case 41:
            case 42:
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) {
                    lblTitle.setText( "<html><u>3.2 Обработка O<sub>2</sub>-Ne<sub>20</sub>. 1.Дл. пл. Ввод напряжений.</u></thml>");
                }
                else {
                    lblTitle.setText( "<html><u>3.2 Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 1.Ввод напряжений.</u></thml>");
                }
            break;
            
            case 43:
            case 44:
                lblTitle.setText( "<html><u>3.4 Обработка O<sub>2</sub>-Ne<sub>20</sub>. 1.Кор. пл. Ввод напряжений.</u></thml>"); break;
            
            case 45:
            case 46:
                if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM) {
                    lblTitle.setText( "<html><u>3.2 Обработка O<sub>2</sub>-Ne<sub>20</sub>. 2.Дл. пл. Ввод напряжений.</u></thml>");
                }
                else {
                    lblTitle.setText( "<html><u>3.2 Обработка O<sub>2</sub>-Ne<sub>20</sub>. Цикл 2.Ввод напряжений.</u></thml>");
                }
            break;
            
            case 47:
            case 48:
                lblTitle.setText( "<html><u>3.8 Обработка O<sub>2</sub>-Ne<sub>20</sub>. 2.Кор. пл. Ввод напряжений.</u></thml>"); break;
                
            
            case 102:
            case 103:
                lblTitle.setText( "<html><u>6.3 Тренировка катода. 1-ый цикл. Ввод напряжений.</u></thml>"); break;
            
            case 105:
            case 106:
                lblTitle.setText( "<html><u>6.6 Тренировка катода. 2-ой цикл. Ввод напряжений.</u></thml>"); break;
            
            case 108:
            case 109:
                lblTitle.setText( "<html><u>6.9 Тренировка катода. 3-ий цикл. Ввод напряжений.</u></thml>"); break;
            
            case 142: lblTitle.setText( "<html><u>8.2 Тренировка в тр. смеси. 1-ый цикл. Ввод напряжений.</u></thml>"); break;
            case 143: lblTitle.setText( "<html><u>8.2 Тренировка в тр. смеси. 1-ый цикл. Ввод напряжений.</u></thml>"); break;
            case 145: lblTitle.setText( "<html><u>8.5 Тренировка в тр. смеси. 2-ой цикл. Ввод напряжений.</u></thml>"); break;
            case 146: lblTitle.setText( "<html><u>8.5 Тренировка в тр. смеси. 2-ой цикл. Ввод напряжений.</u></thml>"); break;
            
            default: lblTitle.setText( "ЭТАП " + theApp.GetCurrentStep() + "НЕ ДЛЯ ВВОДА НАПРЯЖЕНИЙ!"); break;
        }
        lblTimer.setText( "");
        
        btnNext.setEnabled( false);
        new  Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (( Timer) e.getSource()).stop();
                btnNext.setEnabled( true);
            }
        }).start();
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

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        edtAnodeStart.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtAnodeStart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtAnodeStart.setText("000");
        edtAnodeStart.setNextFocusableComponent(edtAnodeStop);
        edtAnodeStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtAnodeStart);
        edtAnodeStart.setBounds(210, 120, 210, 120);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>2.2 Обработка O<sub>2</sub>. Первый цикл. Ввод напряжений.</u></thml>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        edtAnodeStop.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtAnodeStop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtAnodeStop.setText("000");
        edtAnodeStop.setNextFocusableComponent(edtTubuStart);
        edtAnodeStop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtAnodeStop);
        edtAnodeStop.setBounds(420, 120, 210, 120);

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Конец");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel2);
        jLabel2.setBounds(420, 60, 210, 50);

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html>U<sub>на аноде</sub>  (В)</html>");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel3);
        jLabel3.setBounds(10, 120, 190, 120);

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>U<sub>на штенгеле</sub> (В)</html>");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel4);
        jLabel4.setBounds(10, 250, 190, 120);

        edtTubuStart.setFont(new java.awt.Font("Cantarell", 0, 80)); // NOI18N
        edtTubuStart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTubuStart.setText("000");
        edtTubuStart.setNextFocusableComponent(edtTubuStop);
        edtTubuStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtFocusGained(evt);
            }
        });
        add(edtTubuStart);
        edtTubuStart.setBounds(210, 250, 210, 120);

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
        edtTubuStop.setBounds(420, 250, 210, 120);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 620, 50);

        lblTimer.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTimer);
        lblTimer.setBounds(10, 60, 190, 50);

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Начало");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(jLabel6);
        jLabel6.setBounds(210, 60, 210, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        TechProcessHvProcessInfo info;
        if( theApp.GetCurrentStep() == 21 || theApp.GetCurrentStep() == 23 ||
            theApp.GetCurrentStep() == 41 || theApp.GetCurrentStep() == 43 ||                
            theApp.GetCurrentStep() == 45 || theApp.GetCurrentStep() == 47 ||
            theApp.GetCurrentStep() == 102 || theApp.GetCurrentStep() == 105 || theApp.GetCurrentStep() == 108 ||
            theApp.GetCurrentStep() == 142 || theApp.GetCurrentStep() == 145) {
            
            info = new TechProcessHvProcessInfo( theApp);
        }
        else {
            info = ( TechProcessHvProcessInfo) theApp.GetStepInfo( String.format( "%03d", theApp.GetCurrentStep()));
        }
        
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
        
        theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
        
        if( theApp.GetCurrentStep() == 21 || theApp.GetCurrentStep() == 23 ||
            theApp.GetCurrentStep() == 41 || theApp.GetCurrentStep() == 43 ||
            theApp.GetCurrentStep() == 45 || theApp.GetCurrentStep() == 47 ||
            theApp.GetCurrentStep() == 102 || theApp.GetCurrentStep() == 105 || theApp.GetCurrentStep() == 108) {
            
            theApp.m_pMainWnd.m_pnlStopWatch.Init();
            if( theApp.GetCurrentStep() == 21 || theApp.GetCurrentStep() == 23)
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_2() - m_nSecondsSpentHere + 1, m_nSecondsSpentHere);
            
            if( theApp.GetCurrentStep() == 41 || theApp.GetCurrentStep() == 43 ||
                theApp.GetCurrentStep() == 45 || theApp.GetCurrentStep() == 47) 
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_3() - m_nSecondsSpentHere + 1, m_nSecondsSpentHere);
            
            if( theApp.GetCurrentStep() == 102 || theApp.GetCurrentStep() == 105 || theApp.GetCurrentStep() == 108) {
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_6() - m_nSecondsSpentHere + 1, m_nSecondsSpentHere);
            }
            theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( false);
            
            theApp.m_ReportGenerator.Generate();
            
            return;
        }
        
        if( theApp.GetCurrentStep() == 142 || theApp.GetCurrentStep() == 145) {
            
            if( m_pTimer != null && m_pTimer.isRunning()) {
                m_pTimer.stop();
            }
            
            theApp.m_pMainWnd.m_pnlStopWatch.Init();
            theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_8() - m_nSecondsSpentHere + 1, m_nSecondsSpentHere);
            theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( false);
            
            theApp.m_ReportGenerator.Generate();
            
            return;
        }
        
        info.SetStopDateAsCurrent();
        int nNextStep = 0;
        switch( theApp.GetCurrentStep()) {
            //2.X обработка кислородом
            case 22: info.SetStopReportTitle( ""); nNextStep = 23; break;
            
            case 24:
                info.SetStopReportTitle( ""); nNextStep = 41;
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep02.m_bCollapsed = true;
            break;
            
                
            //3.X обработка кислород-неоном
            case 42:
                info.SetStopReportTitle( "");
                if( theApp.m_pMainWnd.m_pnlStopWatch.chkLongShoulder.isSelected())
                    nNextStep = 45;
                else
                    nNextStep = 43;
            break;
            case 44: info.SetStopReportTitle( ""); nNextStep = 45; break;
            case 46:
                info.SetStopReportTitle( "");
                info.SetStopReportTitle( "");
                if( theApp.m_pMainWnd.m_pnlStopWatch.chkLongShoulder.isSelected()) {
                    nNextStep = 61;
                    theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.m_bCollapsed = true;
                }
                else
                    nNextStep = 47;
            break;
            case 48:
                info.SetStopReportTitle( ""); nNextStep = 61;
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep03.m_bCollapsed = true;
            break;
                
                
            //6.X тренировка катода
            case 103: info.SetStopReportTitle( ""); nNextStep = 104; break;
            case 106: info.SetStopReportTitle( ""); nNextStep = 107; break;
                
            case 109:
                info.SetStopReportTitle( ""); nNextStep = 121;
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep06.m_bCollapsed = true;
            break;
            
            //8.X тренировка в тр. смеси
            case 143:
                info.SetStopReportTitle( "");
                nNextStep = 144;
            break;
            case 146:
                info.SetStopReportTitle( ""); nNextStep = 161;
                theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.m_pnlStep08.m_bCollapsed = true;
            break;
        }
        
        theApp.SetCurrentStep( nNextStep);
        if( nNextStep == 43 || nNextStep == 47) {
            theApp.SetCurrentStepInProgress( true);
            
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_3());
                    
            //theApp.m_pMainWnd.m_pnlStopWatch.Init();
            //theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_3(), 0);
            //theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
            //theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( false);
        }
        else {
            theApp.SetCurrentStepInProgress( false);
        
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.Reposition();
            theApp.m_pMainWnd.m_pnlMain.m_pnlProcess.SetStates();
            theApp.m_pMainWnd.m_pnlMain.ScrollActiveStepToCenter();
        
            theApp.m_pMainWnd.m_pnlMain.setVisible( true);
            theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( false);
        }
        theApp.m_ReportGenerator.Generate();
        
        if( m_pTimer != null && m_pTimer.isRunning()) {
            m_pTimer.stop();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void edtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtFocusGained
        JTextField edt = ( JTextField) evt.getSource();
        edt.setSelectionStart( 0);
        edt.setSelectionEnd(edt.getText().length());
    }//GEN-LAST:event_edtFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
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
