/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hvv_admin4.panels;

import hvv_admin4.HVV_Admin4;
import hvv_admin4.HVV_Admin4Constants;
import hvv_admin4.steps.info.TechProcessStepCommon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelSetThermoProcessingFinishTime extends javax.swing.JPanel {
    final HVV_Admin4 theApp;
    static Logger logger = Logger.getLogger(PanelSetThermoProcessingFinishTime.class);
    public int m_nTimer;
    public int m_nFlasher;
    
    public Timer m_tmrRefreshTimer;
    
    final GregorianCalendar m_gdtmDate;
    public void initOnStart() {
        m_gdtmDate.setTime( theApp.GetLocalDate());
        m_gdtmDate.add( Calendar.HOUR, 25);
        
        updateData();
        
        TechProcessStepCommon info = new TechProcessStepCommon( theApp);
        info.SetStartDateAsCurrent();
        info.SetStartReportTitle( "Рассчёт времени окончания термообезгаживания");
        theApp.SaveStepInfo( String.format( "061", theApp.GetCurrentStep()), info, true);
        
        m_tmrRefreshTimer = new Timer( 60000, new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e) {
                updateData();
            }
        });
        m_tmrRefreshTimer.start();
        
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
     * Creates new form PanelProcess
     */
    public PanelSetThermoProcessingFinishTime( HVV_Admin4 app) {
        theApp = app;
        initComponents();
        m_gdtmDate = new GregorianCalendar();
        m_gdtmDate.setTime( theApp.GetLocalDate());
    }
    
    /*
    public void StartTimer( int nSeconds) {
        //мы начинаем процесс
        TechProcessStepInfo info = new TechProcessStepInfo( theApp);
        info.SetStartDateAsCurrent();
        switch( theApp.GetCurrentStep()) {
            case 21: info.SetStartReportTitle( "Старт первого цикла обработки"); break;
            case 23: info.SetStartReportTitle( "Старт второго цикла обработки"); break;
            case 41: info.SetStartReportTitle( "Старт первого цикла обработки"); break;
            case 43: info.SetStartReportTitle( "Старт второго цикла обработки"); break;
        }

        theApp.SaveStepInfo( String.format( "%03d", theApp.GetCurrentStep()), info, true);
        
        
        theApp.m_ReportGenerator.Generate();
        
        theApp.SetCurrentStepInProgress( true);
        
        btnNext.setEnabled( false);

        m_nTimer = nSeconds;
        lblSeconds.setText( String.format( "%02d:%02d:%02d",
                m_nTimer / 3600,
                (m_nTimer % 3600) / 60,
                m_nTimer % 60));
        
        new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m_nTimer--;
                int nHou = m_nTimer / 3600;
                int nMin = (m_nTimer % 3600) / 60;
                int nSec = m_nTimer % 60;
                lblSeconds.setText( String.format( "%02d:%02d:%02d", nHou, nMin, nSec));
                
                if( m_nTimer == 0) {
                    m_nFlasher = 6;
                    ( ( Timer) e.getSource()).stop();
                    new Timer( 500, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            m_nFlasher--;
                            if( ( m_nFlasher % 2) == 1)
                                lblSeconds.setForeground( new Color( 220, 220, 220));
                            else
                                lblSeconds.setForeground( new Color( 0, 0, 0));
                            
                            if( m_nFlasher == 0) {
                                ( ( Timer) e.getSource()).stop();
                                theApp.SetCurrentStepInProgress( false);
                                TechProcessStepInfo info = theApp.GetStepInfo( String.format( "%03d", theApp.GetCurrentStep()));
                                info.SetStopDateAsCurrent();
                                switch( theApp.GetCurrentStep()) {
                                    case 21: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 23: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 41: info.SetStopReportTitle( "Окончание обработки"); break;
                                    case 43: info.SetStopReportTitle( "Окончание обработки"); break;
                                }
                                
                                
                                btnNext.setEnabled( true);
                            }
                        }
                    }).start();
                }
            }
        }).start();
    }
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblDoW = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblTimerPointYM = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblPointMD = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        lblPointHM = new javax.swing.JLabel();
        lblMinute = new javax.swing.JLabel();
        lblFinish = new javax.swing.JLabel();
        lblFinishValue = new javax.swing.JLabel();
        lblFinishMin = new javax.swing.JLabel();
        lblTurnOn4v = new javax.swing.JLabel();
        lblTurnOn4vValue = new javax.swing.JLabel();
        lblTurnOn4vMin = new javax.swing.JLabel();
        lblTurnOn9v = new javax.swing.JLabel();
        lblTurnOn9vValue = new javax.swing.JLabel();
        lblTurnOn9vMin = new javax.swing.JLabel();
        lblTurnOff9v = new javax.swing.JLabel();
        lblTurnOff9vValue = new javax.swing.JLabel();
        lblTurnOff9vMin = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
        setMaximumSize(new java.awt.Dimension(640, 440));
        setMinimumSize(new java.awt.Dimension(640, 440));
        setPreferredSize(new java.awt.Dimension(640, 440));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("<html><u>4.1 Задание времени окончания термообезгаживания.</u></thml>");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTitle);
        lblTitle.setBounds(10, 10, 620, 40);

        lblDoW.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblDoW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoW.setText("чт");
        lblDoW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblDoW.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblDoWMouseWheelMoved(evt);
            }
        });
        add(lblDoW);
        lblDoW.setBounds(20, 60, 80, 110);

        lblYear.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYear.setText("2016");
        lblYear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblYear.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblYearMouseWheelMoved(evt);
            }
        });
        add(lblYear);
        lblYear.setBounds(300, 60, 150, 110);

        lblTimerPointYM.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblTimerPointYM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimerPointYM.setText(".");
        lblTimerPointYM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTimerPointYM);
        lblTimerPointYM.setBounds(200, 60, 10, 110);

        lblMonth.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonth.setText("09");
        lblMonth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblMonth.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblMonthMouseWheelMoved(evt);
            }
        });
        add(lblMonth);
        lblMonth.setBounds(210, 60, 80, 110);

        lblPointMD.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblPointMD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPointMD.setText(".");
        lblPointMD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblPointMD);
        lblPointMD.setBounds(290, 60, 10, 110);

        lblDay.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDay.setText("29");
        lblDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblDay.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblDayMouseWheelMoved(evt);
            }
        });
        add(lblDay);
        lblDay.setBounds(120, 60, 80, 110);

        lblHour.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHour.setText("16");
        lblHour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblHour.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblHourMouseWheelMoved(evt);
            }
        });
        add(lblHour);
        lblHour.setBounds(470, 60, 70, 110);

        lblPointHM.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblPointHM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPointHM.setText(":");
        lblPointHM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblPointHM);
        lblPointHM.setBounds(540, 60, 20, 110);

        lblMinute.setFont(new java.awt.Font("Cantarell", 0, 50)); // NOI18N
        lblMinute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinute.setText("41");
        lblMinute.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        lblMinute.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblMinuteMouseWheelMoved(evt);
            }
        });
        add(lblMinute);
        lblMinute.setBounds(560, 60, 70, 110);

        lblFinish.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblFinish.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFinish.setText("<html>Завершение термообезгаживания:</html>");
        lblFinish.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblFinish);
        lblFinish.setBounds(10, 180, 390, 40);

        lblFinishValue.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblFinishValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinishValue.setText("9940");
        lblFinishValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblFinishValue);
        lblFinishValue.setBounds(420, 180, 130, 40);

        lblFinishMin.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblFinishMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinishMin.setText("<html>мин</thml>");
        lblFinishMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblFinishMin);
        lblFinishMin.setBounds(570, 180, 60, 40);

        lblTurnOn4v.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOn4v.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTurnOn4v.setText("<html>Включение геттера 4V:</html>");
        lblTurnOn4v.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn4v);
        lblTurnOn4v.setBounds(10, 230, 390, 40);

        lblTurnOn4vValue.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblTurnOn4vValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOn4vValue.setText("9940");
        lblTurnOn4vValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn4vValue);
        lblTurnOn4vValue.setBounds(420, 230, 130, 40);

        lblTurnOn4vMin.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOn4vMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOn4vMin.setText("<html>мин</thml>");
        lblTurnOn4vMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn4vMin);
        lblTurnOn4vMin.setBounds(570, 230, 60, 40);

        lblTurnOn9v.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOn9v.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTurnOn9v.setText("<html>Включение геттера 9V:</html>");
        lblTurnOn9v.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn9v);
        lblTurnOn9v.setBounds(10, 280, 390, 40);

        lblTurnOn9vValue.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblTurnOn9vValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOn9vValue.setText("9940");
        lblTurnOn9vValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn9vValue);
        lblTurnOn9vValue.setBounds(420, 280, 130, 40);

        lblTurnOn9vMin.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOn9vMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOn9vMin.setText("<html>мин</thml>");
        lblTurnOn9vMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOn9vMin);
        lblTurnOn9vMin.setBounds(570, 280, 60, 40);

        lblTurnOff9v.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOff9v.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTurnOff9v.setText("<html>Отключение геттера 9V:</html>");
        lblTurnOff9v.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOff9v);
        lblTurnOff9v.setBounds(10, 330, 390, 40);

        lblTurnOff9vValue.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblTurnOff9vValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOff9vValue.setText("9940");
        lblTurnOff9vValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOff9vValue);
        lblTurnOff9vValue.setBounds(420, 330, 130, 40);

        lblTurnOff9vMin.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lblTurnOff9vMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnOff9vMin.setText("<html>мин</thml>");
        lblTurnOff9vMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTurnOff9vMin);
        lblTurnOff9vMin.setBounds(570, 330, 60, 40);

        btnNext.setText("Далее");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(10, 380, 620, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //Мы рассчитали длительность термообезнаживания, надо запустить процесс
        m_tmrRefreshTimer.stop();
        
        TechProcessStepCommon info = theApp.GetCommonStepInfo( "061");
        info.SetStopDateAsCurrent();
        info.SetStopReportTitle( "");
        
        theApp.SetCurrentStep( 62);
        theApp.SetCurrentStepInProgress( true);
        
        theApp.m_pMainWnd.m_pnlStopWatch.Init();
        theApp.m_pMainWnd.m_pnlStopWatch.setVisible( true);
        
        if( theApp.GetSettings().GetDebugShortenThermoProcessing()) {
            //DEBUG
            theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( ( long) 5410, 0);
        }
        else {
            //GOOD
            theApp.m_pMainWnd.m_pnlStopWatch.StartTimer( Integer.parseInt( lblFinishValue.getText()) * 60, 0);
        }
        
        theApp.SetDtmTOEnd( m_gdtmDate.getTime());
                
        theApp.m_pMainWnd.m_pnlSetThermoProcessingFinishTime.setVisible( false);
        theApp.m_ReportGenerator.Generate();
    }//GEN-LAST:event_btnNextActionPerformed

    public void updateData() {
        lblDay.setText( ( m_gdtmDate.get( Calendar.DAY_OF_MONTH) < 10 ? "0" : "") +
                        m_gdtmDate.get( Calendar.DAY_OF_MONTH));
        
        lblMonth.setText( ( m_gdtmDate.get( Calendar.MONTH) + 1 < 10 ? "0" : "") +
                          ( m_gdtmDate.get( Calendar.MONTH) + 1));
        
        lblYear.setText( ( m_gdtmDate.get( Calendar.YEAR) < 10 ? "0" : "") +
                         m_gdtmDate.get( Calendar.YEAR));
        
        lblHour.setText( ( m_gdtmDate.get( Calendar.HOUR_OF_DAY) < 10 ? "0" : "") +
                         m_gdtmDate.get( Calendar.HOUR_OF_DAY));
        
        lblMinute.setText( ( m_gdtmDate.get( Calendar.MINUTE) < 10 ? "0" : "") +
                            m_gdtmDate.get( Calendar.MINUTE));
        
        switch( m_gdtmDate.get( Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:   lblDoW.setText( "вс"); break;
            case Calendar.MONDAY:   lblDoW.setText( "пн"); break;
            case Calendar.TUESDAY:  lblDoW.setText( "вт"); break;
            case Calendar.WEDNESDAY:lblDoW.setText( "ср"); break;
            case Calendar.THURSDAY: lblDoW.setText( "чт"); break;
            case Calendar.FRIDAY:   lblDoW.setText( "пт"); break;
            case Calendar.SATURDAY: lblDoW.setText( "сб"); break;
            default: lblDoW.setText( "-"); break;
        }
        
        Date dtNow = theApp.GetLocalDate();
        Date dtFinish = m_gdtmDate.getTime();
        
        //окончание ТО
        long nSpan = ( long) ( Math.ceil( ( dtFinish.getTime() - dtNow.getTime()) / 1000. / 60. / 10.)) * 10;
        logger.trace( "dtFinish(msec): " + dtFinish.getTime() + "  dtNow(msec): " + dtNow.getTime() + "  SPAN(10m): " + nSpan);
        
        if( nSpan < 0) nSpan = 0;
        lblFinishValue.setText( "" + nSpan);
        
        
        if( theApp.GetSelectedArm() == HVV_Admin4Constants.ARM1 ||
            theApp.GetSelectedArm() == HVV_Admin4Constants.ARM2) {
            
            //включение 4v
            lblTurnOn4vValue.setText( "" + ( nSpan - 60));
            
            //включение 9v
            lblTurnOn9vValue.setText( "" + ( nSpan - 50));
            
            //выключение 9v
            lblTurnOff9vValue.setText( "" + ( nSpan - 5));
        }
        else {
            //включение 4v
            lblTurnOn4vValue.setText( "" + ( nSpan - 40));
            
            //включение 9v
            lblTurnOn9vValue.setText( "" + ( nSpan - 30));
            
            //выключение 9v
            lblTurnOff9vValue.setText( "" + ( nSpan - 5));
        }
        
    }
    
    private void lblYearMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblYearMouseWheelMoved
        m_gdtmDate.add( Calendar.YEAR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblYearMouseWheelMoved

    private void lblMonthMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblMonthMouseWheelMoved
        m_gdtmDate.add( Calendar.MONTH, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblMonthMouseWheelMoved

    private void lblDayMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblDayMouseWheelMoved
        m_gdtmDate.add( Calendar.DAY_OF_MONTH, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblDayMouseWheelMoved

    private void lblHourMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblHourMouseWheelMoved
        m_gdtmDate.add( Calendar.HOUR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblHourMouseWheelMoved

    private void lblMinuteMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblMinuteMouseWheelMoved
        m_gdtmDate.add( Calendar.MINUTE, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblMinuteMouseWheelMoved

    private void lblDoWMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblDoWMouseWheelMoved
        m_gdtmDate.add( Calendar.DAY_OF_MONTH, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblDoWMouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDoW;
    private javax.swing.JLabel lblFinish;
    private javax.swing.JLabel lblFinishMin;
    private javax.swing.JLabel lblFinishValue;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblPointHM;
    private javax.swing.JLabel lblPointMD;
    private javax.swing.JLabel lblTimerPointYM;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTurnOff9v;
    private javax.swing.JLabel lblTurnOff9vMin;
    private javax.swing.JLabel lblTurnOff9vValue;
    private javax.swing.JLabel lblTurnOn4v;
    private javax.swing.JLabel lblTurnOn4vMin;
    private javax.swing.JLabel lblTurnOn4vValue;
    private javax.swing.JLabel lblTurnOn9v;
    private javax.swing.JLabel lblTurnOn9vMin;
    private javax.swing.JLabel lblTurnOn9vValue;
    private javax.swing.JLabel lblYear;
    // End of variables declaration//GEN-END:variables
}
