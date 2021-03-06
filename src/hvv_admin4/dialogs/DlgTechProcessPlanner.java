package hvv_admin4.dialogs;

import hvv_admin4.HVV_Admin4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaroslav
 */
public class DlgTechProcessPlanner extends javax.swing.JDialog {

    public boolean m_bOk;
    
    static Logger logger = Logger.getLogger(DlgTechProcessPlanner.class);
    final private HVV_Admin4 theApp;
    
    public long m_lRelativeMinutes;
    
    public GregorianCalendar m_gdtmDate;
    
    private Timer m_tmRefreshTimer;
    private int m_nStep;
    
    /**
     * Creates new form TechProcessStep2_1_Dlg
     */
    public DlgTechProcessPlanner( HVV_Admin4 app, java.awt.Frame parent, boolean modal, String strStepTitle, int nStep) {
        super( parent, modal);
        theApp = app;
        initComponents();
        
        m_lRelativeMinutes = 60;
        
        m_nStep = nStep;
    
        m_gdtmDate = new GregorianCalendar();
        m_gdtmDate.setTime( theApp.GetLocalDate());
        m_gdtmDate.add( Calendar.MONTH, 1);
                
        m_tmRefreshTimer = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
        m_tmRefreshTimer.start();
        
        lblWelcome.setText( lblWelcome.getText() + " " + strStepTitle);
        m_bOk = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        radAbsolute = new javax.swing.JRadioButton();
        radRelative = new javax.swing.JRadioButton();
        lblPoint1 = new javax.swing.JLabel();
        lblStartDay = new javax.swing.JLabel();
        lblStartYear = new javax.swing.JLabel();
        lblPoint2 = new javax.swing.JLabel();
        lblStartMonth = new javax.swing.JLabel();
        lblStartHour = new javax.swing.JLabel();
        lblDblPoint = new javax.swing.JLabel();
        lblStartMinutes = new javax.swing.JLabel();
        lblRelativeDays = new javax.swing.JLabel();
        lblRelDays = new javax.swing.JLabel();
        lblRelativeHours = new javax.swing.JLabel();
        lblRelHours = new javax.swing.JLabel();
        lblRelativeMinutes = new javax.swing.JLabel();
        lblRelMinutes = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnDefaultRelativeTime = new javax.swing.JButton();
        lblStartDow = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Планировщик этапа");
        setMinimumSize(new java.awt.Dimension(730, 300));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Для справки, среднее время проведения этапа:");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 700, 30);

        btnClose.setText("Закрыть");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(450, 210, 120, 40);

        buttonGroup1.add(radAbsolute);
        radAbsolute.setText("абсолютные дата-время");
        radAbsolute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radAbsoluteActionPerformed(evt);
            }
        });
        getContentPane().add(radAbsolute);
        radAbsolute.setBounds(30, 150, 260, 50);

        buttonGroup1.add(radRelative);
        radRelative.setSelected(true);
        radRelative.setText("относительно предыдущего этапа - через:");
        radRelative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radRelativeActionPerformed(evt);
            }
        });
        getContentPane().add(radRelative);
        radRelative.setBounds(30, 80, 320, 50);

        lblPoint1.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblPoint1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoint1.setText(".");
        lblPoint1.setEnabled(false);
        getContentPane().add(lblPoint1);
        lblPoint1.setBounds(410, 150, 10, 40);

        lblStartDay.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartDay.setText("-");
        lblStartDay.setEnabled(false);
        lblStartDay.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartDayMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartDay);
        lblStartDay.setBounds(360, 150, 50, 40);

        lblStartYear.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartYear.setText("-");
        lblStartYear.setToolTipText("");
        lblStartYear.setEnabled(false);
        lblStartYear.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartYearMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartYear);
        lblStartYear.setBounds(480, 150, 100, 40);

        lblPoint2.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblPoint2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoint2.setText(".");
        lblPoint2.setEnabled(false);
        getContentPane().add(lblPoint2);
        lblPoint2.setBounds(470, 150, 10, 40);

        lblStartMonth.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartMonth.setText("-");
        lblStartMonth.setEnabled(false);
        lblStartMonth.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartMonthMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartMonth);
        lblStartMonth.setBounds(420, 150, 50, 40);

        lblStartHour.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartHour.setText("-");
        lblStartHour.setEnabled(false);
        lblStartHour.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartHourMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartHour);
        lblStartHour.setBounds(590, 150, 50, 40);

        lblDblPoint.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblDblPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDblPoint.setText(":");
        lblDblPoint.setEnabled(false);
        getContentPane().add(lblDblPoint);
        lblDblPoint.setBounds(640, 150, 10, 40);

        lblStartMinutes.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartMinutes.setText("-");
        lblStartMinutes.setEnabled(false);
        lblStartMinutes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartMinutesMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartMinutes);
        lblStartMinutes.setBounds(650, 150, 50, 40);

        lblRelativeDays.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblRelativeDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRelativeDays.setText("-");
        lblRelativeDays.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblRelativeDaysMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblRelativeDays);
        lblRelativeDays.setBounds(360, 80, 50, 40);

        lblRelDays.setText("дней");
        getContentPane().add(lblRelDays);
        lblRelDays.setBounds(410, 90, 40, 30);

        lblRelativeHours.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblRelativeHours.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRelativeHours.setText("-");
        lblRelativeHours.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblRelativeHoursMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblRelativeHours);
        lblRelativeHours.setBounds(450, 80, 50, 40);

        lblRelHours.setText("часов");
        getContentPane().add(lblRelHours);
        lblRelHours.setBounds(500, 90, 40, 30);

        lblRelativeMinutes.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblRelativeMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRelativeMinutes.setText("-");
        lblRelativeMinutes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblRelativeMinutesMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblRelativeMinutes);
        lblRelativeMinutes.setBounds(540, 80, 50, 40);

        lblRelMinutes.setText("минут");
        getContentPane().add(lblRelMinutes);
        lblRelMinutes.setBounds(590, 90, 40, 30);

        lblWelcome.setText("Выберите метод планирования времени начала этапа");
        getContentPane().add(lblWelcome);
        lblWelcome.setBounds(10, 10, 700, 30);

        btnDefaultRelativeTime.setText("default");
        btnDefaultRelativeTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultRelativeTimeActionPerformed(evt);
            }
        });
        getContentPane().add(btnDefaultRelativeTime);
        btnDefaultRelativeTime.setBounds(640, 85, 60, 40);

        lblStartDow.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        lblStartDow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartDow.setText("-");
        lblStartDow.setEnabled(false);
        lblStartDow.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                lblStartDowMouseWheelMoved(evt);
            }
        });
        getContentPane().add(lblStartDow);
        lblStartDow.setBounds(290, 140, 50, 60);

        btnCancel.setText("Отмена");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(580, 210, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        m_bOk = true;
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void updateData() {
        
        lblStartDay.setText( ( m_gdtmDate.get( Calendar.DAY_OF_MONTH) < 10 ? "0" : "") +
                        m_gdtmDate.get( Calendar.DAY_OF_MONTH));
        
        lblStartMonth.setText( ( m_gdtmDate.get( Calendar.MONTH) + 1 < 10 ? "0" : "") +
                          ( m_gdtmDate.get( Calendar.MONTH) + 1));
        
        lblStartYear.setText( ( m_gdtmDate.get( Calendar.YEAR) < 10 ? "0" : "") +
                         m_gdtmDate.get( Calendar.YEAR));
        
        lblStartHour.setText( ( m_gdtmDate.get( Calendar.HOUR_OF_DAY) < 10 ? "0" : "") +
                         m_gdtmDate.get( Calendar.HOUR_OF_DAY));
        
        lblStartMinutes.setText( ( m_gdtmDate.get( Calendar.MINUTE) < 10 ? "0" : "") +
                            m_gdtmDate.get( Calendar.MINUTE));
        
        switch( m_gdtmDate.get( Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:   lblStartDow.setText( "вс"); break;
            case Calendar.MONDAY:   lblStartDow.setText( "пн"); break;
            case Calendar.TUESDAY:  lblStartDow.setText( "вт"); break;
            case Calendar.WEDNESDAY:lblStartDow.setText( "ср"); break;
            case Calendar.THURSDAY: lblStartDow.setText( "чт"); break;
            case Calendar.FRIDAY:   lblStartDow.setText( "пт"); break;
            case Calendar.SATURDAY: lblStartDow.setText( "сб"); break;
            default: lblStartDow.setText( "-"); break;
        }
        
             
        lblRelativeDays.setText(     "" +   m_lRelativeMinutes / 60  / 24);
        lblRelativeHours.setText(    "" + ( m_lRelativeMinutes / 60) % 24);
        lblRelativeMinutes.setText(  "" +   m_lRelativeMinutes % 60);
    }
        
    private void lblStartDayMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartDayMouseWheelMoved
        if( !lblStartDay.isEnabled()) return;
        m_gdtmDate.add( Calendar.DAY_OF_MONTH, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblStartDayMouseWheelMoved

    private void lblStartYearMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartYearMouseWheelMoved
        if( !lblStartYear.isEnabled()) return;
        m_gdtmDate.add( Calendar.YEAR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblStartYearMouseWheelMoved

    private void lblStartMonthMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartMonthMouseWheelMoved
        if( !lblStartMonth.isEnabled()) return;
        m_gdtmDate.add( Calendar.MONTH, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblStartMonthMouseWheelMoved

    private void lblStartHourMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartHourMouseWheelMoved
        if( !lblStartHour.isEnabled()) return;
        m_gdtmDate.add( Calendar.HOUR, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblStartHourMouseWheelMoved

    private void lblStartMinutesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartMinutesMouseWheelMoved
        if( !lblStartMinutes.isEnabled()) return;
        m_gdtmDate.add( Calendar.MINUTE, -1 * evt.getWheelRotation());
        updateData();
    }//GEN-LAST:event_lblStartMinutesMouseWheelMoved

    private void lblRelativeDaysMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblRelativeDaysMouseWheelMoved
        if( !lblRelativeDays.isEnabled()) return;
        m_lRelativeMinutes -= ( evt.getWheelRotation() * 60 * 24);
        if( m_lRelativeMinutes < 5) m_lRelativeMinutes = 5;
    }//GEN-LAST:event_lblRelativeDaysMouseWheelMoved

    private void lblRelativeHoursMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblRelativeHoursMouseWheelMoved
        if( !lblRelativeHours.isEnabled()) return;
        m_lRelativeMinutes -= ( evt.getWheelRotation() * 60);
        if( m_lRelativeMinutes < 5) m_lRelativeMinutes = 5;
    }//GEN-LAST:event_lblRelativeHoursMouseWheelMoved

    private void lblRelativeMinutesMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblRelativeMinutesMouseWheelMoved
        if( !lblRelativeMinutes.isEnabled()) return;
        m_lRelativeMinutes -= evt.getWheelRotation();
        if( m_lRelativeMinutes < 5) m_lRelativeMinutes = 5;
    }//GEN-LAST:event_lblRelativeMinutesMouseWheelMoved

    public void SetControls( boolean bAbsolute) {
        lblRelativeDays.setEnabled( !bAbsolute);
        lblRelDays.setEnabled( !bAbsolute);
        lblRelativeHours.setEnabled( !bAbsolute);
        lblRelHours.setEnabled( !bAbsolute);
        lblRelativeMinutes.setEnabled( !bAbsolute);
        lblRelMinutes.setEnabled( !bAbsolute);
        btnDefaultRelativeTime.setEnabled( !bAbsolute);
        
        lblStartDow.setEnabled( bAbsolute);
        lblStartDay.setEnabled( bAbsolute);
        lblPoint1.setEnabled( bAbsolute);
        lblStartMonth.setEnabled( bAbsolute);
        lblPoint1.setEnabled( bAbsolute);
        lblStartYear.setEnabled( bAbsolute);
        lblStartHour.setEnabled( bAbsolute);
        lblDblPoint.setEnabled( bAbsolute);
        lblStartMinutes.setEnabled( bAbsolute);
    }
    
    private void radAbsoluteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radAbsoluteActionPerformed
        SetControls( true);
    }//GEN-LAST:event_radAbsoluteActionPerformed

    private void radRelativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radRelativeActionPerformed
        SetControls( false);
    }//GEN-LAST:event_radRelativeActionPerformed

    private void btnDefaultRelativeTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultRelativeTimeActionPerformed
        switch( m_nStep) {
            case  2: m_lRelativeMinutes =  30; break;
            case  3: m_lRelativeMinutes = 150; break;
            case  4: m_lRelativeMinutes = 150; break;
            case  5: m_lRelativeMinutes = 240; break;
            case  6: m_lRelativeMinutes = 2400; break;
            case  7: m_lRelativeMinutes = 90; break;
            case  8: m_lRelativeMinutes = 660; break;
            case  9: m_lRelativeMinutes = 150; break;
            case 10: m_lRelativeMinutes = 60*24; break;
            case 11: m_lRelativeMinutes = 300; break;
            case 12: m_lRelativeMinutes = 120; break;
            case 13: m_lRelativeMinutes = 60; break;
            default: m_lRelativeMinutes = 5; break;
        }
    }//GEN-LAST:event_btnDefaultRelativeTimeActionPerformed

    private void lblStartDowMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_lblStartDowMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblStartDowMouseWheelMoved

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        m_bOk = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgTechProcessPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgTechProcessPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgTechProcessPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgTechProcessPlanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgTechProcessPlanner dialog = new DlgTechProcessPlanner( null, new javax.swing.JFrame(), true, "TEST", 2);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDefaultRelativeTime;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDblPoint;
    private javax.swing.JLabel lblPoint1;
    private javax.swing.JLabel lblPoint2;
    private javax.swing.JLabel lblRelDays;
    private javax.swing.JLabel lblRelHours;
    private javax.swing.JLabel lblRelMinutes;
    private javax.swing.JLabel lblRelativeDays;
    private javax.swing.JLabel lblRelativeHours;
    private javax.swing.JLabel lblRelativeMinutes;
    private javax.swing.JLabel lblStartDay;
    private javax.swing.JLabel lblStartDow;
    private javax.swing.JLabel lblStartHour;
    private javax.swing.JLabel lblStartMinutes;
    private javax.swing.JLabel lblStartMonth;
    private javax.swing.JLabel lblStartYear;
    private javax.swing.JLabel lblWelcome;
    public javax.swing.JRadioButton radAbsolute;
    public javax.swing.JRadioButton radRelative;
    // End of variables declaration//GEN-END:variables
}
