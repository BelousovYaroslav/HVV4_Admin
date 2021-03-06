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
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelPuffMessage extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelPuffMessage.class);
    public long m_lTimer;
    public int m_nFlasher;
    Timer m_pTimer;
    /**
     * Creates new form PanelProcess
     */
    public PanelPuffMessage( HVV_Admin4 app) {
        theApp = app;
        initComponents();
    }

    public void Init() {
        int n = theApp.GetCurrentStep() / 20;
        
        lblTitle.setText( theApp.GetSettings().GetPuffMessage( 1 + theApp.GetCurrentStep() / 20, 0, theApp.GetProcessedDeviceType()));

        String strGas1 =  theApp.GetSettings().GetPuffMessage( 1 + theApp.GetCurrentStep() / 20, 1, theApp.GetProcessedDeviceType());
        String strGas2 =  theApp.GetSettings().GetPuffMessage( 1 + theApp.GetCurrentStep() / 20, 2, theApp.GetProcessedDeviceType());
        String strHv   =  theApp.GetSettings().GetPuffMessage( 1 + theApp.GetCurrentStep() / 20, 3, theApp.GetProcessedDeviceType());

        switch( theApp.GetCurrentStep()) {
            //ЭТАП 2. Обработка O2
            case 21:
            case 22:
                if( theApp.IsCurrentStepInProgress()) {
                    lblMessageL.setText( "");
                    lblMessageR.setText( "");
                    lblMessageF.setText( strHv);
                    btnNext.setText( "Высокое подано. Начать отсчёт времени обработки.");
                }
                else {
                    lblMessageL.setText( strGas1);
                    lblMessageR.setText( "");
                    lblMessageF.setText( "");
                    btnNext.setText( "Прибор заполнен");                    
                }
            break;

            //ЭТАП 3. Обработка O2-Ne20
            case 41:
            case 43:
                if( theApp.IsCurrentStepInProgress()) {
                    lblMessageL.setText( "");
                    lblMessageR.setText( "");
                    lblMessageF.setText( strHv);
                    btnNext.setText( "Высокое подано. Начать отсчёт времени обработки.");
                }
                else {
                    lblMessageL.setText( strGas1);
                    lblMessageR.setText( strGas2);
                    lblMessageF.setText( "");
                    btnNext.setText( "Прибор заполнен");                    
                }
            break;

            //ЭТАП 4. Термообезгаживание. Здесь последний этап - выдержка рабочей смеси перед промежуточным контролем.
            case 64:
                lblMessageL.setText( strGas1);
                lblMessageR.setText( strGas2);
                lblMessageF.setText( "");
                btnNext.setText( "Прибор заполнен. Начать отсчёт времени выдержки.");
            break;

            //ЭТАП 6. Тренировка катода
            case 101:
            case 103:
            case 105:
                lblMessageL.setText( strGas1);
                lblMessageR.setText( strGas2);
                lblMessageF.setText( "");
                btnNext.setText( "Прибор заполнен. Начать отсчёт времени выдержки.");
            break;
            
            case 102:
            case 104:
            case 106:
                lblMessageL.setText( "");
                lblMessageR.setText( "");
                lblMessageF.setText( strHv);
                btnNext.setText( "Высокое подано. Начать отсчёт времени тренировки.");
            break;

            //ЭТАП 8. Тр. в тр. смеси
            case 141:
            case 143:
                lblMessageL.setText( strGas1);
                lblMessageR.setText( strGas2);
                lblMessageF.setText( "");
                btnNext.setText( "Прибор заполнен. Начать отсчёт времени выдержки.");
            break;
                
            case 142:
            case 144:
                lblMessageL.setText( "");
                lblMessageR.setText( "");
                lblMessageF.setText( strHv);
                btnNext.setText( "Высокое подано. Начать отсчёт времени тренировки.");
            break;
            
            //ЭТАП 10. Выходная оценка параметров
            case 181:
                lblMessageL.setText( strGas1);
                lblMessageR.setText( strGas2);
                lblMessageF.setText( "");
                btnNext.setText( "Прибор заполнен. Начать отсчёт времени выдержки.");
            break;
        }
        
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

        lblTitle = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblMessageR = new javax.swing.JLabel();
        lblMessageF = new javax.swing.JLabel();
        lblMessageL = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(520, 440));
        setMinimumSize(new java.awt.Dimension(520, 440));
        setPreferredSize(new java.awt.Dimension(520, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>Заполнение кислород-неонной смесью.</u></html>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 500, 40);

        btnNext.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        btnNext.setText("Далее");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 370, 500, 50);

        lblMessageR.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblMessageR.setText("<html>Неон Ne<sub>20</sub><br>200.0 Па</html>");
        lblMessageR.setToolTipText("");
        add(lblMessageR);
        lblMessageR.setBounds(270, 70, 240, 290);

        lblMessageF.setFont(new java.awt.Font("Cantarell", 0, 48)); // NOI18N
        lblMessageF.setText("<html>Ток обработки 2.5мА</html>");
        add(lblMessageF);
        lblMessageF.setBounds(10, 60, 500, 300);

        lblMessageL.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblMessageL.setText("<html>Кислород O<sub>2</sub><br>66.6 Па</html>");
        add(lblMessageL);
        lblMessageL.setBounds(20, 70, 240, 290);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        switch( theApp.GetCurrentStep()) {
            case 21:    //2.1 Обработка O2. первый цикл
            case 22:    //2.2 Обработка O2. второй цикл
                if( theApp.IsCurrentStepInProgress()) {
                    
                    TechProcessHvProcessInfo info = new TechProcessHvProcessInfo();
                    info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                    if( theApp.GetCurrentStep() == 21) info.SetStartReportTitle( "Старт первого цикла обработки");
                    if( theApp.GetCurrentStep() == 22) info.SetStartReportTitle( "Старт второго цикла обработки");
                    theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
                    
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_2());
                
                    //theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                    //theApp.m_pMainWnd.m_pnlStopWatch.Init();
                    //theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( ( long) theApp.GetSettings().GetProcessingTime_2(), 0);

                    theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
                } else {
                    theApp.SetCurrentStepInProgress( true);
                    Init();
                }
                
            break;
                
            case 41:    //3.1 O2-Ne20. Обработка. 1ый цикл.
            case 43:    //3.3 O2-Ne20. Обработка. 2oй цикл.
                if( theApp.IsCurrentStepInProgress()) {
                    
                    TechProcessHvProcessInfo info = new TechProcessHvProcessInfo();
                    info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                    if( theApp.GetCurrentStep() == 41) info.SetStartReportTitle( "1 цикл. Обработка по длинному плечу");
                    if( theApp.GetCurrentStep() == 43) info.SetStartReportTitle( "2 цикл. Обработка по длинному плечу");
                    theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
                    
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                    theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_3());
                
                    //theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                    //theApp.m_pMainWnd.m_pnlStopWatch.Init();                    
                    //if( theApp.GetProcessedDeviceType() == HVV_Admin4Constants.DEVICE_MEDIUM)
                    //    theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( ( long) theApp.GetSettings().GetProcessingTime_3(), 0);
                    //else {
                    //    theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( ( long) theApp.GetSettings().GetProcessingTime_3() * 2, 0);
                    //}
                    
                    theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
                } else {
                    theApp.SetCurrentStepInProgress( true);
                    Init();
                }
            break;
            
            case 64:    //4.4 Заполнение рабочей смесью. выжержка
            {
                TechProcessStepCommon info = new TechProcessStepCommon();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт выдержки");
                theApp.SaveStepInfo( "064", info, true);
        
                theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                theApp.m_pMainWnd.m_pnlStopWatch.Init();
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetExcerptTime(), 0);
                
                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
                
            case 101:   //6.1 Тренировка катода. 1ый цикл. выдержка
            case 103:   //6.3 Тренировка катода. 2ой цикл. выдержка
            case 105:   //6.5 Тренировка катода. 3ий цикл. выдержка
            {
                TechProcessStepCommon info = new TechProcessStepCommon();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт выдержки");
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
                theApp.m_ReportGenerator.Generate();
        
                theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                theApp.m_pMainWnd.m_pnlStopWatch.Init();
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetExcerptTime(), 0);

                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
                
            case 102:   //6.2 Тренировка катода. 1ый цикл
            case 104:   //6.4 Тренировка катода. 2ой цикл
            case 106:   //6.6 Тренировка катода. 3ий цикл
            {
                TechProcessHvProcessInfo info = new TechProcessHvProcessInfo();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт " + ( 1 + ( theApp.GetCurrentStep() - 102) / 2) + "-го цикла тренировки");
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);

                theApp.m_ReportGenerator.Generate();

                theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_6());
                    
                //theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                //theApp.m_pMainWnd.m_pnlStopWatch.Init();
                //theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_6(), 0);
                
                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
                
            case 141:   //8.1 Выдержка тренировочной смеси
            case 143:   //8.3 Выдержка тренировочной смеси
            {
                TechProcessStepCommon info = new TechProcessStepCommon();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт выдержки");
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
                theApp.m_ReportGenerator.Generate();
        
                theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                theApp.m_pMainWnd.m_pnlStopWatch.Init();
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetExcerptTime(), 0);

                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
                
            case 142:   //8.2 Тренировка в тренировочной смеси. 1ый цикл.
            case 144:   //8.4 Тренировка в тренировочной смеси. 2ой цикл.
            {
                TechProcessHvProcessInfo info = new TechProcessHvProcessInfo();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт " + ( 1 + ( theApp.GetCurrentStep() - 142) / 2) + "-го цикла тренировки");
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);

                theApp.m_ReportGenerator.Generate();
                
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.setVisible( true);
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.Init();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.DropValues();
                theApp.m_pMainWnd.m_pnlEnterHvVoltage.StartTimer( theApp.GetSettings().GetProcessingTime_8());
                
                //theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                //theApp.m_pMainWnd.m_pnlStopWatch.Init();
                //theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetProcessingTime_8());
                
                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
            
            
            case 181:   //10.1 Выдержка
            {
                TechProcessStepCommon info = new TechProcessStepCommon();
                info.SetStartDateAsCurrent( theApp.GetSettings().GetTimeZoneShift());
                info.SetStartReportTitle( "Старт выдержки");
                theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
                theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
                theApp.m_pMainWnd.m_pnlStopWatch.Init();
                theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( theApp.GetSettings().GetExcerptTime(), 0);
                
                theApp.m_pMainWnd.m_pnlPuffMessage.setVisible( false);
            }
            break;
        }
        
        
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel lblMessageF;
    private javax.swing.JLabel lblMessageL;
    private javax.swing.JLabel lblMessageR;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
